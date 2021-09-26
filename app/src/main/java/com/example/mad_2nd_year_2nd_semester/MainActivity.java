package com.example.mad_2nd_year_2nd_semester;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button,button2,button3,button4,button5,button6,button7,button8,button9,button10,button12,button13,button14;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button =findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);
        button3 =findViewById(R.id.btn3);
        button4 =findViewById(R.id.btn4);
        button5 =findViewById(R.id.btn5);
        button6 =findViewById(R.id.btn6);
        button7 =findViewById(R.id.btn7);
        button8 =findViewById(R.id.btn8);
        button9 =findViewById(R.id.btn9);
        button10 =findViewById(R.id.btn10);
        button12 =findViewById(R.id.btn12);
        button13 =findViewById(R.id.btn13);
        button14 =findViewById(R.id.btn14);


        button.setOnClickListener(new View.OnClickListener(){public void onClick(View v){

                Intent i=new Intent(MainActivity.this,WelcomePage.class);
                startActivity(i);

             }
        });

        button2.setOnClickListener(new View.OnClickListener(){public void onClick(View v){

            Intent i=new Intent(MainActivity.this,Login_Page.class);
            startActivity(i);



        }


        });


        button3.setOnClickListener(new View.OnClickListener(){public void onClick(View v){

            Intent i=new Intent(MainActivity.this,SignUPPage.class);
            startActivity(i);



        }


        });

        button4.setOnClickListener(new View.OnClickListener(){public void onClick(View v){

            Intent i=new Intent(MainActivity.this,AllUsers.class);
            startActivity(i);



        }


        });
        button5.setOnClickListener(new View.OnClickListener(){public void onClick(View v){

            Intent i=new Intent(MainActivity.this,Adminpanel.class);
            startActivity(i);



        }


        });


        button6.setOnClickListener(new View.OnClickListener(){public void onClick(View v){

            Intent i=new Intent(MainActivity.this,paymentmethodpage.class);
            startActivity(i);



        }


        });

        button7.setOnClickListener(new View.OnClickListener(){public void onClick(View v){

            Intent i=new Intent(MainActivity.this,MasterCardpage.class);
            startActivity(i);



        }


        });
        button8.setOnClickListener(new View.OnClickListener(){public void onClick(View v){

            Intent i=new Intent(MainActivity.this,Visapage.class);
            startActivity(i);



        }


        });
        button9.setOnClickListener(new View.OnClickListener(){public void onClick(View v){

            Intent i=new Intent(MainActivity.this,EditCardDetailsPage.class);
            startActivity(i);



        }


        });


        button10.setOnClickListener(new View.OnClickListener(){public void onClick(View v) {

            Intent i = new Intent(MainActivity.this, PaymentHistorypage.class);
            startActivity(i);


        }


        });

        button12.setOnClickListener(new View.OnClickListener(){public void onClick(View v){

            Intent i=new Intent(MainActivity.this,WelcomeUserPage.class);
            startActivity(i);



        }


        });
        button13.setOnClickListener(new View.OnClickListener(){public void onClick(View v){

            Intent i=new Intent(MainActivity.this,EditUserProfilePage.class);
            startActivity(i);



        }


        });
        button14.setOnClickListener(new View.OnClickListener(){public void onClick(View v){

            Intent i=new Intent(MainActivity.this,AllPayments.class);
            startActivity(i);



        }


        });
    }


}