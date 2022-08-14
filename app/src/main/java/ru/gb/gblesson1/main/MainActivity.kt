package ru.gb.gblesson1.main

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.gb.gblesson1.CourseApp
import ru.gb.gblesson1.R
import ru.gb.gblesson1.core.OnBackPressedListener
import ru.gb.gblesson1.databinding.ActivityMainBinding
import ru.gb.gblesson1.model.GitHubUser
import ru.gb.gblesson1.repository.implementation.GitHubRepositoryImpl

class MainActivity : MvpAppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding

    private val navigator = AppNavigator(this, R.id.containerMain)

    private val presenter by moxyPresenter { MainPresenter(CourseApp.instance.router) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        CourseApp.instance.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        CourseApp.instance.navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach(){currentFragment ->
            if(currentFragment is OnBackPressedListener && currentFragment.onBackPressed()){
                return
            }
        }
        presenter.onBackPressed()
    }
}