package com.example.checkpoint2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAluno = findViewById<Button>(R.id.btn_aluno)
        val btnCalculadora = findViewById<Button>(R.id.btn_calculadora)
        val btnTelefonia = findViewById<Button>(R.id.btn_contaTelefonica)

        btnAluno.setOnClickListener{
            val artDialogBuilder = AlertDialog.Builder(this@MainActivity)

            artDialogBuilder.setTitle("Desenvolvido por:")
            artDialogBuilder.setMessage(
                "Igor Miguel Silva\nRM: 99495")
            artDialogBuilder.setCancelable(false)
            artDialogBuilder.setPositiveButton("OK"){_,_ ->
                Toast.makeText(this@MainActivity, "você viu o nome do desenvolvedor", Toast.LENGTH_LONG).show()
            }
            val alertDialogBox = artDialogBuilder.create()
            alertDialogBox.show()
        }

        btnCalculadora.setOnClickListener{
            IrParaCalculadora()
        }
        btnTelefonia.setOnClickListener{
            IrParaTelefonia()
        }
    }

    private fun IrParaCalculadora(){
        val calculadora = Intent(this, Calculadora::class.java)
        startActivity(calculadora)
    }

    private fun IrParaTelefonia(){
        val telefonia = Intent(this, Telefonia::class.java)
        startActivity(telefonia)
    }
}