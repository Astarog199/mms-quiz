package com.moneymanagementservices.quiz.ui.start.present.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.moneymanagementservices.quiz.databinding.ItemStartBinding
import javax.inject.Inject

class StartAdapter @Inject constructor(
    private val onClick: (String) -> Unit
) : RecyclerView.Adapter<StartHolder>() {
    private var values:List<String> = emptyList()

    fun setData(data: List<String>){
        this.values = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StartHolder {
        return StartHolder(
            ItemStartBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            onClick = onClick
        )
    }

    override fun getItemCount(): Int = values.size

    override fun onBindViewHolder(holder: StartHolder, position: Int) {
        val item = values.getOrNull(position)
        item?.let { holder.bind(item) }
    }
}