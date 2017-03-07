package leonardo2204.exc14;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by leonardo on 3/7/17.
 */

public class MainFragment extends Fragment {

    @Bind(R.id.progressoFrag)
    ProgressBar progressoProgressBar;

    AsyncTask<Void, Integer, Void> asyncTask;

    public MainFragment() {
        setRetainInstance(true);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        asyncTask = new AsyncTask<Void, Integer, Void>() {

            int contador = 0;

            @Override
            protected void onPreExecute() {
                Toast.makeText(getActivity(), "Pre execute", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(getActivity(), "Pos execute", Toast.LENGTH_SHORT).show();
            }
        };
    }

    @OnClick(R.id.threadFrag)
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

    @OnClick(R.id.asyncTaskFrag)
    public void onAsyncTaskClick() {
        asyncTask.execute();
    }

    @OnClick(R.id.cancelarFrag)
    public void onCancelarClick() {
        asyncTask.cancel(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);

        return view;
    }
}
