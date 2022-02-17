package com.vbogd.cleanapp.data.storage.sharedPrefs

import android.content.Context
import android.content.SharedPreferences
import com.vbogd.cleanapp.data.storage.UserStorage
import com.vbogd.cleanapp.data.storage.models.SaveUserNameStorageModel
import com.vbogd.cleanapp.data.storage.models.UserStorageModel

private const val SHARED_PREFS_NAME = "shared_pref_name"
private const val KEY_NAME = "shared_userName"

class SharedPrefUserStorage(context: Context) : UserStorage {

    private val sharedPref: SharedPreferences = context.getSharedPreferences(
        SHARED_PREFS_NAME,
        Context.MODE_PRIVATE
    )

    override fun saveUser(param: SaveUserNameStorageModel): Boolean =
        if (param.name.isNotEmpty()) {
            sharedPref.edit().putString(KEY_NAME, param.name).apply()
            true
        } else false

    override fun getUser(): UserStorageModel {

        val firstName = sharedPref.getString(KEY_NAME, "Vlad") ?: ""

        return UserStorageModel(
            firstName = firstName,
            lastName = "Bogdanov"
        )
    }
}