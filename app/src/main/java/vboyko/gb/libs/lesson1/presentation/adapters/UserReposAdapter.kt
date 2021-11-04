package vboyko.gb.libs.lesson1.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import vboyko.gb.libs.lesson1.databinding.ItemUserRepoBinding
import vboyko.gb.libs.lesson1.domain.entity.UserRepo

class UserReposAdapter : RecyclerView.Adapter<UserRepoItemViewHolder>() {

    private var userReposList: List<UserRepo> = listOf()
    var onUserRepoItemClickListener: ((UserRepo) -> Unit)? = null

    @SuppressLint("NotifyDataSetChanged")
    fun setData(userReposList: List<UserRepo>) {
        this.userReposList = userReposList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserRepoItemViewHolder {
        val binding =
            ItemUserRepoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserRepoItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserRepoItemViewHolder, position: Int) {
        val userRepo = userReposList[position]
        holder.bind(userRepo)
        holder.itemView.setOnClickListener {
            onUserRepoItemClickListener?.invoke(userRepo)
        }
    }

    override fun getItemCount() = userReposList.size
}