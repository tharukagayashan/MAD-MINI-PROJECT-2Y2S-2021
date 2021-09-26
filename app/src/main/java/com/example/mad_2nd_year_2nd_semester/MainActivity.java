package com.example.mad_2nd_year_2nd_semester;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button viewAll,insert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

               viewAll = findViewById(R.id.viewAll);
               insert = findViewById(R.id.insert);

               viewAll.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Intent intent = new Intent(MainActivity.this,ViewAllBooking.class);
                       startActivity(intent);
                   }
               });

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TicketBookingPage.class);
                startActivity(intent);
            }
        });

    }
}