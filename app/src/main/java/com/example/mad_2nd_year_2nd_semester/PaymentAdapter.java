package com.example.mad_2nd_year_2nd_semester;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.List;

public class PaymentAdapter extends ArrayAdapter<Payment> {

    List<Payment> paymentObj;
    private Context context;
    private int resourse;


    PaymentAdapter(Context context, int resourse, List<Payment> paymentObj) {
        super(context,resourse,paymentObj);
        this.context = context;
        this.resourse = resourse;
        this.paymentObj = paymentObj;
    }

    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent){

        LayoutInflater inflater = LayoutInflater.from(context);
        View row =  inflater.inflate(resourse,parent,false);

        TextView holder = row.findViewById(R.id.vcardholder);
        TextView number = row.findViewById(R.id.vcardnumber);
        TextView expDate = row.findViewById(R.id.vexpdate);


        Payment paymentobj2 = paymentObj.get(position);

        holder.setText("Card Holder : " + paymentobj2.getCard_holder());
        number.setText("Card Number : " + paymentobj2.getCard_number());
        expDate.setText("Expire Date : " + paymentobj2.getExpire_date());

        return row;
    }

}
