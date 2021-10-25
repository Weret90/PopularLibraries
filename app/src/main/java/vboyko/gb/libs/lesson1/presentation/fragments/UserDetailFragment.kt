package vboyko.gb.libs.lesson1.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import vboyko.gb.libs.lesson1.databinding.FragmentUserDetailBinding
import vboyko.gb.libs.lesson1.presentation.AndroidScreens
import vboyko.gb.libs.lesson1.presentation.App
import vboyko.gb.libs.lesson1.presentation.interfaces.BackButtonListener
import vboyko.gb.libs.lesson1.presentation.interfaces.UserDetailView
import vboyko.gb.libs.lesson1.presentation.presenters.UserDetailPresenter

class UserDetailFragment : MvpAppCompatFragment(), UserDetailView, BackButtonListener {

    private var _binding: FragmentUserDetailBinding? = null
    private val binding get() = _binding!!

    private val presenter by moxyPresenter {
        UserDetailPresenter(
            App.instance.router,
            AndroidScreens()
        )
    }

    companion object {

        private const val TAG_USER_ID = "user_id"

        fun newInstance(userId: Int): UserDetailFragment {
            return UserDetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(TAG_USER_ID, userId)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val userId = requireArguments().getInt(TAG_USER_ID)
        presenter.getUserLogin(userId)
    }

    override fun showLogin(userLogin: String) {
        binding.tvLogin.text = userLogin
    }

    override fun hideProgressBar() {
        binding.progressBar.visibility = View.GONE
    }

    override fun showErrorToast(t: Throwable) {
        Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
    }

    override fun backPressed() = presenter.backPressed()

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}