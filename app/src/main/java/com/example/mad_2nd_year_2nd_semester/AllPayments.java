package com.example.mad_2nd_year_2nd_semester;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class AllPayments extends AppCompatActivity {

    Context context;
    ListView listView;
    List <Payment> payments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_payments);


        context = this;

        DatabaseHelper db = new DatabaseHelper(this);
        listView = findViewById(R.id.list);

        payments = new ArrayList<>();

        payments = db.getAllPayment();

        PaymentAdapter paymentAdapter = new PaymentAdapter(this,R.layout.singlepayment_admin,payments);
        listView.setAdapter(paymentAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Payment payment = payments.get(position);

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Alert !!!");
                builder.setMessage("Do you want to Edit or Delete this comment ?");

                builder.setNeutralButton("EDIT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(context, EditCardDetailsPage.class);
                        intent.putExtra("id", String.valueOf(payment.getId()));
                        startActivity(intent);
                    }
                });

                builder.setNegativeButton("DELETE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        db.deleteUser(payment.getId());

                        Intent intent = new Intent(AllPayments.this, AllPayments.class);
                        startActivity(intent);
                    }
                });

                builder.show();

            }

        });
    }

}