package leonardo2204.exc5;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by leonardo on 2/13/17.
 */

public class MainFragment extends Fragment {

    private EditText nomeEditText;
    private EditText sobrenomeEditText;
    private Spinner sexoSpinner;
    private Button enviarButton;

    private EnviarEvent enviarEvent;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.enviarEvent = (EnviarEvent) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.enviarEvent = null;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        nomeEditText = (EditText) view.findViewById(R.id.nome);
        sobrenomeEditText = (EditText) view.findViewById(R.id.sobrenome);
        sexoSpinner = (Spinner) view.findViewById(R.id.sexo);
        enviarButton = (Button) view.findViewById(R.id.enviar);

        enviarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarEvent.enviarClick(nomeEditText.getText().toString(), sobrenomeEditText.getText().toString());
            }
        });

        setupSpinner();
    }

    private void setupSpinner(){
        String[] sexoList = getResources().getStringArray(R.array.sexo);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, sexoList);
        sexoSpinner.setAdapter(spinnerAdapter);
    }

    public interface EnviarEvent {
        void enviarClick(String nome, String sobrenome);
    }
}
