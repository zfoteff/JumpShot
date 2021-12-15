package com.cs312.jumpshot;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class photoDisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_view);


        ImageView photoDisplay = findViewById(R.id.photoDisplay);
        Intent intent = getIntent();
        if (intent != null) {

            byte[] byteArray = getIntent().getByteArrayExtra("photo");
            Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);

            photoDisplay.setImageBitmap(bmp);
        }
    }
}
