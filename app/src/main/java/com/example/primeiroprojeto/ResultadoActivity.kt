package com.example.primeiroprojeto

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.graphics.Color
import android.os.Build
import androidx.core.content.ContextCompat
import androidx.annotation.RequiresApi
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class ResultadoActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

            val tvResult = findViewById<TextView>(R.id.text_result)
            val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)
            val tvClassification = findViewById<TextView>(R.id.text_classification)

            tvResult.text = result.toString()

            var classification = ""
            var color: Int = Color.BLACK
            var color2: Int = ContextCompat.getColor(this, R.color.orange)

        if(result < 18.5){

            classification = "Underweight."
            color = Color.BLUE

        }else if(result >= 18.5 && result <= 24.9){

            classification = "Normal."
            color = Color.GREEN

        }else if(result >= 25 && result <= 29.9){

            classification = "Overweight I"
            color = ContextCompat.getColor(this, R.color.orange)


        }else if(result >= 30 || result <= 39.9){

            classification = "Overweight II"
            color = Color.RED

        }else{

            classification = "Obese"
            color = Color.RED
        }

        tvClassification.text = getString(R.string.msg_classification, classification)
        tvClassification.setTextColor(color)

        }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }


    }
