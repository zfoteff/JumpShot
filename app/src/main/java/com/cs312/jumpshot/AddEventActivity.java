package com.cs312.jumpshot;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddEventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_event);

        EditText eventName = findViewById(R.id.eventName);
        EditText eventLocation = findViewById(R.id.eventLocation);
        EditText eventTime = findViewById(R.id.eventStartTime);

        Intent intent = getIntent();
        if (intent != null) {

        }

        Button saveButton = findViewById(R.id.saveEvent);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();

                intent.putExtra("newEventName", eventName.getText().toString());
                intent.putExtra("newEventLocation", eventLocation.getText().toString());
                intent.putExtra("newEventTime", eventTime.getText().toString());

                AddEventActivity.this.setResult(Activity.RESULT_OK, intent);
                AddEventActivity.this.finish();
            }
        });
    }

}
