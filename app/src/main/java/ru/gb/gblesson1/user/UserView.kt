package ru.gb.gblesson1.user

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.gb.gblesson1.model.GitHubUser

@StateStrategyType(AddToEndSingleStrategy::class)
interface UserView: MvpView {
    fun initList(list: List<GitHubUser>)
}