package com.example.kotlincleanarchitecture.auth.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlincleanarchitecture.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
}