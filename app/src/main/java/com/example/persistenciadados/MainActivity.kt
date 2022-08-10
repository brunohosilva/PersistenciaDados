package com.example.persistenciadados

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // No click do botao salvar, ira iniciar a criacao do storage com a key saudacao
        // e ira seta 2 constantes, nome e tratamento
        // pegando os valores digitados pelo input e pelo spinner e associando
        // os valores as chaves do storage
        btn_save.setOnClickListener(View.OnClickListener{
            val saudacaoPersistencia = this.getSharedPreferences("saudacao", Context.MODE_PRIVATE)
            val editor = saudacaoPersistencia.edit()

            editor.putString("nome", input_name.text.toString())
            editor.putString("tratamento", input_spinner.selectedItem.toString())
            editor.apply()
        })


        // Clicando no botao de exibir saudacao
        // é navegado para uma outra activity
        btn_show.setOnClickListener(View.OnClickListener{
            val intent  = Intent(this, SaudacaoActivity::class.java)
            startActivity(intent)
        })
    }
}