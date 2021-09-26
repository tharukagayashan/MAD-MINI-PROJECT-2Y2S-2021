package com.example.mad_2nd_year_2nd_semester;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Visapage extends AppCompatActivity {

    TextView cardholder,cardnumber,expiremonth,expireyear,cvv;
    Button payment;
    Payment pay;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visapage);

        db = new DatabaseHelper(this);

        cardholder = findViewById(R.id.vcardholder);
        cardnumber = findViewById(R.id.vcardnumber);
        expiremonth = findViewById(R.id.expmonth);
        expireyear = findViewById(R.id.vexpyear);
        cvv = findViewById(R.id.vcvv);
        payment = findViewById(R.id.payment);


        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                String holder = cardholder.getText().toString();
                String number = cardnumber.getText().toString();
                String month = expiremonth.getText().toString();
                String year = expireyear.getText().toString();
                //String cvvnum = cvv.getText().toString();

                String exp = month + "/" + year;

                pay = new Payment(holder,number,exp);
                boolean isInserted = db.InsertData(pay);

                if (isInserted ==true){
                    Toast.makeText(Visapage.this,"Card added successfully",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(Visapage.this,"Failed",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}