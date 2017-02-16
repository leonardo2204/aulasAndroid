package leonardo2204.exc7.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import io.realm.Realm;
import leonardo2204.exc7.DonoAdapter;
import leonardo2204.exc7.R;
import leonardo2204.exc7.controller.PessoaController;
import leonardo2204.exc7.model.Cachorro;
import leonardo2204.exc7.model.Pessoa;

/**
 * A simple {@link Fragment} subclass.
 */
public class DogFormFragment extends Fragment {

    private Spinner donoSpinner;
    private Button enviarButton;

    private List<Pessoa> pessoas;
    private Pessoa dono;

    public DogFormFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_form_dog, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        donoSpinner = (Spinner) view.findViewById(R.id.dono_spinner);
        donoSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                dono = pessoas.get(pos);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        enviarButton = (Button) view.findViewById(R.id.dog_enviar);
        enviarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), dono.getNome(), Toast.LENGTH_SHORT).show();
                Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        Cachorro cachorro = new Cachorro();
                        cachorro.setPeso(23f);
                        cachorro.setNome("Kiki");
                        cachorro.setIdade(1);

                        dono.getCachorros().add(cachorro);
                    }
                });
            }
        });

        populateDonos();
    }

    private void populateDonos(){
        PessoaController pessoaController = new PessoaController();
        this.pessoas = pessoaController.carregarDados();

        DonoAdapter donoAdapter = new DonoAdapter(getActivity(), pessoas);
        donoSpinner.setAdapter(donoAdapter);
    }

}
