package com.moneymanagementservices.quiz.ui.start.present.details.adapter

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.moneymanagementservices.quiz.databinding.ItemEducationBinding
import com.moneymanagementservices.quiz.ui.start.present.details.models.EducationPresent

class EducationHolder (
    private val binding: ItemEducationBinding,
    private val context: Context
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: EducationPresent?){
        item?.let {
            with(binding) {
                head.text = item.head
                definitions.text = formatDefinitions(item.definitions)
                firstParagraph.text = item.firstParagraph
                twoParagraph.text = item.twoParagraph
                threeParagraph.text = item.threeParagraph
                fourParagraph.text = item.fourParagraph

                head.visibility = if (item.head.isBlank()) View.GONE else View.VISIBLE
                definitions.visibility = if (item.head.isBlank()) View.GONE else View.VISIBLE
                firstParagraph.visibility = if (item.firstParagraph.isBlank()) View.GONE else View.VISIBLE
                twoParagraph.visibility = if (item.twoParagraph.isBlank()) View.GONE else View.VISIBLE
                threeParagraph.visibility = if (item.threeParagraph.isBlank()) View.GONE else View.VISIBLE
                fourParagraph.visibility = if (item.fourParagraph.isBlank()) View.GONE else View.VISIBLE
            }
        }
    }

    private fun formatDefinitions(definitions: String): SpannableString {

            val string = SpannableString(definitions)
            val index = definitions.indexOf("—")

            if (index != -1) {
                string.setSpan(StyleSpan(Typeface.BOLD), 0, index, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                string.setSpan(StyleSpan(Typeface.ITALIC), 0, index, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                string.setSpan(ForegroundColorSpan(Color.WHITE), 0, index, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            } else {
                Log.d("EducationHolder", "Символ '—' не найден в тексте.")
            }

        return string
    }
}