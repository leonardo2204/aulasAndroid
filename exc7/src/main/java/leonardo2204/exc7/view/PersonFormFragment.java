package leonardo2204.exc7.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import leonardo2204.exc7.R;
import leonardo2204.exc7.controller.PessoaController;
import leonardo2204.exc7.model.Pessoa;


/**
 * A simple {@link Fragment} subclass.
 */
public class PersonFormFragment extends Fragment {

    EditText nomeEditText;
    EditText idadeEditText;
    Button enviarButton;

    private PessoaController pessoaController;

    public PersonFormFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pessoaController = new PessoaController();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_form_person, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        nomeEditText = (EditText) view.findViewById(R.id.name);
        idadeEditText = (EditText) view.findViewById(R.id.idade);
        enviarButton = (Button) view.findViewById(R.id.enviar);

        enviarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = nomeEditText.getText().toString();
                int idade = Integer.valueOf(idadeEditText.getText().toString());

                String resultado = pessoaController.inserir(new Pessoa(nome, idade));
                Toast.makeText(getActivity(), resultado, Toast.LENGTH_SHORT).show();
                getFragmentManager().popBackStack();
            }
        });
    }
}