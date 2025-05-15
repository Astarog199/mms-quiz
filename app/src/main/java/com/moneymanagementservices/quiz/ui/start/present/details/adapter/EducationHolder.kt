package com.moneymanagementservices.quiz.ui.start.present.details.adapter

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.moneymanagementservices.quiz.databinding.ItemEducationBinding
import com.moneymanagementservices.quiz.ui.start.present.details.models.EducationPresent

class EducationHolder(
    private val binding: ItemEducationBinding,
    private val context: Context
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: EducationPresent?) {
        item?.let {
            with(binding) {
                head.text = item.head
                definitions.text = formatDefinitions(item.definitions)
                firstParagraph.text = formatParagraph(item.firstParagraph)
                twoParagraph.text = formatParagraph(item.twoParagraph)
                threeParagraph.text = formatParagraph(item.threeParagraph)
                fourParagraph.text = formatParagraph(item.fourParagraph)

                head.visibility =
                    if (item.head.isBlank()) View.GONE else View.VISIBLE
                definitions.visibility =
                    if (item.definitions.isBlank()) View.GONE else View.VISIBLE
                firstParagraph.visibility =
                    if (item.firstParagraph.isBlank()) View.GONE else View.VISIBLE
                twoParagraph.visibility =
                    if (item.twoParagraph.isBlank()) View.GONE else View.VISIBLE
                threeParagraph.visibility =
                    if (item.threeParagraph.isBlank()) View.GONE else View.VISIBLE
                fourParagraph.visibility =
                    if (item.fourParagraph.isBlank()) View.GONE else View.VISIBLE
            }
        }
    }

    private fun formatDefinitions(definitions: String): SpannableString {
        var start = 0
        val string = SpannableString(definitions)

        string.forEachIndexed { index, char ->
            when (char) {
                '.' -> start = index + 1
                '—' -> formatText(string, start, index)
            }
        }

        return string
    }

    private fun formatParagraph(string: String): SpannableString {
        val instructions = checkText(string)
        val text = SpannableString(string)
        return if (instructions.first) formatText(text =  text, start = 0, end = instructions.second) else text
    }

    private fun formatText(text: SpannableString, start: Int, end:Int): SpannableString {
        text.setSpan(StyleSpan(Typeface.BOLD), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        text.setSpan(StyleSpan(Typeface.ITALIC), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        text.setSpan(ForegroundColorSpan(Color.WHITE), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        return text
    }

    private fun checkText(text: String): Pair<Boolean, Int> {
        val array = listOf("Пример:", "Кратко:")
        for (i in array) {
            if (text.startsWith(i)) return Pair(true, i.length)
        }
        return Pair(false, 0)
    }
}