package com.example.mad_2nd_year_2nd_semester;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class BookingAdapter extends ArrayAdapter<Booking> {

    private Context context;
    private int resourse;
    List<Booking> bookings;

    BookingAdapter(Context context, int resourse, List <Booking> bookings){
        super(context,resourse,bookings);
        this.context = context;
        this.resourse = resourse;
        this.bookings = bookings;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resourse,parent,false);

        TextView name = row.findViewById(R.id.name);
        TextView ticketClass = row.findViewById(R.id.ticketclass);
        TextView showTime = row.findViewById(R.id.showtime);
        TextView center = row.findViewById(R.id.center);
        TextView count = row.findViewById(R.id.count);
        TextView mobile = row.findViewById(R.id.mobile);
        TextView date = row.findViewById(R.id.date);

        Booking booking = bookings.get(position);
        name.setText("Full Name : " + booking.getFullName());
        ticketClass.setText("Ticket Class : " + booking.getTicketClass());
        showTime.setText("Show Time : " + booking.getShowTime());
        center.setText("Center : " + booking.getCenter());
        count.setText("Ticket Count : " + booking.getTicketCount());
        mobile.setText("Mobile : " + booking.getMobileNo());
        date.setText("Date : " + booking.getDate());

        return row;

    }
}