package ru.gb.gblesson1.presenter

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.gb.gblesson1.model.repository.GitHubRepository
import ru.gb.gblesson1.view.users.UserView

class UserPresenter(private val repository: GitHubRepository,
                    private val router: Router
) :
    MvpPresenter<UserView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.initList(repository.getUsers())
    }

    fun onBackPressed(): Boolean{
        router.exit()
        return true
    }
}