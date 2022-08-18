package ru.gb.gblesson1.core.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.gb.gblesson1.model.GitHubUser
import ru.gb.gblesson1.view.users.UserFragment
import ru.gb.gblesson1.view.users.user.UserDetailsFragment

object UsersScreen : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return UserFragment.getInstance()
    }
}
class UserDetailsScreen(private val gitHubUser: GitHubUser) : FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment {
        return UserDetailsFragment.newInstance(gitHubUser)
    }

}