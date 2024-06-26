package com.capstone.wishata.viewmodel.factory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.capstone.wishata.injection.Injection
import com.capstone.wishata.repository.WishataRepository
import com.capstone.wishata.viewmodel.HomeViewModel
import com.capstone.wishata.viewmodel.LoginViewModel
import com.capstone.wishata.viewmodel.RegisterViewModel
import com.capstone.wishata.viewmodel.WishlistViewModel

class ViewModelFactory(private val repository: WishataRepository): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(RegisterViewModel::class.java) -> {
                RegisterViewModel(repository) as T
            }
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> {
                LoginViewModel(repository) as T
            }
            modelClass.isAssignableFrom(WishlistViewModel::class.java) -> {
                WishlistViewModel(repository) as T
            }
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(repository) as T
            }

            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }

    companion object {
        fun getInstance(context: Context): ViewModelFactory =
            ViewModelFactory(Injection.provideStoryRepository(context))
    }
}