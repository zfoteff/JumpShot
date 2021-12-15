package com.cs312.jumpshot;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class eventDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_view);


        ImageView photoDisplay = findViewById(R.id.photoDisplay);
        TextView eventName = findViewById(R.id.eventTitle);
        TextView eventLoc = findViewById(R.id.eventLocation2);
        TextView eventStartTime = findViewById(R.id.eventTime);

        Intent intent = getIntent();
        if (intent != null) {

            String name = intent.getStringExtra("name");
            String loc = intent.getStringExtra("location");
            String startTime = intent.getStringExtra("startTime");

            byte[] byteArray = getIntent().getByteArrayExtra("photo");
            Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);

            photoDisplay.setImageBitmap(bmp);
        }

        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
