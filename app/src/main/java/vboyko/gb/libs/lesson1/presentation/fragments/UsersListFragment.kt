package vboyko.gb.libs.lesson1.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import vboyko.gb.libs.lesson1.data.UsersRepositoryImpl
import vboyko.gb.libs.lesson1.data.network.GithubApiFactory
import vboyko.gb.libs.lesson1.databinding.FragmentUsersListBinding
import vboyko.gb.libs.lesson1.domain.entity.User
import vboyko.gb.libs.lesson1.presentation.*
import vboyko.gb.libs.lesson1.presentation.adapters.UsersListAdapter
import vboyko.gb.libs.lesson1.presentation.interfaces.BackButtonListener
import vboyko.gb.libs.lesson1.presentation.interfaces.UsersListView
import vboyko.gb.libs.lesson1.presentation.presenters.UsersListPresenter

class UsersListFragment : MvpAppCompatFragment(), UsersListView, BackButtonListener {

    private var _binding: FragmentUsersListBinding? = null
    private val binding get() = _binding!!

    private val usersListAdapter = UsersListAdapter()
    private val presenter by moxyPresenter {
        UsersListPresenter(
            App.instance.router,
            AndroidScreens(),
            UsersRepositoryImpl(GithubApiFactory.githubApi)
        )
    }

    companion object {
        fun newInstance() = UsersListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentUsersListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvUsers.adapter = usersListAdapter

        usersListAdapter.onUserItemClickListener = {
            presenter.navigateToUserDetailFragment(it.reposUrl)
        }
    }

    override fun showUsersList(usersList: List<User>) {
        usersListAdapter.setData(usersList)
    }

    override fun showErrorToast(t: Throwable) {
        Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
    }

    override fun hideProgressBar() {
        binding.progressBar.visibility = View.GONE
    }

    override fun backPressed() = presenter.backPressed()

}