package leonardo2204.exc6;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by leonardo on 2/15/17.
 */

public class ContatosAdapter extends CursorRecyclerViewAdapter<ContatosAdapter.ViewHolder> {

    public ContatosAdapter(Context context, Cursor cursor) {
        super(context, cursor);
        swapCursor(cursor);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Cursor cursor) {
            viewHolder.nome.setText(cursor.getString(0));
            viewHolder.idade.setText(String.valueOf(cursor.getInt(1)));
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_contatos, parent, false));
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
