package com.example.persistenciadados

import DatabaseManager
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_saudacao.*

class SaudacaoActivity : AppCompatActivity() {
    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saudacao)

        // Instancia a clase DatabaseManager
        // Faz a leitura dos dados do banco local
        // Regata os dados e insere nas variaveis nome e tratamento
        // Se tem dados no banco, mostra na dela do usuário o nome + tratamento
        // Senão mostra somente o nome
        val db = DatabaseManager(this, "saudacoes")
        val cursor = db.listaSaudacao()
        var nome = ""
        var tratamento = ""
        if(cursor.count > 0){
            cursor.moveToFirst()
            nome = cursor.getString(cursor.getColumnIndex("NOME"))
            tratamento = cursor.getString(cursor.getColumnIndex("TRATAMENTO"))
        }
        if(tratamento.equals("Sem tratamento")){
            text_saudacao.text = nome
        } else {
            text_saudacao.text = tratamento + " " + nome
        }
    }
}