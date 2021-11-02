package vboyko.gb.libs.lesson1.presentation.adapters

import androidx.recyclerview.widget.RecyclerView
import vboyko.gb.libs.lesson1.databinding.ItemUserRepoBinding
import vboyko.gb.libs.lesson1.domain.entity.UserRepo

class UserRepoItemViewHolder(private val binding: ItemUserRepoBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(userRepo: UserRepo) {
        binding.repoName.text = userRepo.name
        binding.repoWasCreated.text = userRepo.createdAt
    }
}