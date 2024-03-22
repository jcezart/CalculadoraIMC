package com.example.primeiroprojeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)


       //Recuperar UI component no arquivo Kotlin (necessário ID do componente no XML)
                //Colocar ação no botão
        val btnCalcular: Button = findViewById<Button>(R.id.btcCalcular)
        val editPeso: EditText = findViewById(R.id.editPeso)
        val editAltura: EditText = findViewById(R.id.editAltura)


        btnCalcular.setOnClickListener {

                val pesoStr = editPeso.text.toString()
                val alturaStr = editAltura.text.toString()

                if (pesoStr.isNotEmpty() && alturaStr.isNotEmpty()) {


                        val peso: Float = pesoStr.toFloat()
                        val altura: Float = alturaStr.toFloat()
                        val imc: Float = (peso / (altura * altura))


                        val intent = Intent(this, ResultadoActivity::class.java)
                                .apply {
                                        putExtra("EXTRA_RESULT", imc)
                                }
                        startActivity(intent)
                }else {
                        Toast.makeText(this, "Preencher todos os campos", Toast.LENGTH_LONG).show()
                }

        }
    }
}

