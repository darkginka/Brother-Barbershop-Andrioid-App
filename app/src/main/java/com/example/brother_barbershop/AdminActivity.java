package com.example.brother_barbershop;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class AdminActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        Button login = findViewById(R.id.loginbtn);
        Button home = findViewById(R.id.homebtn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText un = findViewById(R.id.username);
                EditText pw = findViewById(R.id.password);
                String s1 = un.getText().toString();
                String s2 = pw.getText().toString();

                if(s1.equals("admin")&& s2.equals("admin")) {
                    Toast.makeText(AdminActivity.this,"Correct Password ", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(AdminActivity.this,OrdersActivity.class));
                    un.setText("");
                    pw.setText("");
                }
                else {
                    un.setText("");
                    pw.setText("");
                    Toast.makeText(AdminActivity.this,"Wrong Password ", Toast.LENGTH_SHORT).show();
                }

            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int2 = new Intent(AdminActivity.this,MainActivity.class);
                startActivity(int2);
            }
        });




    }
}
