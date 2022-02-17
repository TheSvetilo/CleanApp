package com.vbogd.cleanapp.data.storage

import com.vbogd.cleanapp.data.storage.models.SaveUserNameStorageModel
import com.vbogd.cleanapp.data.storage.models.UserStorageModel

interface UserStorage {

    fun saveUser(param: SaveUserNameStorageModel): Boolean
    fun getUser(): UserStorageModel

}