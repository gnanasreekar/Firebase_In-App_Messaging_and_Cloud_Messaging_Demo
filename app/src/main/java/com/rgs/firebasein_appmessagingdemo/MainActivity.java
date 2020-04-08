package com.rgs.firebasein_appmessagingdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity {

    private final String CHANNEL_ID = "notification";
    private FirebaseAnalytics mFirebaseAnalytics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);


        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d("Firebaseeeeeeeeeeeee", "Refreshed token: " + refreshedToken);

        //For android 8+ we need to create a notification channel to send notifications

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence charSequence = "Notification";
            String notification_discription = "Notification discription";
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, charSequence, NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setDescription(notification_discription);

            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);

            // The id of the group.
            String groupId = "my_group_01";
            // The user-visible name of the group.
            CharSequence groupName = "Group1";
            NotificationManager mnotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            mnotificationManager.createNotificationChannelGroup(new NotificationChannelGroup(groupId, groupName));
        }
    }
}
