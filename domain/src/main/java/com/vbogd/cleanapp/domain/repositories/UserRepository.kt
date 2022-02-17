package com.vbogd.cleanapp.domain.repositories

import com.vbogd.cleanapp.domain.models.SaveUserName
import com.vbogd.cleanapp.domain.models.User

interface UserRepository {

    fun saveData(param: SaveUserName): Boolean
    fun getData(): User
}