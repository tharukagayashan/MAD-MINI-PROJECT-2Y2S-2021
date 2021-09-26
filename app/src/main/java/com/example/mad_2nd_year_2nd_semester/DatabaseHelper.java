package com.example.mad_2nd_year_2nd_semester;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "MAD2021";
    private static final String TABLE_NAME = "booking";
    private static final int VERSION = 1;

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    private static final String COL_1 = "id";
    private static final String COL_2 = "class";
    private static final String COL_3 = "name";
    private static final String COL_4 = "date";
    private static final String COL_5 = "mobile";
    private static final String COL_6 = "show_time";
    private static final String COL_7 = "center";
    private static final String COL_8 = "ticket_count";

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREATE_SQL_QUERY = "CREATE TABLE " + TABLE_NAME + "(" +
                COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_2 + " TEXT," +
                COL_3 + " TEXT," +
                COL_4 + " TEXT," +
                COL_5 + " TEXT," +
                COL_6 + " TEXT," +
                COL_7 + " TEXT," +
                COL_8 + " TEXT)";

        sqLiteDatabase.execSQL(CREATE_SQL_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        onCreate(sqLiteDatabase);
    }

    public boolean InsertData(Booking booking){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues value = new ContentValues();

        value.put(COL_2,booking.getTicketClass());
        value.put(COL_3,booking.getFullName());
        value.put(COL_4,booking.getDate());
        value.put(COL_5,booking.getMobileNo());
        value.put(COL_6,booking.getShowTime());
        value.put(COL_7,booking.getCenter());
        value.put(COL_8,booking.getTicketCount());

        long result = db.insert(TABLE_NAME,null,value);

        if(result == -1){
            return false;
        }
        else {
            return true;
        }

    }

    public List<Booking> getAllData(){

        List <Booking> bookings = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String GET_DATA_QUERY = "SELECT * FROM " + TABLE_NAME;

        Cursor cursor = db.rawQuery(GET_DATA_QUERY,null);

        if(cursor.moveToFirst()){
            do{
                Booking booking = new Booking();

                booking.setId(cursor.getInt(0));
                booking.setTicketClass(cursor.getString(1));
                booking.setFullName(cursor.getString(2));
                booking.setDate(cursor.getString(3));
                booking.setMobileNo(cursor.getString(4));
                booking.setShowTime(cursor.getString(5));
                booking.setCenter(cursor.getString(6));
                booking.setTicketCount(cursor.getInt(7));

                bookings.add(booking);
            }while (cursor.moveToNext());
        }
        return bookings;
    }

    public int updateBooking(Booking booking){

        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COL_2,booking.getTicketClass());
        values.put(COL_3,booking.getFullName());
        values.put(COL_4,booking.getDate());
        values.put(COL_5,booking.getMobileNo());
        values.put(COL_6,booking.getShowTime());
        values.put(COL_7,booking.getCenter());
        values.put(COL_8,booking.getTicketCount());

        int status = db.update(
                TABLE_NAME,
                values,
                COL_1 + " = ?",
                new String[]{String.valueOf(booking.getId())}
        );
        db.close();
        return status;
    }

    public void deleteBooking(int id){

        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME,COL_1 + " =?",new String[]{String.valueOf(id)});
        db.close();
    }

    public Booking getSingleBooking(int id){
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.query(TABLE_NAME,
                new String[]{COL_1,COL_2,COL_3,COL_4,COL_5,COL_6,COL_7,COL_8},
                COL_1 + "= ?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null);

        Booking booking;

        if(cursor != null){
            cursor.moveToFirst();

            booking = new Booking(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getInt(7)
            );
            return booking;
        }
        return null;
    }

}