package com.cs312.jumpshot;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class EventDBHelper extends SQLiteOpenHelper {

    static final String TAG = "DB Calls";
    static final String DATABASE_NAME = "eventDatabase.db";
    static final int DATABASE_VERSION = 1;

    static final String EVENT_TABLE = "events";
    static final String EVENT_TABLE_ID = "_id";
    static final String NAME = "name";
    static final String START_TIME = "startTime";
    static final String LOCATION = "address";
    static final String PHOTO_ID = "photoId";
    static final String PHOTO_NAME = "photoName";

    static final String EVENT_PHOTOS_TABLE = "eventPhotos";
    static final String EVENT_PHOTOS_TABLE_ID = "_id";

    public EventDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createEventTable = "CREATE TABLE "+EVENT_TABLE+" (" +
                EVENT_TABLE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NAME + " TEXT NOT NULL, "+
                START_TIME + " TEXT NOT NULL, "+
                LOCATION + " TEXT";

        String createEventPhotosTable = "CREATE TABLE "+EVENT_PHOTOS_TABLE+" (" +
                EVENT_PHOTOS_TABLE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "eventName TEXT NOT NULL, " +
                PHOTO_ID + " INTEGER, "+
                PHOTO_NAME + " TEXT, "+
                "FOREIGN KEY eventName REFERENCES "+EVENT_TABLE+"("+EVENT_TABLE_ID+")";

        db.execSQL(createEventTable);
        Log.d(TAG, "onCreate: "+createEventTable);
        db.execSQL(createEventPhotosTable);
        Log.d(TAG, "onCreate: "+createEventPhotosTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {}

    public void insertEvent(Event event) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, event.getEventName());
        contentValues.put(START_TIME, event.getStartTime());
        contentValues.put(LOCATION, event.getLocation());
    }
}
