package leonardo2204.exc7.controller;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import leonardo2204.exc7.model.Pessoa;

/**
 * Created by leonardo on 2/15/17.
 */

public class PessoaController {

    public PessoaController() {

    }

    public String inserir(final Pessoa pessoa){
        Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
               realm.insertOrUpdate(pessoa);
            }
        });

        return "Sucesso ao inserir registro.";
    }

    public RealmResults<Pessoa> carregarDados(){
        RealmQuery<Pessoa> query = Realm.getDefaultInstance().where(Pessoa.class);

        return query.findAll();
    }

}
