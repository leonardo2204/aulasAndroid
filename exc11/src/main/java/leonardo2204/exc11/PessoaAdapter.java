package leonardo2204.exc11;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by leonardo on 2/24/17.
 */

public class PessoaAdapter extends RecyclerView.Adapter<PessoaAdapter.PessoaViewHolder> {

    private List<Pessoa> pessoaList;

    public PessoaAdapter(List<Pessoa> pessoaList) {
        this.pessoaList = pessoaList;
    }

    @Override
    public PessoaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_pessoa, parent, false);
        return new PessoaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PessoaViewHolder holder, int position) {
        Pessoa pessoa = pessoaList.get(position);

        holder.nomeInteiroTextView.setText(pessoa.getNome() + " " + pessoa.getSobrenome());
        holder.empregoTextView.setText(pessoa.getEmprego());

        if(pessoa.isCasado())
            holder.estadoCivil.setImageResource(R.drawable.casado);
        else
            holder.estadoCivil.setImageResource(R.drawable.single);
    }

    @Override
    public int getItemCount() {
        return pessoaList.size();
    }

    static class PessoaViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.nomeInteiro)
        TextView nomeInteiroTextView;

        @Bind(R.id.emprego)
        TextView empregoTextView;

        @Bind(R.id.casado)
        ImageView estadoCivil;

        public PessoaViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
