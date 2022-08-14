package ru.gb.gblesson1.main

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.gb.gblesson1.core.navigation.UsersScreen


class MainPresenter(private val router: Router) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(UsersScreen)
    }

    fun onBackPressed() {
        router.exit()
    }

}
