package com.cs312.jumpshot;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;


import android.app.Activity;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;



import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    static final String TAG = "MainActivtyTAG";
    static final String CHANNEL_ID = "JumpShot";
    NotificationManager notificationManager;
    Event testEvent = new Event(1, "Gonzaga v. Duke", "1 pm PST", "McCarthy Athletic Center", "photo");
    ActivityResultLauncher<Intent> launcher;
    List<Event> eventList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eventList = new ArrayList<>();

        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {

                    @Override
                    public void onActivityResult(ActivityResult result) {

                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Toast.makeText(MainActivity.this, "New Event Created", Toast.LENGTH_LONG).show();
//                            Intent event = result.getData();
//                            String eventName = event.getStringExtra("newEventName");
//                            String eventLocation

                        }
                    }
                });

        Button newEventButton = findViewById(R.id.createEventButton);
        newEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Making a new event");
                Intent intent = new Intent(MainActivity.this, AddEventActivity.class);

                launcher.launch(intent);
            }
        });


        openNotificationChannel();
        Button notificationButton = findViewById(R.id.notificationButton);

        notificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(MainActivity.this, CHANNEL_ID)
                        .setSmallIcon(R.drawable.stadium)
                        .setContentTitle("An event is about to start near you!")
                        .setContentText(testEvent.eventName+" starts at "+testEvent.startTime)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);
                notificationManager.notify(0, notificationBuilder.build());
            }
        });
    }

    private void openNotificationChannel() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_desc);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

    }
}