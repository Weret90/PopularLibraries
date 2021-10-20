package vboyko.gb.libs.lesson1.presentation

import android.os.Bundle
import android.widget.Toast
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import vboyko.gb.libs.lesson1.databinding.ActivityMainBinding
import vboyko.gb.libs.lesson1.domain.User

class MainActivity : MvpAppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding
    private val usersListAdapter = UsersListAdapter()
    private val presenter by moxyPresenter { MainPresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvUsers.adapter = usersListAdapter

        usersListAdapter.onUserItemClickListener = {
            Toast.makeText(this, "ssss", Toast.LENGTH_SHORT).show()
        }
    }

    override fun showUsersList(usersList: List<User>) {
        usersListAdapter.setData(usersList)
    }
}