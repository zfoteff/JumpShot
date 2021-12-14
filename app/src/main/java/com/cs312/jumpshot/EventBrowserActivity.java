package com.cs312.jumpshot;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
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
    CustomAdaptor adaptor;

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

        openMapView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EventBrowserActivity.this, MapViewActivity.class);
                startActivity(intent);
            }
        });
    }

    class CustomAdaptor extends RecyclerView.Adapter<CustomAdaptor.CustomViewHolder> {
        class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            TextView name;
            TextView address;
            TextView startTime;
            CardView cards;

            public CustomViewHolder(@NonNull View itemView) {
                super(itemView);
                cards = itemView.findViewById(R.id.myCardView);
                name = itemView.findViewById(R.id.cardEventName);
                address = itemView.findViewById(R.id.cardEventAddress);
                startTime = itemView.findViewById(R.id.cardEventStarttime);
                itemView.setOnClickListener(this);
            }

            public void updateView(Event e) {
                Log.d(TAG, "updateView: ");
                name.setText(e.getEventName());
                address.setText(e.getLocation());
                startTime.setText(e.getStartTime());
            }

            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: ");
            }
        }

        @NonNull
        @Override
        public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(EventBrowserActivity.this)
                    .inflate(R.layout.card_view, parent, false);
            return new CustomViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
            Event event = eventList.get(position);
            holder.updateView(event);
        }

        @Override
        public int getItemCount() {
            return eventList.size();
        }
    }
}
