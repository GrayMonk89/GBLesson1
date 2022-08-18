package ru.gb.gblesson1.view.users

import ru.gb.gblesson1.model.GitHubUser

interface OnItemClickListener {
    fun onItemClick(gitHubUser: GitHubUser)
}