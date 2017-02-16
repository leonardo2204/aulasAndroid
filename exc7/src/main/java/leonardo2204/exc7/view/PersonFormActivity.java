package leonardo2204.exc7.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import leonardo2204.exc7.R;

public class PersonFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_person);

        if(getSupportFragmentManager().findFragmentByTag("personForm") == null)
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, new PersonFormFragment(), "personForm")
                    .commit();
    }
}
