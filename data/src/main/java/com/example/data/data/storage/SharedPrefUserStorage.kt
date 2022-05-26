package com.example.data.data.storage

import android.content.Context

private const val SHARED_PREF_NAME = "shared_pref_name"
private const val KEY_FIRST_NAME = "first_name"
private const val KEY_SECOND_NAME = "second_name"
private const val DEFAULT_SECOND_NAME = "second_name"
private const val DEFAULT_FIRST_NAME = "first_name"

class SharedPrefUserStorage(private val context: Context):UserStorage {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)

    override fun save(user:User): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, user.firstName).apply()
        sharedPreferences.edit().putString(KEY_SECOND_NAME, user.secondName).apply()
        return  true
    }

    override fun get(): User {
        val firstName = sharedPreferences.getString(KEY_FIRST_NAME,DEFAULT_FIRST_NAME)?: DEFAULT_FIRST_NAME
        val secondName = sharedPreferences.getString(KEY_SECOND_NAME,DEFAULT_SECOND_NAME)?: DEFAULT_SECOND_NAME
        return User(firstName = firstName, secondName = secondName)
    }

}