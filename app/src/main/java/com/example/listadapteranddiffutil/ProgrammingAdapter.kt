package com.example.listadapteranddiffutil

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class ProgrammingAdapter: ListAdapter<ProgrammingItem, ProgrammingAdapter.ProgrammingViewHolder>(DiffUtil()) {

    class ProgrammingViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val name = view.findViewById<AppCompatTextView>(R.id.text_title)
        val initial = view.findViewById<AppCompatTextView>(R.id.text_initial)

        fun bind(item: ProgrammingItem) {
            name.text = item.name
            initial.text = item.initial
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgrammingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_programming, parent, false)
        return ProgrammingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProgrammingViewHolder, position: Int) {
        val item = getItem(holder.adapterPosition)
        holder.bind(item)
    }

    class DiffUtil : androidx.recyclerview.widget.DiffUtil.ItemCallback<ProgrammingItem>() {
        override fun areItemsTheSame(oldItem: ProgrammingItem, newItem: ProgrammingItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ProgrammingItem,
            newItem: ProgrammingItem
        ): Boolean {
            return oldItem == newItem
        }
    }
}