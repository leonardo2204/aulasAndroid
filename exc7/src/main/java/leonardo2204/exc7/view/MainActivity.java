package leonardo2204.exc7.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.util.List;

import io.realm.Realm;
import leonardo2204.exc7.R;
import leonardo2204.exc7.model.Cachorro;

public class MainActivity extends AppCompatActivity {

    ImageButton personImageButton;
    ImageButton dogImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personImageButton = (ImageButton) findViewById(R.id.newPerson);
        dogImageButton = (ImageButton) findViewById(R.id.newDog);

        personImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ListaPessoasActivity.class));
            }
        });

        dogImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DogFormActivity.class));
            }
        });
    }
}
