package com.example.cleanarchitecture

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.example.domain.domain.models.SaveUserNameParam
import com.example.domain.domain.usecase.GetUserNameUseCase
import com.example.domain.domain.usecase.SaveUserNameUseCase

class MainViewModel(private val getUserNameUseCase: GetUserNameUseCase,
                    private val saveUserNameUseCase: SaveUserNameUseCase): ViewModel() {

    private var resultLive = MutableLiveData<String>()

    fun getResultLive():LiveData<String>{
        return resultLive
    }

    override fun onCleared() {
        super.onCleared()
    }

    fun save(text: String){
        val params = SaveUserNameParam(name = text)
        val resultData = saveUserNameUseCase.execute(param = params)
        resultLive.value = "Save result $resultData"
    }

    fun load(){
        val userName = getUserNameUseCase.execute()
        resultLive.value = "${userName.firstName}, ${userName.secondName}"
    }
}