package com.example.cleanarchitecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.data.data.repository.UserRepositoryImpl
import com.example.data.data.storage.SharedPrefUserStorage
import com.example.domain.domain.models.SaveUserNameParam
import com.example.domain.domain.usecase.GetUserNameUseCase
import com.example.domain.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    private val userRepository by lazy{ UserRepositoryImpl(userStorage = SharedPrefUserStorage(context = applicationContext))}
    private val getUserNameUseCase by lazy { GetUserNameUseCase(userRepository = userRepository)}
    private val saveUserNameUseCase by lazy{ SaveUserNameUseCase(userRepository = userRepository)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val dataEditText = findViewById<EditText>(R.id.dataEditText)
        val sendButton = findViewById<Button>(R.id.sendButton)
        val receiveButton = findViewById<Button>(R.id.receiveButton)

        sendButton.setOnClickListener {
            val text = dataEditText.text.toString()
            val params = SaveUserNameParam(name = text)
            val result = saveUserNameUseCase.execute(param = params)
            dataTextView.text = "Save result $result"
        }
        receiveButton.setOnClickListener {
            val userName = getUserNameUseCase.execute()
            dataTextView.text = "${userName.firstName}, ${userName.secondName}"
        }
    }

}