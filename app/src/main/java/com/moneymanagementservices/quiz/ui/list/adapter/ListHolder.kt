package com.moneymanagementservices.quiz.ui.list.adapter

import androidx.recyclerview.widget.RecyclerView
import com.moneymanagementservices.quiz.databinding.ItemListBinding
import com.moneymanagementservices.quiz.ui.models.PresentationInvestmentTests

class ListHolder(
    private val binding: ItemListBinding,
    private val onClick: (PresentationInvestmentTests) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: PresentationInvestmentTests?) {
        binding.title.text = item?.theme

        binding.root.setOnClickListener {
            item?.let {
                onClick(item)
            }
        }
    }
}