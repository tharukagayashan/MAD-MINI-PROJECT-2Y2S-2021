package com.example.mad_2nd_year_2nd_semester;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class EditUserProfilePage extends AppCompatActivity {

    Button cancelbutton,signupbutton;
    EditText name,email,birthday,phone,Password,ConfirmPassword;
    DatabaseHelper db;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user_profile_page);

        context = this;

        db = new DatabaseHelper(context);

        String id = getIntent().getStringExtra("id");
        user User = db.getSingleUser(Integer.parseInt(id));

        cancelbutton=findViewById(R.id.cancle);
        signupbutton=findViewById(R.id.signup);
        name=findViewById(R.id.ename);
        email=findViewById(R.id.eemail);
        birthday=findViewById(R.id.ebirthday);
        phone=findViewById(R.id.ephone);
        Password=findViewById(R.id.ePassword);

        name.setText(User.getName());
        email.setText(User.getEmail());
        birthday.setText(User.getBirthday());
        phone.setText(User.getPhoneNumber());
        Password.setText(User.getPassword());

    }
}