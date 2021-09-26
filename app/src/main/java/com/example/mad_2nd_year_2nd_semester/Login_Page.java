package com.example.mad_2nd_year_2nd_semester;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login_Page extends AppCompatActivity {

   Button signinbutton;
   EditText signinusername,signinpassword;
   Context context;
   DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        context = this;
        db = new DatabaseHelper(context);

        signinbutton =findViewById(R.id.signinbtn);
        signinusername=findViewById(R.id.signinusername);
        signinpassword=findViewById(R.id.signinpassword);


     signinbutton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        String username = signinusername.getText().toString();
        String password = signinpassword.getText().toString();

        String adminUser = "admin";
        String adminPass = "admin";

        if(username.equals(adminUser) && password.equals(adminPass)){

            Intent intent = new Intent(Login_Page.this,Adminpanel.class);
            Toast.makeText(context,"Login Successful",Toast.LENGTH_LONG).show();
            startActivity(intent);
        }
        else{
            Toast.makeText(context,"Invalid username or password",Toast.LENGTH_LONG).show();
        }

    }
   });


     signinbutton.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

             String username = signinusername.getText().toString();
             String password = signinpassword.getText().toString();

             boolean isTrue = db.checkUser(username,password);

             if(isTrue == true){

                 Intent intent = new Intent(Login_Page.this,WelcomeUserPage.class);
                 Toast.makeText(context,"Login Successful",Toast.LENGTH_LONG).show();
                 startActivity(intent);

             }
             else{
                 Toast.makeText(context,"Invalid username or password",Toast.LENGTH_LONG).show();
             }

         }
     });

    }
}