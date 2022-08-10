package com.example.persistenciadados

import DatabaseManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = DatabaseManager(this, "saudacoes")

        btn_save.setOnClickListener(View.OnClickListener{
            db.removeSaudacao()
            db.insereSaudacao(1,input_name.text.toString(), input_spinner.selectedItem.toString())
            Toast.makeText(this, "Salvo com sucesso", Toast.LENGTH_LONG).show()
        })

        // Açao de click redireciona para a segunda activity
        btn_show.setOnClickListener(View.OnClickListener{
            val intent  = Intent(this, SaudacaoActivity::class.java)
            startActivity(intent)
        })
    }
}