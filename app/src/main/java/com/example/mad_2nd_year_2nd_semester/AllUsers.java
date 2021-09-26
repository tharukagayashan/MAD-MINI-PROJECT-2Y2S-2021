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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AllUsers extends AppCompatActivity {

    private List<user> users;
    private ListView listView;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_users);

        context = this;

        DatabaseHelper db = new DatabaseHelper(this);
        listView = findViewById(R.id.list);

        users = new ArrayList<>();

        users = db.getAllUser();

        UserAdapter userAdapter = new UserAdapter(this,R.layout.singaluser_admin,users);
        listView.setAdapter(userAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                user User = users.get(position);

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Alert !!!");
                builder.setMessage("Do you want to Edit or Delete this comment ?");
               // builder.setMessage(User.getName() + "\n" + User.getEmail());

                builder.setNeutralButton("EDIT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(context,EditUserProfilePage.class);
                        intent.putExtra("id",String.valueOf(User.getId()));
                        startActivity(intent);
                    }
                });

                builder.setNegativeButton("DELETE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {



                        db.deleteUser(User.getId());

                        Intent intent = new Intent(AllUsers.this,AllUsers.class);
                        startActivity(intent);
                    }
                });

                builder.show();

            }
        });
        
    }
}