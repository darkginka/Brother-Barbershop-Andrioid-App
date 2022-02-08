package com.example.brother_barbershop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {
MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.music);
        mediaPlayer.start();

        Button b1 = findViewById(R.id.btn1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AppointmentActivity.class);
                startActivity(intent);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Intent int1 = new Intent(this, ServicesActivity.class);
                startActivity(int1);
                break;
            case R.id.item2:
                Intent int2 = new Intent(this, BarbersActivity.class);
                startActivity(int2);
                break;
            case R.id.item3:
                Intent int3 = new Intent(this, AboutActivity.class);
                startActivity(int3);
                break;
            case R.id.item4:
                Intent int4 = new Intent(this, AdminActivity.class);
                startActivity(int4);
                break;
            case R.id.item5:
                Intent int5 = new Intent(this, ContactActivity.class);
                startActivity(int5);
                break;
            case R.id.end:
                break;
        }
        return super.onOptionsItemSelected(item);

    }

}
