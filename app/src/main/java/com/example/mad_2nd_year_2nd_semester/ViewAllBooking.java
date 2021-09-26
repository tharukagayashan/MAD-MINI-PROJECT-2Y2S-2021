package com.example.mad_2nd_year_2nd_semester;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ViewAllBooking extends AppCompatActivity {


    private List<Booking> bookings;
    private ListView listView;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_booking);

        context = this;

        DatabaseHelper db = new DatabaseHelper(this);
        listView = findViewById(R.id.list);

        bookings = new ArrayList<>();

        bookings = db.getAllData();

        BookingAdapter bookingAdapter = new BookingAdapter(this,R.layout.activity_view_booking_page,bookings);
        listView.setAdapter(bookingAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Booking booking = bookings.get(position);

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(booking.getFullName());
                builder.setMessage(booking.getCenter() + " " + booking.getShowTime());
                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        db.deleteBooking(booking.getId());
                        startActivity(new Intent(context,ViewAllBooking.class));
                    }
                });
                builder.setNeutralButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(context,UpdateBookingPage.class);
                        intent.putExtra("id",String.valueOf(booking.getId()));
                        startActivity(intent);
                    }
                });
                builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(context,ViewAllBooking.class));
                    }
                });

                builder.show();
            }

        });

    }



}