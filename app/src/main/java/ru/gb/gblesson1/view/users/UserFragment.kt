package ru.gb.gblesson1.view.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.gb.gblesson1.CourseApp
import ru.gb.gblesson1.core.OnBackPressedListener
import ru.gb.gblesson1.databinding.FragmentUserListBinding
import ru.gb.gblesson1.model.GitHubUser
import ru.gb.gblesson1.model.repository.implementation.GitHubRepositoryImpl
import ru.gb.gblesson1.presenter.UserPresenter

class UserFragment : MvpAppCompatFragment(), UserView, OnBackPressedListener, OnItemClickListener {
    companion object {
        fun getInstance(): UserFragment {
            return UserFragment()
//                .apply {
//                    arguments = Bundle("login" to login)
//                }
        }
    }

    private var _binding: FragmentUserListBinding? = null
    private val binding: FragmentUserListBinding
        get() = _binding!!

    private val adapter = UserAdapter(this)

    private val presenter: UserPresenter by moxyPresenter {
        UserPresenter(GitHubRepositoryImpl(), CourseApp.instance.router)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            rvGitHubUsers.layoutManager = LinearLayoutManager(requireContext())
            rvGitHubUsers.adapter = adapter
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    override fun initList(list: List<GitHubUser>) {
        adapter.users = list
    }

    override fun onBackPressed(): Boolean = presenter.onBackPressed()
    override fun onItemClick(gitHubUser: GitHubUser) {
        presenter.showDetails(gitHubUser)
    }
}