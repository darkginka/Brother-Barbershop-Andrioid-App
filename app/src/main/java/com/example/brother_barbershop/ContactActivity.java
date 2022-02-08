package com.example.brother_barbershop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        Button b1 = findViewById(R.id.btn1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cl = "http://www.gmail.com";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(cl));
                startActivity(intent);
            }
        });

        Button b2 = findViewById(R.id.btn2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ml = "http://www.facebook.com";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(ml));
                startActivity(intent);
            }
        });
        Button b3 = findViewById(R.id.btn3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cl = "https://in.linkedin.com/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(cl));
                startActivity(intent);
            }
        });

        Button b4 = findViewById(R.id.btn4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ml = "https://in.pinterest.com/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(ml));
                startActivity(intent);
            }
        });
        Button b5 = findViewById(R.id.btn5);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cl = "https://twitter.com/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(cl));
                startActivity(intent);
            }
        });


    }
}
