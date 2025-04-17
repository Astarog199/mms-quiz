package com.moneymanagementservices.quiz.ui.quiz.present.list.adapter

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.moneymanagementservices.quiz.databinding.ItemListBinding
import com.moneymanagementservices.quiz.ui.quiz.present.models.PresentationInvestmentTests
import coil.load
import com.moneymanagementservices.quiz.R

class ListHolder(
    private val binding: ItemListBinding,
    private val onClick: (PresentationInvestmentTests) -> Unit,
    private val context: Context
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: PresentationInvestmentTests) {
    val descriptionText = ContextCompat.getString(context, R.string.description_test_second)


        with(binding) {
            if (item.result) image.load(R.drawable.best_results)
            else image.load(R.drawable.exam)
            description.text = "${item.answers} $descriptionText  ${item.question}"
            title.text = item.theme
            root.setOnClickListener {
                onClick(item)
            }
        }
    }
}