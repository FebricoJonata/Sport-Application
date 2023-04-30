package com.example.sportapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.sportapp.database.modal.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketDatabaseHelper extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "msSportApps";
    private static final String TABLE_NAME = "tickets";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_CATEGORY = "category";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_QUANTITY = "quantity";

    private Context ctx;


    public TicketDatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.ctx = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_CATEGORY + " TEXT, " +
                COLUMN_DATE + " TEXT, " +
                COLUMN_QUANTITY + " INTEGER);";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void addData(String name, String category, String date, int quantity){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_CATEGORY, category);
        values.put(COLUMN_DATE, date);
        values.put(COLUMN_QUANTITY, quantity);

        long result = db.insert(TABLE_NAME, null, values);
        if(result == -1){
            Toast.makeText(ctx, "Failed to Input Data", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(ctx, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
        db.close();
    }


    public List<Ticket> getAllData(){
        List<Ticket> ticketList = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            do{
                Ticket ticket = new Ticket();
                ticket.setId(Integer.parseInt(cursor.getString(0)));
                ticket.setName(cursor.getString(1));
                ticket.setCategory(cursor.getString(2));
                ticket.setDate((cursor.getString(3)));
                ticket.setQuantity(Integer.parseInt(cursor.getString(4)));
                ticketList.add(ticket);
            }while (cursor.moveToNext());
        }
        return ticketList;
    }

    public void deleteAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME);
    }

}
