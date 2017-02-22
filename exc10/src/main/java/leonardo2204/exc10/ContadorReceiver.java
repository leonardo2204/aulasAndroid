package leonardo2204.exc10;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ContadorReceiver extends BroadcastReceiver {

    public static final String CONTADOR_RESP = "contador_resp";

    public ContadorReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        int contador = intent.getIntExtra(ContadorIntentService.CONTAGEM_SAIDA, 0);
        Toast.makeText(context, "Contador: " + contador, Toast.LENGTH_SHORT).show();
    }
}
