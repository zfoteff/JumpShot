package com.cs312.jumpshot;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EventBrowserActivity extends AppCompatActivity {
    static final String TAG = "EventBrowser";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreate called for EventBrowser Activity: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_browser);

    }
}
