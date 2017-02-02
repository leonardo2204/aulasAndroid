package leonardo2204.quaddroaulas;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nomeEditText;
    EditText idadeEditText;
    EditText pesoEditText;
    Switch salvarInfoSwitch;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomeEditText = (EditText) findViewById(R.id.nome);
        idadeEditText= (EditText) findViewById(R.id.idade);
        pesoEditText= (EditText) findViewById(R.id.peso);
        salvarInfoSwitch= (Switch) findViewById(R.id.salvarInfo);

        sharedPreferences = getSharedPreferences("info_usuario", CONTEXT_RESTRICTED);

        recuperarInfo();
    }

    public void salvar(View view) {
        Toast.makeText(this, "Enviando informações...", Toast.LENGTH_SHORT).show();

        String nome = nomeEditText.getText().toString();
        int idade = Integer.valueOf(idadeEditText.getText().toString());
        float peso = Float.valueOf(pesoEditText.getText().toString());

        Pessoa pessoa = new Pessoa(nome, idade, peso);

        if(salvarInfoSwitch.isChecked()){
            sharedPreferences.edit().putString("nome", pessoa.getNome()).putInt("idade", pessoa.getIdade()).putFloat("peso", pessoa.getPeso()).putBoolean("salvo", true).apply();
        }else{
            sharedPreferences.edit().putBoolean("salvo", false).apply();
        }
    }

    public void recuperarInfo() {
        if(sharedPreferences.getBoolean("salvo", false)){
            Pessoa pessoa = new Pessoa();

            String nome = sharedPreferences.getString("nome", null);
            int idade = sharedPreferences.getInt("idade", 0);
            float peso = sharedPreferences.getFloat("peso", 0.0f);

            pessoa.setIdade(idade);
            pessoa.setNome(nome);
            pessoa.setPeso(peso);

            nomeEditText.setText(pessoa.getNome());
            idadeEditText.setText(String.valueOf(pessoa.getIdade()));
            pesoEditText.setText(String.valueOf(pessoa.getPeso()));
        }
    }

}
