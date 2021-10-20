package vboyko.gb.libs.lesson1.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import vboyko.gb.libs.lesson1.databinding.FragmentUsersListBinding
import vboyko.gb.libs.lesson1.domain.User

class UsersListFragment : MvpAppCompatFragment(), UsersListView {

    private var _binding: FragmentUsersListBinding? = null
    private val binding get() = _binding!!
    private val usersListAdapter = UsersListAdapter()
    private val presenter by moxyPresenter { UsersListPresenter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
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
            Toast.makeText(context, "ssss", Toast.LENGTH_SHORT).show()
        }

    }

    override fun showUsersList(usersList: List<User>) {
        usersListAdapter.setData(usersList)
    }
}