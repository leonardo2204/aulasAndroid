package leonardo2204.exc7.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import leonardo2204.exc7.R;

public class DogFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_dog);

        if(getSupportFragmentManager().findFragmentByTag("dogForm") == null)
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, new DogFormFragment(), "dogForm")
                    .commit();
    }
}
