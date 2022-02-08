package com.example.brother_barbershop;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.database.Cursor;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;


public class OrdersActivity extends AppCompatActivity {

    private static final String TAG = "OrdersActivity";
    DatabaseHelper mDatabaseHelper;
    private ListView mListView;
    public Button btnDelete;
    public EditText editTextId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
                mListView = findViewById(R.id.listView);
                mDatabaseHelper = new DatabaseHelper(this);
                btnDelete = findViewById(R.id.del_btn);
                editTextId = findViewById(R.id.editTId);
                populateListView();
                DeleteData();
            }


    private void populateListView() {
                Log.d(TAG, "populateListView: Displaying data in the ListView.");
                Cursor data = mDatabaseHelper.getData();
                ArrayList<String> listData = new ArrayList<>();
                while(data.moveToNext()){
                    listData.add(data.getString(0));
                    listData.add(data.getString(1));
                    listData.add(data.getString(2));
                    listData.add(data.getString(3));
                    listData.add(data.getString(4));
                    listData.add(data.getString(5));
                }
                ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
                mListView.setAdapter(adapter);
            }

    public void DeleteData() {
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = mDatabaseHelper.deleteData(editTextId.getText().toString());
                        if(deletedRows > 0)
                            Toast.makeText(OrdersActivity.this,"Data Deleted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(OrdersActivity.this,"Data not Deleted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
        }

