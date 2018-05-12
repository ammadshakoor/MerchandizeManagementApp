package com.example.iamma.merchandizemanagementapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class LaptopActivity extends AppCompatActivity {

    DatabaseHelper mydb;
    ListView lv;

    final String[] from = new String[] { DatabaseHelper.LAPTOP_COL3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laptop);

        mydb = new DatabaseHelper(this);

        ArrayList<HashMap<String,String>> regList = mydb.GetLaptop();
        lv = (ListView) findViewById(R.id.listViewLaptop);
        ListAdapter adapter = new SimpleAdapter(LaptopActivity.this, regList, R.layout.layout ,from, new int[]{R.id.textViewLapName});
        lv.setAdapter(adapter);
    }
}
