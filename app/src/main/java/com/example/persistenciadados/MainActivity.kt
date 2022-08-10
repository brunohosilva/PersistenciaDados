package com.example.persistenciadados

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.FileNotFoundException
import java.io.IOException


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Na acao do click em salvar
        // criado uma variavel data onde ira concatenar
        // o nome digitado com 2 pontos mais o item selecionado do spinner
        // e passa esse data para dentro da funcao chamada gravaDadoArquivo
        // e é renderizado um toast com a mensagem de salvo com sucesso
        btn_save.setOnClickListener(View.OnClickListener{
            val data = input_name.text.toString() +  ":" + input_spinner.selectedItem.toString()
            gravaDadoArquivo("saudacao", data)
            Toast.makeText(this, "Salvo com sucesso", Toast.LENGTH_LONG ).show()
        })

        // Açao de click redireciona para a segunda activity
        btn_show.setOnClickListener(View.OnClickListener{
            val intent  = Intent(this, SaudacaoActivity::class.java)
            startActivity(intent)
        })
    }


    // Funcao onde é gerado um arquivo
    // recebe 2 parametros, o nome do arquivo e o dado a ser salvo nela
    // transforma o dado em um array de bytes
    // realiza uma validacao em casos de erros
    // sendo disparado no log algumas mensagens apontando o erro
    private fun gravaDadoArquivo(fileName: String, data: String){
        try {
            val fs = openFileOutput(fileName, Context.MODE_PRIVATE)
            fs.write(data.toByteArray())
            fs.close()
        }
        catch (e: FileNotFoundException){ Log.i("gravaDadoArquivo", "FileNotFoundException")}
        catch (e: IOException){ Log.i("gravaDadoArquivo", "IOException")}
    }
}