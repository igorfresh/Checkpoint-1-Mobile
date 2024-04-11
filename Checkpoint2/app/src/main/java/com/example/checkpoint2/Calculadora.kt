package com.example.checkpoint2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class Calculadora : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        val calcularButton = findViewById<Button>(R.id.calcularButton)

        calcularButton.setOnClickListener {
            val valor1EditText = findViewById<EditText>(R.id.valor1EditText)
            val valor2EditText = findViewById<EditText>(R.id.valor2EditText)
            val valor1 = valor1EditText.text.toString().toDoubleOrNull()
            val valor2 = valor2EditText.text.toString().toDoubleOrNull()

            if (valor1 == null || valor2 == null) {
                showToast("Por favor, insira valores válidos.")
                return@setOnClickListener
            }

            val operacoesRadioGroup = findViewById<RadioGroup>(R.id.operacoesRadioGroup)
            val operacaoId = operacoesRadioGroup.checkedRadioButtonId
            val operacao = findViewById<RadioButton>(operacaoId)?.text.toString()

            val resultado = when (operacao) {
                "Soma" -> valor1 + valor2
                "Subtração" -> valor1 - valor2
                "Multiplicação" -> valor1 * valor2
                "Divisão" -> {
                    if (valor2 == 0.0) {
                        showToast("Divisão por zero não é permitida.")
                        return@setOnClickListener
                    }
                    valor1 / valor2
                }
                else -> {
                    showToast("Operação inválida.")
                    return@setOnClickListener
                }
            }

            showToast("Resultado: $resultado")
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}