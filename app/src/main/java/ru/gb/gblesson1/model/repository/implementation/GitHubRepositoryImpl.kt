package ru.gb.gblesson1.model.repository.implementation

import ru.gb.gblesson1.model.GitHubUser
import ru.gb.gblesson1.model.repository.GitHubRepository

class GitHubRepositoryImpl: GitHubRepository {

    private val repositories = listOf(
        GitHubUser("Ellen Ripley"),
        GitHubUser("Sarah Conor"),
        GitHubUser("Dwayne Hicks"),
        GitHubUser("John McClane"),
        GitHubUser("Alan Schaefer"),
        GitHubUser("Tyler Durden")
    )

    override fun getUsers(): List<GitHubUser> {
        return repositories
    }

}