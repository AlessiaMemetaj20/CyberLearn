package com.alessia.cyberlearn

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.alessia.cyberlearn.adapters.TopicAdapter
import com.alessia.cyberlearn.data.TopicRepository
import com.alessia.cyberlearn.databinding.ActivityMainBinding
import kotlin.jvm.java

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.rvTopics.layoutManager = LinearLayoutManager(this)
        binding.rvTopics.adapter = TopicAdapter(TopicRepository.topics) { topic ->
            openLesson(topic.id)
        }
    }

    private fun openLesson(topicId: Int) {
        val intent = Intent(this, LessonActivity::class.java).apply {
            putExtra(EXTRA_TOPIC_ID, topicId)
        }
        startActivity(intent)
    }

    companion object {
        const val EXTRA_TOPIC_ID = "extra_topic_id"
    }
}