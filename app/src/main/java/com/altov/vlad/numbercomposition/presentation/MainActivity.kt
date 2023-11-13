package com.altov.vlad.numbercomposition.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.altov.vlad.numbercomposition.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startWelcomeFragment()
    }
    private fun startWelcomeFragment(){
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container,WelcomeFragment.newInstance())
            .commit()
    }
}