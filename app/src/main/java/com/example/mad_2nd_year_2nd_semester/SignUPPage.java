package com.example.mad_2nd_year_2nd_semester;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUPPage extends AppCompatActivity {

    Button cancelbutton,signupbutton;
    EditText name,email,birthday,phone,Password,ConfirmPassword;
    user use;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_uppage);


        Context context = this;

        db = new DatabaseHelper(context);

        cancelbutton=findViewById(R.id.cancle);
        signupbutton=findViewById(R.id.signup);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        birthday=findViewById(R.id.birthday);
        phone=findViewById(R.id.phone);
        Password=findViewById(R.id.Password);
        ConfirmPassword=findViewById(R.id.ConfirmPassword);


        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                String name1 = name.getText().toString();
                String email1 = email.getText().toString();
                String bday = birthday.getText().toString();
                String mobile = phone.getText().toString();
                String pass = Password.getText().toString();



                    use = new user(name1, email1, bday, mobile, pass);
                    boolean isInserted = db.InsertData(use);

                    if (isInserted == true) {
                        Toast.makeText(SignUPPage.this, "Registration successfullly", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(SignUPPage.this, "Failed", Toast.LENGTH_LONG).show();
                    }
            }


        });






    }
}