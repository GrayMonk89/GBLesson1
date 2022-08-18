package ru.gb.gblesson1.model.repository

import ru.gb.gblesson1.model.GitHubUser

interface GitHubRepository {
    fun getUsers():List<GitHubUser>
}