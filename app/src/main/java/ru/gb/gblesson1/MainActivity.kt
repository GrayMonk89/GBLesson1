package ru.gb.gblesson1

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.gb.gblesson1.databinding.ActivityMainBinding
import ru.gb.gblesson1.main.UserAdapter
import ru.gb.gblesson1.model.GitHubUser
import ru.gb.gblesson1.repository.implementation.GitHubRepositoryImpl

class MainActivity : MvpAppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding

    private val adapter = UserAdapter()

    private val presenter by moxyPresenter { CountersPresenter(GitHubRepositoryImpl()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        with(binding) {
            rvGitHubUsers.layoutManager = LinearLayoutManager(this@MainActivity)
            rvGitHubUsers.adapter = adapter
        }
    }

    override fun initList(list: List<GitHubUser>) {
        adapter.users = list
    }

}