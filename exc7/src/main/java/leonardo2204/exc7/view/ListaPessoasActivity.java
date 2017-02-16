package leonardo2204.exc7.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import leonardo2204.exc7.R;

public class ListaPessoasActivity extends AppCompatActivity implements ListaPessoasFragment.OnAddClick {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pessoas);

        if(getSupportFragmentManager().findFragmentByTag("lista") == null)
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.lista_container, new ListaPessoasFragment(), "lista")
                    .commit();
    }

    @Override
    public void onClick() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.lista_container, new PersonFormFragment())
                .addToBackStack(null)
                .commit();
    }
}
