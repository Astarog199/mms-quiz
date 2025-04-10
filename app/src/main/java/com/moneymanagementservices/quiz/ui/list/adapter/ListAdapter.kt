package com.moneymanagementservices.quiz.ui.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.moneymanagementservices.quiz.databinding.ItemListBinding
import com.moneymanagementservices.quiz.ui.models.PresentationEntity
import com.moneymanagementservices.quiz.ui.models.PresentationInvestmentTests
import javax.inject.Inject

class ListAdapter @Inject constructor(
    private val onClick: (PresentationInvestmentTests) -> Unit
): RecyclerView.Adapter<ListHolder>() {
    private var values:List<PresentationInvestmentTests> = emptyList()

    fun setData(data: List<PresentationInvestmentTests>){
        this.values = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHolder {
        return ListHolder(
            ItemListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            onClick = onClick
        )
    }

    override fun getItemCount(): Int = values.size

    override fun onBindViewHolder(holder: ListHolder, position: Int) {
        val item = values.getOrNull(position)
        holder.bind(item)
    }
}