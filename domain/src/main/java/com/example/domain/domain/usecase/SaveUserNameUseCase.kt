package com.example.domain.domain.usecase

import com.example.domain.domain.models.SaveUserNameParam
import com.example.domain.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam):Boolean {
        val oldUserName = userRepository.getName()
        if(oldUserName.firstName == param.name){
            return true
        }
        val result = userRepository.saveName(saveParam = param)
        return result
    }
}