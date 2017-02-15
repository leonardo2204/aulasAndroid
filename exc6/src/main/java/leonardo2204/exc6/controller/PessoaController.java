package leonardo2204.exc6.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import leonardo2204.exc6.CriarBanco;
import leonardo2204.exc6.model.Pessoa;

/**
 * Created by leonardo on 2/15/17.
 */

public class PessoaController {

    private SQLiteDatabase sqLiteDatabase;
    private CriarBanco criarBanco;

    public PessoaController(Context context) {
        criarBanco = new CriarBanco(context);
    }

    public String inserir(Pessoa pessoa){
        ContentValues valores;
        long resultado;

        sqLiteDatabase = criarBanco.getWritableDatabase();

        valores = new ContentValues();
        valores.put(CriarBanco.NOME_PESSOA, pessoa.getNome());
        valores.put(CriarBanco.IDADE_PESSOA, pessoa.getIdade());

        resultado = sqLiteDatabase.insertOrThrow(CriarBanco.TABELA_PESSOA, null, valores);

        if(resultado == -1){
            return "Erro ao inserir registro de pessoa !";
        }else{
            return "Registro com id " + resultado + " inserido com sucesso !";
        }
    }

    public Cursor carregarDados(){
        Cursor cursor;
        String[] campos = {CriarBanco.NOME_PESSOA, CriarBanco.IDADE_PESSOA};
        sqLiteDatabase = criarBanco.getReadableDatabase();

        cursor = sqLiteDatabase.query(CriarBanco.TABELA_PESSOA, campos, null, null, null, null, null);
        if(cursor != null)
            cursor.moveToFirst();

        sqLiteDatabase.close();
        return cursor;
    }

}
