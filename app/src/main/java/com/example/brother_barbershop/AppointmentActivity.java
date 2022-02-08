package com.example.brother_barbershop;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class AppointmentActivity extends AppCompatActivity {
    private static final String TAG = "AppintmentActivity";

    private DatabaseHelper mDatabaseHelper;
    private Button book_btn,btnGet;
    private EditText names,emails,phones;
    CalendarView calendarView;
    TextView dates,times;
    TimePicker picker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);

        book_btn = findViewById(R.id.bookbtn);
        names = findViewById(R.id.txt_name);
        emails = findViewById(R.id.txt_email);
        phones = findViewById(R.id.txt_phone);
        times = findViewById(R.id.txt_time);
        calendarView = findViewById(R.id.calendarView);
        dates = findViewById(R.id.txt_date);

        mDatabaseHelper = new DatabaseHelper(this);


   //time coding...
        picker=findViewById(R.id.timePicker1);
        picker.setIs24HourView(true);

        btnGet=findViewById(R.id.button1);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hour, minute;
                String am_pm;
                if (Build.VERSION.SDK_INT >= 23 ){
                    hour = picker.getHour();
                    minute = picker.getMinute();
                }
                else{
                    hour = picker.getCurrentHour();
                    minute = picker.getCurrentMinute();
                }
                if(hour > 12) {
                    am_pm = "PM";
                    hour = hour - 12;
                }
                else
                {
                    am_pm="AM";
                }
                String c = hour +":"+ minute+" "+am_pm;
                times.setText(c);
            }
        });



//Database entry..
        book_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String newEntry1 = names.getText().toString();
                String newEntry2 = emails.getText().toString();
                String newEntry3 = phones.getText().toString();
                String newEntry4 = dates.getText().toString();
                String newEntry5 = times.getText().toString();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                if ((names.length() != 0)&&(emails.getText().toString().trim().matches(emailPattern))&&(phones.length() == 10)&&(dates.length() != 0)&&(times.length() != 0)) {
                    AddData(newEntry1,newEntry2,newEntry3,newEntry4,newEntry5);
                    names.setText("");
                    emails.setText("");
                    phones.setText("");
                    dates.setText("");
                    times.setText("");
                    startActivity(new Intent(AppointmentActivity.this,MainActivity.class));
                }
                else {
                    toastMessage("Something wrong");
                    toastMessage("Please check entered value");
                    }
            }
        });



    }

//Outside methodes...
    public void AddData(String newEntry1,String newEntry2,String newEntry3,String newEntry4,String newEntry5) {
        boolean insertData = mDatabaseHelper.addData(newEntry1,newEntry2,newEntry3,newEntry4,newEntry5);
        if (insertData) {
            toastMessage("Data Successfully Inserted!");
        }
        else {
            toastMessage("Something went wrong");
        }
    }

    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }

//Date Picker
    public void datevalid(View view) {
        dates = findViewById(R.id.txt_date);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                dates.setText("");
                int d = dayOfMonth;
                int m = month;
                int y = year;
                String c = d + "-" + m + "-" + y;
                dates.append(c);
            }
        });

    }

    /*
public void validation(String newEntry2,String newEntry3){
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    if(emails.getText().toString().trim().matches(emailPattern)){
        toastMessage("Invalid email address!");
    }
    else if (phones.length() != 0)
    {
        toastMessage("You must put 10 digit phone number!");
    }
    else
    {
        toastMessage("You must put Right in the text field!");
    }
}
*/

}


