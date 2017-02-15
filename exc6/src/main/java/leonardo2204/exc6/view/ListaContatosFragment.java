package leonardo2204.exc6.view;


import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import leonardo2204.exc6.ContatosAdapter;
import leonardo2204.exc6.R;
import leonardo2204.exc6.controller.PessoaController;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaContatosFragment extends Fragment {

    RecyclerView recyclerView;
    OnAddClick onAddClick;
    Cursor cursor;
    ContatosAdapter contatosAdapter;

    public ListaContatosFragment() {
        // Required empty public constructor
        setHasOptionsMenu(true);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        this.onAddClick = (OnAddClick) context;
    }

    @Override
    public void onStart() {
        super.onStart();

        PessoaController pessoaController = new PessoaController(getContext());
        cursor = pessoaController.carregarDados();
        contatosAdapter = new ContatosAdapter(getContext(), cursor);
        recyclerView.setAdapter(contatosAdapter);
    }

    @Override
    public void onStop() {
        super.onStop();
        if(cursor != null)
            cursor.close();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_lista, menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menu_add){
            this.onAddClick.onClick();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_contatos, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.listaContatos);

        LinearLayoutManager llm = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(llm);
    }

    public interface OnAddClick {
        void onClick();
    }

}
