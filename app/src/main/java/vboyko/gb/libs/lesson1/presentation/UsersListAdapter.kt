package vboyko.gb.libs.lesson1.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import vboyko.gb.libs.lesson1.R
import vboyko.gb.libs.lesson1.domain.User

class UsersListAdapter : RecyclerView.Adapter<UserItemViewHolder>() {

    private var usersList: List<User> = listOf()
    var onUserItemClickListener: ((User) -> Unit)? = null

    @SuppressLint("NotifyDataSetChanged")
    fun setData(usersList: List<User>) {
        this.usersList = usersList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserItemViewHolder, position: Int) {
        val user = usersList[position]
        holder.tvId.text = user.id.toString()
        holder.tvLastName.text = user.lastName
        holder.tvName.text = user.name

        holder.view.setOnClickListener {
            onUserItemClickListener?.invoke(user)
        }
    }

    override fun getItemCount() = usersList.size
}