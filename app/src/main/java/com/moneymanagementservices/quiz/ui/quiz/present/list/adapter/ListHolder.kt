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

        with(binding) {
            when(item.result) {
                true -> image.load(R.drawable.exam_passed)
                false -> image.load(R.drawable.exam_failed)
                else -> image.load(R.drawable.before_exam)
            }
            val descriptionText = context.resources.getString(R.string.description_test_second, "${item.answers}", "${item.question}")
            description.text = descriptionText
            title.text = item.theme
            root.setOnClickListener { onClick(item) }
        }
    }
}