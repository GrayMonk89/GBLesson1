package ru.gb.gblesson1

import moxy.MvpPresenter
import ru.gb.gblesson1.repository.GitHubRepository
import ru.gb.gblesson1.repository.implementation.CountersRepository
import ru.gb.gblesson1.utils.DEFAULT_VALUE_ONE
import ru.gb.gblesson1.utils.DEFAULT_VALUE_TWO
import ru.gb.gblesson1.utils.DEFAULT_VALUE_ZERO


class CountersPresenter(private val repository: GitHubRepository) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.initList(repository.getUsers())
    }

}
