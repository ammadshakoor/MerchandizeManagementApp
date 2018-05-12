package com.example.iamma.merchandizemanagementapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddLaptopActivity extends AppCompatActivity {

    EditText l_item,l_name,l_type,l_manufacture,l_model,l_webpage;
    Button btnSub;
    DatabaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_laptop);

        // connection open with database here!
        mydb = new DatabaseHelper(this);

        l_item = (EditText)findViewById(R.id.editTextItem);
        l_name = (EditText)findViewById(R.id.editTextName);
        l_type = (EditText)findViewById(R.id.editTextType);
        l_manufacture = (EditText)findViewById(R.id.editTextManufacture);
        l_model = (EditText)findViewById(R.id.editTextModel);
        l_webpage = (EditText)findViewById(R.id.editTextWebpage);

        btnSub = (Button)findViewById(R.id.btnSub);
        addLaptop();
    }
    public void addLaptop()
    {
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String lap_name = l_name.getText().toString();
                String lap_item_id = l_item.getText().toString();
                String lap_type = l_type.getText().toString();
                String lap_manufacture = l_manufacture.getText().toString();
                String lap_model = l_model.getText().toString();
                String lap_webpage = l_webpage.getText().toString();

                // check validation
                if( lap_name.isEmpty() )
                {
                    Toast.makeText(getBaseContext(), "Fill the user field", Toast.LENGTH_SHORT).show();
                }
                else {
                    boolean isInserted = mydb.InsertLaptop(lap_item_id,lap_name,lap_type,lap_manufacture,lap_model,lap_webpage);
                    // check if data inserted or not
                    if(isInserted == true)
                    {
                        Toast.makeText(getBaseContext(),"Laptop inserted successfully!", Toast.LENGTH_SHORT).show();
                        l_name.setText("");
                        l_item.setText("");
                        l_type.setText("");
                        l_manufacture.setText("");
                        l_model.setText("");
                        l_webpage.setText("");
                    }
                    else {
                        Toast.makeText(getBaseContext(), "failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
