package com.example.mad_2nd_year_2nd_semester;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends ArrayAdapter<user> {

    List<user> userObj;
    private Context context;
    private int resourse;

    UserAdapter(Context context,int resourse,List<user>userObj) {
        super(context,resourse,userObj);
        this.context = context;
        this.resourse = resourse;
        this.userObj = userObj;
    }

    public View getView(int position, @Nullable View convertView,@Nullable ViewGroup parent){

        LayoutInflater inflater = LayoutInflater.from(context);
        View row =  inflater.inflate(resourse,parent,false);

        TextView name = row.findViewById(R.id.user_name);
        TextView email = row.findViewById(R.id.user_email);
        TextView birthday = row.findViewById(R.id.user_birthday);
        TextView phone = row.findViewById(R.id.user_phone);
        TextView password = row.findViewById(R.id.user_password);


        user userobj2 = userObj.get(position);
        name.setText("Full Name : " + userobj2.getName());
        email.setText("Email : " + userobj2.getEmail());
        birthday.setText("Birthday : " + userobj2.getBirthday());
        phone.setText("Mobile Number : " + userobj2.getPhoneNumber());
        password.setText("Password: " + userobj2.getPassword());


        return row;
    }
}
