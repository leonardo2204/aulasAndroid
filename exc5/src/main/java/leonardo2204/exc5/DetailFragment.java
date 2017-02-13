package leonardo2204.exc5;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by leonardo on 2/13/17.
 */

public class DetailFragment extends Fragment {

    TextView nomeTextView;
    TextView sobrenomeTextView;

    public static DetailFragment newInstance(String nome, String sobrenome){
        DetailFragment detailFragment = new DetailFragment();

        Bundle bundle = new Bundle();
        bundle.putString("nome", nome);
        bundle.putString("sobrenome", sobrenome);

        detailFragment.setArguments(bundle);

        return detailFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        nomeTextView = (TextView) view.findViewById(R.id.nome_detail);
        sobrenomeTextView = (TextView) view.findViewById(R.id.sobrneome_detail);

        String nome = getArguments().getString("nome");
        String sobrenome = getArguments().getString("sobrenome");

        nomeTextView.setText(nome);
        sobrenomeTextView.setText(sobrenome);
    }
}
