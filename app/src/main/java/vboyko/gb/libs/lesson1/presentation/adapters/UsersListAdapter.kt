package vboyko.gb.libs.lesson1.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import vboyko.gb.libs.lesson1.databinding.ItemUserBinding
import vboyko.gb.libs.lesson1.domain.entity.User

class UsersListAdapter : RecyclerView.Adapter<UserItemViewHolder>() {

    private var usersList: List<User> = listOf()
    var onUserItemClickListener: ((User) -> Unit)? = null

    @SuppressLint("NotifyDataSetChanged")
    fun setData(usersList: List<User>) {
        this.usersList = usersList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserItemViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserItemViewHolder, position: Int) {
        val user = usersList[position]
        holder.bind(user)
        holder.itemView.setOnClickListener {
            onUserItemClickListener?.invoke(user)
        }
    }

    override fun getItemCount() = usersList.size
}