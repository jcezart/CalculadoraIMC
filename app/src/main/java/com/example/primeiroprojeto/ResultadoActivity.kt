package com.example.primeiroprojeto

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets*/

            val tvResultado = findViewById<TextView>(R.id.text_resultado)
            val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)
            val tvClassificacao = findViewById<TextView>(R.id.text_Classificacao)

            tvResultado.text = result.toString()

            var classificacao = ""
        if(result < 18.5){

            classificacao = "Abaixo do peso."

        }else if(result >= 18.5 && result <= 24.9){

            classificacao = "Normal."

        }else if(result >= 25 && result <= 29.9){

            classificacao = "Sobrepeso I"

        }else if(result >= 30 || result <= 39.9){

            classificacao = "Sobrepeso II"

        }else{

            classificacao = "Obesidade"
        }

        tvClassificacao.text = getString(R.string.msg_classificacao, classificacao)

        }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }


    }
