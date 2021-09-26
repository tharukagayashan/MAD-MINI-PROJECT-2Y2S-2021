package com.example.mad_2nd_year_2nd_semester;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class UpdateBookingPage extends AppCompatActivity {

    TextView name, date, mobileno, ticketcount,Class, showtime, center;
    Button update;
    DatabaseHelper db;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_booking_page);

        context = this;
        db = new DatabaseHelper(context);

        name = findViewById(R.id.fullname);
        date = findViewById(R.id.date);
        mobileno = findViewById(R.id.mobile);
        ticketcount = findViewById(R.id.ticketcount);
        Class = findViewById(R.id.ticketclass);
        showtime = findViewById(R.id.showtime);
        center = findViewById(R.id.center);
        update = findViewById(R.id.bookingbtn);

        final String id = getIntent().getStringExtra("id");
        Booking booking = db.getSingleBooking(Integer.parseInt(id));

        String tcount = String.valueOf(booking.getTicketCount());

        name.setText(booking.getFullName());
        date.setText(booking.getDate());
        mobileno.setText(booking.getMobileNo());
        ticketcount.setText(tcount);
        Class.setText(booking.getTicketClass());
        showtime.setText(booking.getShowTime());
        center.setText(booking.getCenter());

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nameData = name.getText().toString();
                String dateData = date.getText().toString();
                String mobileNoData = mobileno.getText().toString();
                String ticketcountData = ticketcount.getText().toString();
                String classData = Class.getText().toString();
                String showtimeData = showtime.getText().toString();
                String centerData = center.getText().toString();

                int tcountData = Integer.parseInt(ticketcountData);

                Booking booking = new Booking(Integer.parseInt(id),classData,nameData,dateData,mobileNoData,showtimeData,centerData,tcountData);
                int state = db.updateBooking(booking);
                System.out.println(state);
                startActivity(new Intent(context,ViewAllBooking.class));

            }
        });

    }
}