package vboyko.gb.libs.lesson1.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import vboyko.gb.libs.lesson1.data.database.UsersDatabase
import vboyko.gb.libs.lesson1.data.repository.UsersRepositoryImpl
import vboyko.gb.libs.lesson1.data.network.GithubApiFactory
import vboyko.gb.libs.lesson1.databinding.FragmentUserDetailBinding
import vboyko.gb.libs.lesson1.domain.entity.UserRepo
import vboyko.gb.libs.lesson1.presentation.AndroidScreens
import vboyko.gb.libs.lesson1.presentation.App
import vboyko.gb.libs.lesson1.presentation.adapters.UserReposAdapter
import vboyko.gb.libs.lesson1.presentation.interfaces.BackButtonListener
import vboyko.gb.libs.lesson1.presentation.interfaces.UserDetailView
import vboyko.gb.libs.lesson1.presentation.presenters.UserDetailPresenter
import java.lang.RuntimeException

class UserDetailFragment : MvpAppCompatFragment(), UserDetailView, BackButtonListener {

    private var _binding: FragmentUserDetailBinding? = null
    private val binding get() = _binding!!

    private val userReposAdapter = UserReposAdapter()

    private val presenter by moxyPresenter {
        UserDetailPresenter(
            App.instance.router,
            AndroidScreens(),
            UsersRepositoryImpl(
                GithubApiFactory.githubApi,
                UsersDatabase.getInstance(requireContext()).usersDao(),
                UsersDatabase.getInstance(requireContext()).reposDao()
            )
        )
    }

    companion object {

        private const val TAG_USER_REPOS_URL = "user_repos_url"
        private const val TAG_USER_ID = "user_id"

        fun newInstance(userReposUrl: String, userId: Int): UserDetailFragment {
            return UserDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(TAG_USER_REPOS_URL, userReposUrl)
                    putInt(TAG_USER_ID, userId)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentUserDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvRepositories.adapter = userReposAdapter

        userReposAdapter.onUserRepoItemClickListener = {
            presenter.navigateToUserRepoDetailFragment(it)
        }

        val userReposUrl =
            requireArguments().getString(TAG_USER_REPOS_URL) ?: throw RuntimeException(
                "can not get user repos: url == null")

        val userId = requireArguments().getInt(TAG_USER_ID)

        presenter.getUserReposList(userReposUrl, userId)
    }

    override fun showUserReposList(list: List<UserRepo>) {
        userReposAdapter.setData(list)
    }

    override fun hideProgressBar() {
        binding.progressBar.visibility = View.GONE
    }

    override fun showErrorToast(error: Throwable) {
        Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
    }

    override fun backPressed() = presenter.backPressed()

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}