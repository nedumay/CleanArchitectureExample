package com.example.cleanarchitecture.di

import com.example.data.data.repository.UserRepositoryImpl
import com.example.data.data.storage.SharedPrefUserStorage
import com.example.data.data.storage.UserStorage
import com.example.domain.domain.repository.UserRepository
import org.koin.dsl.module

/** делаем синглтоны
private val userRepository by lazy{ UserRepositoryImpl(userStorage = SharedPrefUserStorage(context = context)) }
*/
val dataModul = module {

    single<UserStorage> { SharedPrefUserStorage(context = get()) }
    single<UserRepository> { UserRepositoryImpl(userStorage = get()) }

}