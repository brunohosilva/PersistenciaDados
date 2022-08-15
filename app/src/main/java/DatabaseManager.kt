import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseManager(context: Context, name: String): SQLiteOpenHelper(context, name, null, 1) {
    // Metodo que cria a tabela com seus respectivos campos
    override fun onCreate(p0: SQLiteDatabase) {
        p0?.execSQL("CREATE TABLE SAUDACAO(\n"+
        "\tID_SAUDACAO INT NOT NULL,\n"+
        "\tNOME VARCHAR(20),\n"+
        "\tTRATAMENTO VARCHAR(20), \n"+
        "\tPRIMARY KEY (ID_SAUDACAO)\n" +
        "\t);")
    }

    // Metodo de atualização do banco de dados quando necessario
    override fun onUpgrade(p0: SQLiteDatabase, p1: Int, p2: Int) {
        p0?.execSQL("DROP TABLE IF EXISTS SAUDACAO")
        p0?.execSQL("CREATE TABLE SAUDACAO(\n "+
        "\tID_SAUDACAO INT NOT NULL,\n"+
        "\tNOME VARCHAR(20),\n"+
        "\tTRATAMENTO VARCHAR(20),\n"+
        "\tPRIMARY KEY (ID_SAUDACAO)\n"+
        "\t);")
    }

    // Metodo que recebe os dados vindo do input e inserido no banco de dados local
    fun insereSaudacao(id: Int, nome: String, tratamento: String){
        var db = this.writableDatabase
        var cv = ContentValues()
        cv.put("ID_SAUDACAO", id)
        cv.put("NOME", nome)
        cv.put("TRATAMENTO", tratamento)
        db.insert("SAUDACAO", "ID_SAUDACAO", cv)
    }

    // Metodo que faz a leitura do dados do banco com os dados inseridos no input
    fun listaSaudacao(): Cursor {
        var db = this.readableDatabase
        var cur = db.rawQuery("select nome, tratamento from saudacao", null)
        return cur
    }

    // Metodo de deleção da tabela do banco local
    fun removeSaudacao(){
        var db = this.readableDatabase
        db.delete("SAUDACAO", "ID_SAUDACAO=1", null)
    }
}