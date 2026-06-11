package com.alessia.cyberlearn.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alessia.cyberlearn.databinding.ItemTopicBinding
import com.alessia.cyberlearn.models.Topic

class TopicAdapter(
    private val topics: List<Topic>,
    private val onClick: (Topic) -> Unit
) : RecyclerView.Adapter<TopicAdapter.TopicViewHolder>() {

    inner class TopicViewHolder(val binding: ItemTopicBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicViewHolder {
        val binding = ItemTopicBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return TopicViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TopicViewHolder, position: Int) {
        val topic = topics[position]
        holder.binding.apply {
            ivIcon.setImageResource(topic.iconResId)
            tvTitle.text = topic.title
            tvSubtitle.text = topic.subtitle
            root.setOnClickListener { onClick(topic) }
        }
    }

    override fun getItemCount(): Int = topics.size
}