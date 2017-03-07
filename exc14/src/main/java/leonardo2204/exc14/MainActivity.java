package leonardo2204.exc14;

import android.os.AsyncTask;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.progresso)
    ProgressBar progressoProgressBar;

    AsyncTask<Void, Integer, Void> asyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        asyncTask = new AsyncTask<Void, Integer, Void>() {

            int contador = 0;

            @Override
            protected void onPreExecute() {
                Toast.makeText(MainActivity.this, "Pre execute", Toast.LENGTH_SHORT).show();
            }

            @Override
            protected Void doInBackground(Void... voids) {

                while(contador < 100) {
                    if(isCancelled())
                        break;

                    contador++;

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    publishProgress(contador);
                }

                return null;
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                progressoProgressBar.setProgress(values[0]);
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                Toast.makeText(MainActivity.this, "Pos execute", Toast.LENGTH_SHORT).show();
            }
        };

        if(getSupportFragmentManager().findFragmentByTag("main") == null)
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container ,new MainFragment(), "main")
                    .commit();
    }

    @OnClick(R.id.thread)
    public void onThreadClick(){
        new Thread(new Runnable() {
            int contador = 0;

            @Override
            public void run() {

                while(contador < 100) {
                    contador++;

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    progressoProgressBar.post(new Runnable() {
                        @Override
                        public void run() {
                            progressoProgressBar.setProgress(contador);
                        }
                    });
                }

            }
        }).start();
    }

    @OnClick(R.id.asyncTask)
    public void onAsyncTaskClick() {
        asyncTask.execute();
    }

    @OnClick(R.id.cancelar)
    public void onCancelarClick() {
        asyncTask.cancel(true);
    }

}
