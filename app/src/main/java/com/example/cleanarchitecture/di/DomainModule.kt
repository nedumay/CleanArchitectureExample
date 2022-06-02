package com.example.cleanarchitecture.di

import com.example.domain.domain.usecase.GetUserNameUseCase
import com.example.domain.domain.usecase.SaveUserNameUseCase
import org.koin.dsl.module

/** делаем factory для
private val getUserNameUseCase by lazy { GetUserNameUseCase(userRepository = userRepository) }
private val saveUserNameUseCase by lazy{ SaveUserNameUseCase(userRepository = userRepository) }
 */

val domainModule = module {
    factory<GetUserNameUseCase> { GetUserNameUseCase(userRepository = get()) }
    factory<SaveUserNameUseCase> { SaveUserNameUseCase(userRepository = get()) }
}