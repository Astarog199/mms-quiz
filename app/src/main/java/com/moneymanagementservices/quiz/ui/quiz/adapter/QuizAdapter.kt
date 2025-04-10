package com.moneymanagementservices.quiz.ui.quiz.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.moneymanagementservices.quiz.databinding.ItemQuizBinding
import com.moneymanagementservices.quiz.ui.models.PresentationEntity
import javax.inject.Inject

class QuizAdapter @Inject constructor(
    private val onClick: (PresentationEntity) -> Unit
) : RecyclerView.Adapter<QuizHolder>() {
    private var values:List<PresentationEntity> = emptyList()
    private var index = 0

    fun setData(data: List<PresentationEntity>, index: Int){
        this.values = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizHolder {
        return QuizHolder(
            ItemQuizBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            onClick = onClick
        )
    }

    override fun getItemCount(): Int = values.size

    override fun onBindViewHolder(holder: QuizHolder, position: Int) {
        val item = values.getOrNull(index)
        holder.bind(item)
    }
}