package com.surajvanshsv.currencyconverter

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    // declaring views
    lateinit var titletext : TextView
    lateinit var resultText : TextView
    lateinit var edittext : EditText
    lateinit var btn1 : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // initializing the view
        titletext = findViewById(R.id.textView)
        resultText = findViewById(R.id.resultText)
        edittext = findViewById(R.id.editText)
        btn1 = findViewById(R.id.convertBTN)

        btn1.setOnClickListener {
            var userusd:String = edittext.text.toString()
            var userusddouble : Double = userusd.toDouble()
            var rupee :Double = convertToRupees(userusddouble)
            resultText.text = "$rupee Rupees"

        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun convertToRupees(usd:Double):Double{
        return usd*87.72
    }
}