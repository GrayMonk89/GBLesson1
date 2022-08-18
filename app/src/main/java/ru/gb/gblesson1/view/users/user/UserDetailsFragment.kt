package ru.gb.gblesson1.view.users.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.gb.gblesson1.CourseApp
import ru.gb.gblesson1.core.OnBackPressedListener
import ru.gb.gblesson1.databinding.FragmentUserDetailsBinding
import ru.gb.gblesson1.presenter.UserDetailsPresenter

class UserDetailsFragment : MvpAppCompatFragment(), OnBackPressedListener, UserDetailsView {

    private var _binding: FragmentUserDetailsBinding? = null
    private val binding: FragmentUserDetailsBinding
        get() = _binding!!

    private val presenter: UserDetailsPresenter by moxyPresenter {
        UserDetailsPresenter(CourseApp.instance.router)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = UserDetailsFragment()
    }

    override fun onBackPressed(): Boolean = presenter.onBackPressed()

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}