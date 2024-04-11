package com.example.checkpoint2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Telefonia : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_telefonia)

        val calcularTelefonia = findViewById<Button>(R.id.calcularBtnTelefonia)

        calcularTelefonia.setOnClickListener {
            val valor1EditText = findViewById<EditText>(R.id.valor1EditText)
            val valor2EditText = findViewById<EditText>(R.id.valor2EditText)
            val valor1 = valor1EditText.text.toString().toDoubleOrNull()
            val valor2 = valor2EditText.text.toString().toDoubleOrNull()

            if (valor1 == null || valor2 == null) {
                val resultadoTextView = findViewById<TextView>(R.id.resultadoTextView)
                resultadoTextView.text = "Por favor, insira valores válidos."
                return@setOnClickListener
            }

            val resultado1 = valor1 * 0.04
            val resultado2 = valor2 * 0.20
            val resultadoTotal = resultado1 + resultado2 + 59.90

            val resultadoTextView = findViewById<TextView>(R.id.resultadoTextView)
            resultadoTextView.text = "Valor Fixo: R\$59.90\n" +
                    "Resultado do Primeiro Valor: R\$$resultado1\n" +
                    "Resultado do Segundo Valor: R\$$resultado2\n" +
                    "Soma Total: R\$$resultadoTotal"
        }
    }
}