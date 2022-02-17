package com.vbogd.cleanapp.di

import com.vbogd.cleanapp.data.repositories.UserRepositoryImpl
import com.vbogd.cleanapp.data.storage.UserStorage
import com.vbogd.cleanapp.data.storage.sharedPrefs.SharedPrefUserStorage
import com.vbogd.cleanapp.domain.repositories.UserRepository
import org.koin.dsl.module

val dataModule = module {

    single<UserStorage> {
        SharedPrefUserStorage(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }
}