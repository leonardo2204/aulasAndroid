package leonardo2204.exc4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Switch;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView nomeTextView;
    TextView idadeTextView;
    Switch paramSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        nomeTextView = (TextView) findViewById(R.id.nome_detail);
        idadeTextView = (TextView) findViewById(R.id.idade_detail);
        paramSwitch = (Switch) findViewById(R.id.temParametro);

        if(getIntent().getExtras() != null){
            String nome = getIntent().getExtras().getString("nome");
            nomeTextView.setText(nome);

            String idade = getIntent().getExtras().getString("idade");
            idadeTextView.setText(idade);

            paramSwitch.setChecked(getIntent().getExtras().getBoolean("comParam"));
        }
    }
}
