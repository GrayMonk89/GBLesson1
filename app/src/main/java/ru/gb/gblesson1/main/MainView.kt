package ru.gb.gblesson1.main

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.gb.gblesson1.model.GitHubUser

@StateStrategyType(AddToEndSingleStrategy::class)
interface MainView: MvpView
