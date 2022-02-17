package com.vbogd.cleanapp.domain.use_cases

import com.vbogd.cleanapp.domain.models.User
import com.vbogd.cleanapp.domain.repositories.UserRepository

class GetUserUseCase(private val userRepository: UserRepository) {

    fun execute(): User = userRepository.getData()

}