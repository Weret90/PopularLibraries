package vboyko.gb.libs.lesson1.presentation.adapters

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import vboyko.gb.libs.lesson1.databinding.ItemUserBinding
import vboyko.gb.libs.lesson1.domain.entity.User

class UserItemViewHolder(private val binding: ItemUserBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(user: User) {
        binding.userLogin.text = user.login
        binding.userAvatar.run {
            Glide.with(this)
                .load(user.avatarUrl)
                .into(this)
        }
    }
}