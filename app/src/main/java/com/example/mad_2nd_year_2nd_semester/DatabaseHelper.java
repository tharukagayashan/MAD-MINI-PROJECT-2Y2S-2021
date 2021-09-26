package com.example.mad_2nd_year_2nd_semester;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObservable;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper  extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "MAD2021";
    private static final int VERSION = 1;

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    private static final String TABLE_NAME = "Payment";
    private static final String COL_1 = "id";
    private static final String COL_2 = "card_holder";
    private static final String COL_3 = "card_number";
    private static final String COL_4 = "expire_date";


    private static final  String TABLE1_NAME ="user";
    private static final String UCOL_1="id";
    private static final String UCOL_2="name";
    private static final String UCOL_3="email";
    private static final String UCOL_4="birthday";
    private static final String UCOL_5="phonenumber";
    private static final String UCOL_6="password";



    @Override
    public void onCreate(SQLiteDatabase db) {

        String TABLE_CREATE_QUERY = "CREATE TABLE " + TABLE_NAME + "(" +
                COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_2 + " TEXT," +
                COL_3 + " TEXT," +
                COL_4 + " TEXT);";

        db.execSQL(TABLE_CREATE_QUERY);


        String TABLE1_CREATE_QUERY = "CREATE TABLE "+ TABLE1_NAME+"("+
                UCOL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                UCOL_2 + " TEXT," +
                UCOL_3 + " TEXT,"+
                UCOL_4 + " TEXT,"+
                UCOL_5 + " TEXT,"+
                UCOL_6 + " TEXT);";

        db.execSQL(TABLE1_CREATE_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

        db.execSQL("DROP TABLE IF EXISTS " + TABLE1_NAME);
        onCreate(db);

    }

    public boolean InsertData(Payment payment){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues val = new ContentValues();

        val.put(COL_2,payment.getCard_holder());
        val.put(COL_3,payment.getCard_number());
        val.put(COL_4,payment.getExpire_date());

        long result = db.insert(TABLE_NAME,null,val);

        if(result == -1){
            return false;
        }
        else {
            return true;
        }
    }
    public boolean InsertData(user user){


        SQLiteDatabase db = getWritableDatabase();
        ContentValues val = new ContentValues();

        val.put(UCOL_2,user.getName());
        val.put(UCOL_3,user.getEmail());
        val.put(UCOL_4,user.getBirthday());
        val.put(UCOL_5,user.getPhoneNumber());
        val.put(UCOL_6,user.getPassword());


        long result = db.insert(TABLE1_NAME,null,val);
        if(result == -1){
            return false;

        }else{
            return true;
        }


    }

    public List<Payment> getAllPayment(){

        List<Payment> payment = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        String GET_QUERY = "SELECT * FROM " + TABLE_NAME;

        Cursor cursor = db.rawQuery(GET_QUERY,null);

        if(cursor.moveToFirst()){
            do{
                Payment paymentObj = new Payment();

                paymentObj.setId(cursor.getInt(0));
                paymentObj.setCard_holder(cursor.getString(1));
                paymentObj.setCard_number(cursor.getString(2));
                paymentObj.setExpire_date(cursor.getString(3));


                payment.add(paymentObj);

            }while (cursor.moveToNext());
        }
        return payment;
    }
    public List<user> getAllUser(){

        List<user> users = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        String GET_QUERY = "SELECT * FROM " + TABLE1_NAME;

        Cursor cursor = db.rawQuery(GET_QUERY,null);

        if(cursor.moveToFirst()){
            do{
                user userObj = new user();

                userObj.setId(cursor.getInt(0));
                userObj.setName(cursor.getString(1));
                userObj.setEmail(cursor.getString(2));
                userObj.setBirthday(cursor.getString(3));
                userObj.setPhone(cursor.getString(4));
                userObj.setPassword(cursor.getString(5));

                users.add(userObj);

            }while (cursor.moveToNext());
        }
        return users;
    }
    public void deleteUser(int id){

        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE1_NAME,UCOL_1 + " =?",new String[]{String.valueOf(id)});
        db.close();

    }


    public user getSingleUser(int id){

        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.query(TABLE1_NAME,
                new String[]{UCOL_1,UCOL_2,UCOL_3,UCOL_4,UCOL_5,UCOL_6},
                UCOL_1 + "= ?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null);

        user User;

        if(cursor != null){
            cursor.moveToFirst();

            User = new user(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5)
            );
            return User;
        }
        return null;

    }

    //Check User

    public boolean checkUser(String email,String password){

        String[] columns = {UCOL_1};

        SQLiteDatabase db = getReadableDatabase();

        String selection = UCOL_3 + " = ? " + "AND " + UCOL_6 +  " = ?";

        String [] selectionArgs = {email,password};

        Cursor cursor = db.query(TABLE1_NAME,columns,selection,selectionArgs,null,null,null);

        int count = cursor.getCount();

        if(count > 0){
            return true;
        }
        else {
            return false;
        }

    }

}