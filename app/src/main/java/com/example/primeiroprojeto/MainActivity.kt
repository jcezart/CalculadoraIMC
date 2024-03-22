package com.example.primeiroprojeto

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
        @SuppressLint("SuspiciousIndentation")
        override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)


       //Recuperar UI component no arquivo Kotlin (necessário ID do componente no XML)
                //Colocar ação no botão
        val btnCalculate: Button = findViewById<Button>(R.id.btnCalculate)
        val editWeight: EditText = findViewById(R.id.editWeight)
        val editHeight: EditText = findViewById(R.id.editHeight)


                btnCalculate.setOnClickListener {

                val weightStr = editWeight.text.toString()
                val heightStr = editHeight.text.toString()

                if (weightStr.isNotEmpty() && heightStr.isNotEmpty()) {

                        val weight: Float = weightStr.toFloat()
                        val height: Float = heightStr.toFloat()
                        val bmi: Float = (weight / (height * height))

                        val intent = Intent(this, ResultadoActivity::class.java)
                                .apply {
                                        putExtra("EXTRA_RESULT", bmi)
                                }
                        startActivity(intent)
                }else {
                        Toast.makeText(this, "Fill all fields.", Toast.LENGTH_LONG).show()
                }

        }
    }
}

