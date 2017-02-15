package leonardo2204.exc6.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import leonardo2204.exc6.R;

public class ListaContatosActivity extends AppCompatActivity implements ListaContatosFragment.OnAddClick {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_contatos);

        if(getSupportFragmentManager().findFragmentByTag("lista") == null)
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.lista_container, new ListaContatosFragment())
                    .commit();
    }

    @Override
    public void onClick() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.lista_container, new MainFragment())
                .addToBackStack(null)
                .commit();
    }
}
