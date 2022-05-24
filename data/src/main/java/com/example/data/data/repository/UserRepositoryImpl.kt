package com.example.data.data.repository

import com.example.data.data.storage.User
import com.example.data.data.storage.UserStorage
import com.example.domain.domain.models.SaveUserNameParam
import com.example.domain.domain.models.UserName
import com.example.domain.domain.repository.UserRepository


class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveName(saveParam: SaveUserNameParam):Boolean{
        val user = User(firstName = saveParam.name, secondName =  "")
        return userStorage.save(user)
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        val userName = UserName(firstName = user.firstName, secondName = user.secondName)
        return userName
    }
}