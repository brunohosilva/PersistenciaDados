package com.example.persistenciadados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_saudacao.*
import java.io.FileNotFoundException
import java.io.IOException
import java.nio.charset.Charset
import java.util.*

class SaudacaoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saudacao)

        // declarado na variavel tarefa a chamada da funcao recuperaDadoArquivo passando o nome do arquivo
        val data = recuperaDadoArquivo("saudacao")
        // realiza um split do string pelo termo ":"
        val tokenizer = StringTokenizer(data, ":")
        // verifica se no momento do split tem o campo nome, senao seta uma string com "Sem nome"
        val nome = if(tokenizer.hasMoreTokens()) tokenizer.nextToken() else "Sem nome"
        // verifica se no momento do split o campo tratamento , senao seta uma string com "Sem tratamento"
        val tratamento = if(tokenizer.hasMoreTokens()) tokenizer.nextToken() else "Sem Tratamento"

        // realiza verificacao, se em tratamento esta vindo a string "Sem tratamento"
        // caso verdadeiro no text da view ira renderizar somente o nome digitado e salve
        // senao no text da view ira renderizar o tratamento mais o nome
        if(tratamento.equals("Sem tratamento")) {
            text_saudacao.text = nome
        } else {
            text_saudacao.text = "$tratamento $nome"
        }

    }


    // funcao privada somente a essa classe
    // recebendo 1 paramentro o nome do arquivo
    // realiza a tentativa da abertura do arquivo
    // realiza a leitura dos bytes do arquivo
    private fun recuperaDadoArquivo(fileName: String): String {
        return try {
            val fi = openFileInput(fileName)
            val data = fi.readBytes()
            fi.close()
            data.toString()
            data.toString(Charset.defaultCharset())
        } catch (e: FileNotFoundException) {
            ""
        } catch (e: IOException){
            ""
        }
    }
}