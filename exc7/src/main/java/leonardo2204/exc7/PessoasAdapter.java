package leonardo2204.exc7;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;
import leonardo2204.exc7.model.Pessoa;

/**
 * Created by leonardo on 2/15/17.
 */

public class PessoasAdapter extends RealmRecyclerViewAdapter<Pessoa, PessoasAdapter.ViewHolder> {

    public PessoasAdapter(@NonNull Context context, @Nullable OrderedRealmCollection<Pessoa> data) {
        super(context, data, true);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_pessoas, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nome.setText(getData().get(position).getNome());
        holder.idade.setText(String.valueOf(getData().get(position).getIdade()));
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView nome;
        TextView idade;

        public ViewHolder(View itemView) {
            super(itemView);

            nome = (TextView) itemView.findViewById(R.id.nome_detail);
            idade = (TextView) itemView.findViewById(R.id.idade_detail);
        }
    }

}
