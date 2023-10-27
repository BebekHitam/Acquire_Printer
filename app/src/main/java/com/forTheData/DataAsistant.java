package com.forTheData;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.google.android.material.tabs.TabLayout;

public class DataAsistant extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "AcquirePrintData";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "UserData";

    private static final String COLUMN_ID="id";
    private static final String COLUMN_FIRST_NAME="first_name";
    private static final String COLUMN_LAST_NAME="last_name";
    private static final String COLUMN_EMAIL="email";
    private static final String COLUMN_PASSWORD="password";
    private static final String COLUMN_CITY="city";

    private static final String CREATE_TABRE = "CREATE TABLE " + TABLE_NAME + "(" +
            COLUMN_ID + "INTEGER PRIMARY KEY NOT NULL AUTOINCREMENT, " +
            COLUMN_FIRST_NAME + "TEXT NOT NULL, " +
            COLUMN_LAST_NAME + "TEXT, " +
            COLUMN_EMAIL + "TEXT, " +
            COLUMN_PASSWORD + "TEXT, " +
            COLUMN_CITY + "TEXT" +
            ")";
    public DataAsistant(Context context){
        super(context, DATABASE_NAME, null,  DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABRE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);

    }
    public void insertProfile(String firstname, String lastName, String email, String password, String city){
        SQLiteDatabase dbes = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_FIRST_NAME, firstname);
        values.put(COLUMN_LAST_NAME, lastName);
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_PASSWORD, password);
        values.put(COLUMN_CITY, city);


        dbes.insert(TABLE_NAME, null, values);
        dbes.close();
    }
}
