package com.alessia.cyberlearn

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.alessia.cyberlearn.data.TopicRepository
import com.alessia.cyberlearn.databinding.ActivityLessonBinding

/**
 * Lesson screen — displays the title, image, and explanation text for one topic.
 * The topic id arrives as an Intent extra from MainActivity.
 * Tapping "Start Quiz" opens QuizActivity, passing the same id forward.
 */
class LessonActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLessonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLessonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve the topic id sent from MainActivity
        val topicId = intent.getIntExtra(MainActivity.EXTRA_TOPIC_ID, -1)
        val topic = TopicRepository.getById(topicId)

        // Safety check — if we somehow got an invalid id, go back
        if (topic == null) {
            Toast.makeText(this, "Topic not found", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        // Populate the views
        binding.tvLessonTitle.text = topic.title
        binding.tvLessonSubtitle.text = topic.subtitle
        binding.tvLessonText.text = topic.lessonText
        binding.ivLessonImage.setImageResource(topic.iconResId)

        // Wire up the quiz button
        binding.btnStartQuiz.setOnClickListener {
            val intent = Intent(this, QuizActivity::class.java).apply {
                putExtra(MainActivity.EXTRA_TOPIC_ID, topic.id)
            }
            startActivity(intent)
        }
    }
}