package com.alessia.cyberlearn

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.alessia.cyberlearn.data.TopicRepository
import com.alessia.cyberlearn.databinding.ActivityQuizBinding
import com.alessia.cyberlearn.models.Question
import com.google.android.material.button.MaterialButton

/**
 * Quiz screen — shows multiple-choice questions one at a time.
 * After the last question, the same screen switches to result mode
 * with the final score and a share button (implicit Intent).
 */
class QuizActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuizBinding
    private lateinit var questions: List<Question>
    private var currentIndex = 0
    private var score = 0
    private var answered = false   // prevents tapping multiple options for the same question

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Load the topic that was passed in
        val topicId = intent.getIntExtra(MainActivity.EXTRA_TOPIC_ID, -1)
        val topic = TopicRepository.getById(topicId)
        if (topic == null) {
            Toast.makeText(this, "Topic not found", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        questions = topic.questions
        binding.tvQuizTopicTitle.text = "${topic.title} Quiz"

        showQuestion()
        wireButtons()
    }

    /** Wires the 4 option buttons + Next button. */
    private fun wireButtons() {
        val optionButtons = listOf(
            binding.btnOption0,
            binding.btnOption1,
            binding.btnOption2,
            binding.btnOption3
        )

        // Each option button passes its index to handleAnswer
        optionButtons.forEachIndexed { index, button ->
            button.setOnClickListener { handleAnswer(index, optionButtons) }
        }

        binding.btnNext.setOnClickListener {
            currentIndex++
            if (currentIndex >= questions.size) {
                showResult()
            } else {
                showQuestion()
            }
        }
    }

    /** Renders the current question + 4 options, resets button styles. */
    private fun showQuestion() {
        val q = questions[currentIndex]
        binding.tvProgress.text = "Question ${currentIndex + 1} of ${questions.size}"
        binding.tvQuestion.text = q.text

        val buttons = listOf(
            binding.btnOption0,
            binding.btnOption1,
            binding.btnOption2,
            binding.btnOption3
        )
        buttons.forEachIndexed { index, button ->
            button.text = q.options[index]
            resetButtonStyle(button)
            button.isEnabled = true
        }

        binding.btnNext.visibility = android.view.View.GONE
        answered = false
    }

    /**
     * Called when the user taps an option button.
     * Colors the selected button green (correct) or red (wrong),
     * highlights the correct answer, then reveals the Next button.
     */
    private fun handleAnswer(selectedIndex: Int, buttons: List<MaterialButton>) {
        if (answered) return        // ignore subsequent taps
        answered = true

        val correctIndex = questions[currentIndex].correctIndex

        // Color the correct answer green
        colorButton(buttons[correctIndex], R.color.correct)

        // If wrong, also color the selected one red
        if (selectedIndex == correctIndex) {
            score++
        } else {
            colorButton(buttons[selectedIndex], R.color.incorrect)
        }

        // Lock all buttons so the user can't change the answer
        buttons.forEach { it.isEnabled = false }

        binding.btnNext.visibility = android.view.View.VISIBLE
    }

    /** Fills a button with a solid color and white text. */
    private fun colorButton(button: MaterialButton, colorRes: Int) {
        val color = ContextCompat.getColor(this, colorRes)
        button.setBackgroundColor(color)
        button.setTextColor(Color.WHITE)
        button.strokeWidth = 0
    }

    /** Restores the default outlined look. */
    private fun resetButtonStyle(button: MaterialButton) {
        button.setBackgroundColor(Color.TRANSPARENT)
        button.setTextColor(ContextCompat.getColor(this, R.color.text_primary))
        button.strokeWidth = 2
    }

    /** Switches the layout from quiz mode to result mode. */
    private fun showResult() {
        binding.quizSection.visibility = android.view.View.GONE
        binding.resultSection.visibility = android.view.View.VISIBLE

        binding.tvFinalScore.text = "$score / ${questions.size}"
        binding.tvBadge.text = when {
            score == questions.size -> "🏆 Perfect score! Cyber expert!"
            score >= 4 -> "🛡️ Great job! You're a cyber-aware citizen."
            score >= 2 -> "👍 Not bad — review the lesson and try again."
            else -> "📚 Keep learning — review the lesson and retake the quiz."
        }

        // SHARE button — implicit Intent to send the score anywhere
        binding.btnShare.setOnClickListener {
            val shareText = getString(R.string.share_text, score, questions.size)
            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, shareText)
            }
            startActivity(Intent.createChooser(shareIntent, "Share your score via"))
        }

        // BACK HOME button — finish all activities above MainActivity
        binding.btnBackHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            }
            startActivity(intent)
            finish()
        }
    }
}