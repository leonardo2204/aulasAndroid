package leonardo2204.ex13;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private NotificationManager notificationManager;
    PendingIntent openNotificationIntent;
    private final int NOTIFICATION_ID = 237;
    private static int value = 0;
    NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();

    @Bind(R.id.idInput)
    EditText inputEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        createPendingNotification();
        ButterKnife.bind(this);
    }

    private void createPendingNotification() {
        openNotificationIntent = PendingIntent.getActivity(this, 0, new Intent(this, ResultActivity.class), 0);
    }

    @OnClick(R.id.nova)
    public void novaClick() {
        int random = (int) (Math.random() * 10000);

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.ic_stat_name)
                        .setContentTitle("Primeira notificação")
                        .setStyle(new NotificationCompat.BigTextStyle().bigText("Aeee, criamos nossa primeira notificação com o id: " + random))
                        //.setAutoCancel(true)
                        .setContentIntent(openNotificationIntent)
                        .setContentText("Primeira notificação criada :D");

        notificationManager.notify(random, mBuilder.build());
    }

    @OnClick(R.id.atualizar)
    public void updateClick() {
        int id = Integer.valueOf(inputEditText.getText().toString());

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.ic_stat_name)
                        .setContentTitle("Primeira notificação")
                        .setStyle(new NotificationCompat.BigTextStyle().bigText("Atualizmos essa notificação !!!"))
                        //.setAutoCancel(true)
                        .setContentIntent(openNotificationIntent)
                        .setContentText("Alteramos o texto !")
                        .setNumber((int) (Math.random() * 100));

        notificationManager.notify(id, mBuilder.build());
    }

    @OnClick(R.id.cancelar)
    public void cancelClick() {
        int id = Integer.valueOf(inputEditText.getText().toString());

        notificationManager.cancel(id);
    }

    @OnClick(R.id.agrupar)
    public void groupClick() {
        ++value;

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("Notificacoes");
        builder.setContentText("Total de notificacoes: "+value);
        builder.setSmallIcon(R.drawable.ic_stat_name);
        builder.setAutoCancel(true);
        inboxStyle.setBigContentTitle("Cabeçalho");
        inboxStyle.addLine("Qtde eventos:  "+value);
        builder.setStyle(inboxStyle);
        notificationManager.notify("bla",NOTIFICATION_ID ,builder.build());
    }

}
