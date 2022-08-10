package com.example.persistenciadados

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_saudacao.*

class SaudacaoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saudacao)

        // resgata o storage com a key saudacao
        val saudacaoPersistencia = this.getSharedPreferences("saudacao", Context.MODE_PRIVATE)
        // pega o valor do storage com a chave nome
        val nome = saudacaoPersistencia.getString("nome", "")
        // pega o valor do storage com a chave tratamento
        val tratamento = saudacaoPersistencia.getString("tratamento", "")

        // verificacao se vier o texto Sem tratamento do storage
        // ira apresenta na tela somente o nome digitado
        // senao ira concatenar o tratamento selecionado pelo spinner + o nome digitado
        if(tratamento.equals("Sem tratamento")){
            text_saudacao.text = nome
        } else {
            text_saudacao.text = tratamento + " " + nome
        }
    }
}