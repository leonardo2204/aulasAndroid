package leonardo2204.exc6;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by leonardo on 2/15/17.
 */

public class CriarBanco extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "banco.db";

    //tabela pessoas
    public static final String TABELA_PESSOA = "pessoas";
    public static final String ID_PESSOA = "_id";
    public static final String NOME_PESSOA = "nome";
    public static final String IDADE_PESSOA = "idade";

    //tabela contatos
    public static final String TABELA_CONTATOS = "contatos";
    public static final String ID_CONTATOS = "_id";
    public static final String ID_PESSOA_FK = "id_pessoa";
    public static final String NOME_CONTATOS = "telefone";


    public CriarBanco(Context context) {
        super(context, NOME_BANCO, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String sqlPessoa = "CREATE TABLE " + TABELA_PESSOA + "("
                + NOME_PESSOA + " text,"
                + IDADE_PESSOA + " integer"
                +");";

        String sqlContato = "CREATE TABLE " + TABELA_CONTATOS + "("
                + NOME_CONTATOS + " text,"
                + ID_PESSOA_FK + " integer,"
                + "FOREIGN KEY (" + ID_PESSOA_FK + ") REFERENCES " + TABELA_PESSOA + "(" + ID_PESSOA + ")"
                +");";

        sqLiteDatabase.execSQL(sqlPessoa);
        sqLiteDatabase.execSQL(sqlContato);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABELA_CONTATOS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABELA_PESSOA);

        onCreate(sqLiteDatabase);
    }
}
