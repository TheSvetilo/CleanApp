package com.vbogd.cleanapp.data.repositories

import com.vbogd.cleanapp.data.storage.models.SaveUserNameStorageModel
import com.vbogd.cleanapp.data.storage.UserStorage
import com.vbogd.cleanapp.data.storage.models.UserStorageModel
import com.vbogd.cleanapp.domain.models.SaveUserName
import com.vbogd.cleanapp.domain.models.User
import com.vbogd.cleanapp.domain.repositories.UserRepository

class UserRepositoryImpl(
    private val userStorage: UserStorage
) : UserRepository {

    override fun saveData(param: SaveUserName): Boolean {
        val name = mapToStorage(param)
        return userStorage.saveUser(name)
    }

    override fun getData(): User {
        val user = userStorage.getUser()
        return mapToDomain(user)
    }

    private fun mapToDomain(user: UserStorageModel): User {
        return User(
            userName = user.firstName,
            lastName = user.lastName
        )
    }

    private fun mapToStorage(saveUserName: SaveUserName): SaveUserNameStorageModel {
        return SaveUserNameStorageModel(name = saveUserName.name)
    }
}