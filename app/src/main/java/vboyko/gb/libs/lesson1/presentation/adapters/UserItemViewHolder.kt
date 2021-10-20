package vboyko.gb.libs.lesson1.presentation.adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import vboyko.gb.libs.lesson1.R

class UserItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    val tvId: TextView = view.findViewById(R.id.tv_id)
    val tvName: TextView = view.findViewById(R.id.tv_name)
    val tvLastName: TextView  = view.findViewById(R.id.tv_last_name)
}