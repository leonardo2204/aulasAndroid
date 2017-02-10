package leonardo2204.exc4;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText nomeEditText;
    EditText idadeEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomeEditText = (EditText) findViewById(R.id.nome);
        idadeEditText = (EditText) findViewById(R.id.idade);
    }

    public void noParamNoAnim(View view) {
        Intent intent = new Intent(this, DetailActivity.class);
        startActivity(intent);
    }

    public void noParamWithAnim(View view) {
        Intent intent = new Intent(this, DetailActivity.class);

        startActivity(intent);
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }

    public void withParamNoAnim(View view) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("nome", nomeEditText.getText().toString());
        intent.putExtra("idade", idadeEditText.getText().toString());
        intent.putExtra("comParam", true);

        startActivity(intent);
    }

    public void withParamWithAnim(View view) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("nome", nomeEditText.getText().toString());
        intent.putExtra("idade", idadeEditText.getText().toString());
        intent.putExtra("comParam", true);

        startActivity(intent);
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }

}
