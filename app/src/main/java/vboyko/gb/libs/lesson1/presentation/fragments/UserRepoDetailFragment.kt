package vboyko.gb.libs.lesson1.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import vboyko.gb.libs.lesson1.databinding.FragmentUserRepoDetailBinding
import vboyko.gb.libs.lesson1.domain.entity.UserRepo
import vboyko.gb.libs.lesson1.presentation.AndroidScreens
import vboyko.gb.libs.lesson1.presentation.App
import vboyko.gb.libs.lesson1.presentation.interfaces.BackButtonListener
import vboyko.gb.libs.lesson1.presentation.interfaces.UserRepoDetail
import vboyko.gb.libs.lesson1.presentation.mapper.toPresentationModel
import vboyko.gb.libs.lesson1.presentation.model.UserRepoModel
import vboyko.gb.libs.lesson1.presentation.presenters.UserRepoDetailPresenter

class UserRepoDetailFragment : MvpAppCompatFragment(), UserRepoDetail, BackButtonListener {

    private var _binding: FragmentUserRepoDetailBinding? = null
    private val binding get() = _binding!!

    private val presenter by moxyPresenter {
        UserRepoDetailPresenter(
            App.instance.router,
            AndroidScreens()
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentUserRepoDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getParcelable<UserRepoModel>(TAG_USER_REPO)?.let { userRepo ->
            binding.repoName.text = userRepo.name
            binding.repoDescription.text = userRepo.description
            binding.repoLanguage.text = userRepo.language
            binding.repoForksCount.text = userRepo.forksCount.toString()
        }
    }

    companion object {
        private const val TAG_USER_REPO = "user_repo"

        fun newInstance(userRepo: UserRepo): UserRepoDetailFragment {
            return UserRepoDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(TAG_USER_REPO, userRepo.toPresentationModel())
                }
            }
        }
    }

    override fun backPressed() = presenter.backPressed()

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}