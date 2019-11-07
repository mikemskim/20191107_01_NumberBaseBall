package com.tj.a20191107_01_numberbaseball

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    abstract fun setupEvents()
    abstract fun setValues()
}