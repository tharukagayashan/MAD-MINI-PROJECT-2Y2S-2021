package com.example.mad_2nd_year_2nd_semester;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class TicketBookingPage extends AppCompatActivity {

    TextView name, date, mobileno, ticketcount;
    Spinner Class, showtime, center;
    Button placeTicketbtn;
    DatabaseHelper db;
    Booking booking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_booking_page);

        Context context = this;

        db = new DatabaseHelper(context);

        name = findViewById(R.id.fullname);
        date = findViewById(R.id.date);
        mobileno = findViewById(R.id.mobile);
        ticketcount = findViewById(R.id.ticketcount);
        Class = findViewById(R.id.ticketclass);
        showtime = findViewById(R.id.showtime);
        center = findViewById(R.id.center);
        placeTicketbtn = findViewById(R.id.bookingbtn);

        placeTicketbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                String Bname = name.getText().toString();
                String Bdate = date.getText().toString();
                String Bmobileno = mobileno.getText().toString();
                int BticketCount = Integer.parseInt(ticketcount.getText().toString());
                String BClass = Class.getSelectedItem().toString();
                String BShowTime = showtime.getSelectedItem().toString();
                String Bcenter = center.getSelectedItem().toString();

                booking = new Booking(BClass, Bname, Bdate, Bmobileno, BShowTime, Bcenter, BticketCount);
                boolean isInserted = db.InsertData(booking);

                if(isInserted == true){
                    Toast.makeText(context,"Inserted successfully",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(context,"Insert failed",Toast.LENGTH_LONG).show();
                }

            }
        });

    }

}