package leonardo2204.exc7;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import leonardo2204.exc7.model.Pessoa;

/**
 * Created by leonardo on 2/16/17.
 */

public class DonoAdapter extends ArrayAdapter<Pessoa> {

    private List<Pessoa> pessoas;
    private Context context;

    public DonoAdapter(Context context, List<Pessoa> pessoas) {
        super(context, android.R.layout.simple_list_item_1, pessoas);
        this.pessoas = pessoas;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView label = new TextView(context);
        label.setText(pessoas.get(position).getNome());
        label.setTextSize(20f);
        label.setPadding(16,16,16,16);

        return label;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView label = new TextView(context);
        label.setText(pessoas.get(position).getNome());
        label.setTextSize(20f);
        label.setPadding(16,16,16,16);

        return label;
    }
}
