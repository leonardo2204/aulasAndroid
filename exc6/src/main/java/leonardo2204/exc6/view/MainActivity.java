package leonardo2204.exc6.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import leonardo2204.exc6.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getSupportFragmentManager().findFragmentByTag("main") == null)
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, new MainFragment(), "main")
                    .commit();
    }
}
