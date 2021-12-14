package com.cs312.jumpshot;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class EventBrowserActivity extends AppCompatActivity {
    static final String TAG = "EventBrowser";
    private EventDBHelper dbHelper = new EventDBHelper(EventBrowserActivity.this);
    private RecyclerView recyclerView;
    private Button openMapView;
    private List<Event> eventList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreate called for EventBrowser Activity: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_browser);
        openMapView = (Button) findViewById(R.id.mapButton);
        recyclerView = (RecyclerView) findViewById(R.id.eventList);
        eventList = new ArrayList<>();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adaptor = new CustomAdaptor();
        recyclerView.setAdapter(adaptor);
    }

    class CustomAdaptor 
}
