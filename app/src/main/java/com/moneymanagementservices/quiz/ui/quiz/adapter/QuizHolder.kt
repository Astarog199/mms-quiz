package com.moneymanagementservices.quiz.ui.quiz.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.moneymanagementservices.quiz.databinding.ItemQuizBinding
import com.moneymanagementservices.quiz.ui.models.PresentationEntity

class QuizHolder(
    private val binding: ItemQuizBinding,
    private val onClick: (PresentationEntity) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {


    fun bind(item: PresentationEntity?) {
    }
}