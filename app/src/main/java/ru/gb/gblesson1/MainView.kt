package ru.gb.gblesson1

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.gb.gblesson1.model.GitHubUser

@StateStrategyType(AddToEndSingleStrategy::class)
interface MainView: MvpView {

    fun initList(list: List<GitHubUser>)

    //fun updateList(list: List<GitHubUser>)
}
