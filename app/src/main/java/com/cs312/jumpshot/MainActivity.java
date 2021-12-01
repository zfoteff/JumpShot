package com.cs312.jumpshot;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
<<<<<<< HEAD
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ActivityResultLauncher<Intent> launcher;
=======
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    static final String CHANNEL_ID = "JumpShot";
    NotificationManager notificationManager;
    Event testEvent = new Event(1, "Gonzaga v. Duke", "1 pm PST", "McCarthy Athletic Center", "photo");
>>>>>>> facd9912e04ff7b26da8e9a582ac65ed353a8e5d

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

<<<<<<< HEAD
        Button newEventButton = findViewById(R.id.addEventButton);
        newEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddEventActivity.class);

            }
        });

        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {

                    @Override
                    public void onActivityResult(ActivityResult result) {

                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Toast.makeText(MainActivity.this, "New Event Created", Toast.LENGTH_LONG).show();
                        }
                    }
                });

=======
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
>>>>>>> facd9912e04ff7b26da8e9a582ac65ed353a8e5d
    }
}