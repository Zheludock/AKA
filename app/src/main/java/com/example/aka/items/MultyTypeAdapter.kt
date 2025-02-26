package com.example.aka.items

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aka.R

class MultiTypeAdapter(private val items: List<CharlistItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_HEADER = 0
        private const val TYPE_TABLE_ITEM = 1
        private const val TYPE_SKILL = 2
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is CharlistItem.Header -> TYPE_HEADER
            is CharlistItem.TableItem -> TYPE_TABLE_ITEM
            is CharlistItem.Skill -> TYPE_SKILL
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_HEADER -> HeaderViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_header, parent, false)
            )
            TYPE_TABLE_ITEM -> TableItemViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_table_row, parent, false)
            )
            TYPE_SKILL -> SkillViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_skill, parent, false)
            )
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = items[position]) {
            is CharlistItem.Header -> (holder as HeaderViewHolder).bind(item.title)
            is CharlistItem.TableItem -> (holder as TableItemViewHolder).bind(item.charName, item.value, item.modifier)
            is CharlistItem.Skill -> (holder as SkillViewHolder).bind(item.name, item.value)
        }
    }

    override fun getItemCount(): Int = items.size

    class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title: TextView = itemView.findViewById(R.id.header_title)
        fun bind(text: String) {
            title.text = text
        }
    }

    class TableItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val charName: TextView = itemView.findViewById(R.id.characteristic)
        private val value: TextView = itemView.findViewById(R.id.value)
        private val modifier: TextView = itemView.findViewById(R.id.modifier)
        fun bind(characteristic: String, valueText: String, modifierText: String) {
            charName.text = characteristic
            value.text = valueText
            modifier.text = modifierText
        }
    }

    class SkillViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val skillName: TextView = itemView.findViewById(R.id.skill_name)
        private val skillValue: TextView = itemView.findViewById(R.id.skill_value)
        fun bind(name: String, value: String) {
            skillName.text = name
            skillValue.text = value
        }
    }
}