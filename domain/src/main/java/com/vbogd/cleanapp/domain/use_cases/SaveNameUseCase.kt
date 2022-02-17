package com.vbogd.cleanapp.domain.use_cases

import com.vbogd.cleanapp.domain.models.SaveUserName
import com.vbogd.cleanapp.domain.repositories.UserRepository

class SaveNameUseCase(private val userRepository: UserRepository) {

//    fun execute(param: SaveUserName): Boolean = param.name.isNotEmpty()
    fun execute(param: SaveUserName): Boolean = userRepository.saveData(param)

}