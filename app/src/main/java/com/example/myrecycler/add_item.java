package com.example.myrecycler;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import static java.lang.Integer.getInteger;

public class add_item extends AppCompatActivity {
    EditText name_et ,number_et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        name_et = findViewById(R.id.et_name);
        number_et = findViewById(R.id.et_number);



        FloatingActionButton add = findViewById(R.id.add_button);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Items info = createContact(name_et.getText().toString(),number_et.getText().toString());
                    if (info != null) {
                        Intent intent = new Intent();
                        intent.putExtra("info", info);
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                }


                }catch (Exception e){
                    Toast.makeText(add_item.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private Items createContact(String name, String number) {
        boolean invalid = false;
        if (name == null || name.isEmpty()) {
            invalid = true;
            name_et.setError("لا يمكن إضافة مستحدم بدون اسم");
        }
        if (number == null || number.isEmpty()) {
            invalid = true;
            number_et.setError("لا يمكن إضافة مستخدم بدون رقم ");
        }
        if (invalid) return null;
        else return new Items(name, number);
    }
    }
