package com.moneymanagementservices.quiz.ui.start.present.details.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.moneymanagementservices.quiz.databinding.ItemEducationBinding
import com.moneymanagementservices.quiz.ui.start.present.details.models.EducationPresent
import javax.inject.Inject

class EducationAdapter @Inject constructor(

) : RecyclerView.Adapter<EducationHolder>() {
    private var values:List<EducationPresent> = emptyList()
    private lateinit var context: Context

    fun setData(data: List<EducationPresent>){
        this.values = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EducationHolder {
        return EducationHolder(
            ItemEducationBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            context = context
        )
    }

    override fun getItemCount(): Int = values.size

    override fun onBindViewHolder(holder: EducationHolder, position: Int) {
        val item = values.getOrNull(position)
        holder.bind(item)
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
    }
}