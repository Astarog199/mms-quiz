package com.moneymanagementservices.quiz.ui.start.present.list.adapter

import androidx.recyclerview.widget.RecyclerView
import com.moneymanagementservices.quiz.databinding.ItemStartBinding


class StartHolder(
    private val binding: ItemStartBinding,
    private val onClick: (String) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {


    fun bind(item: String) {
        with(binding) {
            title.text = item
            root.setOnClickListener { onClick(item) }
        }
    }
}