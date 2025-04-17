package com.moneymanagementservices.quiz.ui.start.present.list.adapter

import androidx.recyclerview.widget.RecyclerView
import com.moneymanagementservices.quiz.databinding.ItemStartBinding
import com.moneymanagementservices.quiz.ui.start.present.list.PresentEntity


class StartHolder(
    private val binding: ItemStartBinding,
    private val onClick: (PresentEntity) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {


    fun bind(item: PresentEntity) {
        with(binding) {
            title.text = item.title
            root.setOnClickListener { onClick(item) }
        }
    }
}