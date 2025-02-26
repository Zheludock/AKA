package com.example.aka.items

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aka.R

class SliderAdapter(
    private val items: List<SlideItem>
) : RecyclerView.Adapter<SliderAdapter.SlideViewHolder>() {

    inner class SlideViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.slideImage)
        val caption: TextView = view.findViewById(R.id.slideCaption)
        val description: TextView = view.findViewById(R.id.slideDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SlideViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_slide, parent, false)
        return SlideViewHolder(view)
    }

    override fun onBindViewHolder(holder: SlideViewHolder, position: Int) {
        with(items[position]) {
            holder.image.setImageResource(imageRes)
            holder.caption.text = caption
            holder.description.text = description
        }
    }

    override fun getItemCount(): Int = items.size
}

data class SlideItem(
    val imageRes: Int,  // ID ресурса изображения
    val caption: String, // Текст подписи
    val description: String
)