package leonardo2204.exc10;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class ContadorIntentService extends IntentService {

    public static final String CONTAGEM_INICIAL = "contagem_inicial";
    public static final String CONTAGEM_SAIDA = "contagem_saida";

    public ContadorIntentService() {
        super("ContadorIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        int contadorInicial = 0;

        if (intent != null) {
            contadorInicial = intent.getIntExtra(CONTAGEM_INICIAL, 0);
        }

        while(true) {
            Log.d("contador", "Contador: " + contadorInicial);

            ++contadorInicial;

            Intent broadcastIntent = new Intent();
            broadcastIntent.setAction(ContadorReceiver.CONTADOR_RESP);
            broadcastIntent.addCategory(Intent.CATEGORY_DEFAULT);
            broadcastIntent.putExtra(CONTAGEM_SAIDA, contadorInicial);
            sendBroadcast(broadcastIntent);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
