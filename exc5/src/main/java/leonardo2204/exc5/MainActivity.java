package leonardo2204.exc5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements MainFragment.EnviarEvent {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupFragment();
    }

    private void setupFragment() {
        MainFragment mainFragment = MainFragment.newInstance();

        if(getSupportFragmentManager().findFragmentByTag("main") == null)
            getSupportFragmentManager().beginTransaction().add(R.id.container, mainFragment, "main").commit();
    }

    @Override
    public void enviarClick(String nome, String sobrenome) {
        DetailFragment detailFragment = DetailFragment.newInstance(nome, sobrenome);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, detailFragment)
                //.addToBackStack(null)
                .commit();
    }
}
