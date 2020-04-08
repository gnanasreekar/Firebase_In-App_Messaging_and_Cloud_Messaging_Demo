package com.rgs.firebasein_appmessagingdemo;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseInstanceIDService extends FirebaseMessagingService  {

    private final String CHANNEL_ID = "simple notification";
    private final int NOTIFICATION_ID = 1000;

    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
    }
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        if (remoteMessage.getNotification().getBody() != null) {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID);
            //Set notification icon
            builder.setSmallIcon(R.drawable.ic_launcher_background);

            //Set notification Title
            builder.setContentTitle(remoteMessage.getNotification().getTitle());

            //Set notification body
            builder.setContentText(remoteMessage.getNotification().getBody());

            //Set notification priority
            builder.setPriority(NotificationCompat.PRIORITY_HIGH);
            NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
            notificationManagerCompat.notify(NOTIFICATION_ID, builder.build());
        }
    }
}
