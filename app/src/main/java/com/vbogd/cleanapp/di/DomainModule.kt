package com.vbogd.cleanapp.di

import com.vbogd.cleanapp.domain.use_cases.GetUserUseCase
import com.vbogd.cleanapp.domain.use_cases.SaveNameUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<GetUserUseCase> {
        GetUserUseCase(userRepository = get())
    }

    factory<SaveNameUseCase> {
        SaveNameUseCase(userRepository = get())
    }
}