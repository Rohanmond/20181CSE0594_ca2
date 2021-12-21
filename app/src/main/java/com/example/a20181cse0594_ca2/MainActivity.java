package com.example.a20181cse0594_ca2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText name,telNo,dateForDel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.editTextTextPersonName);
        telNo=findViewById(R.id.editTextTextPersonName2);
        dateForDel=findViewById(R.id.editTextTextPersonName3);
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sharedPreferences=getSharedPreferences("MySP",MODE_PRIVATE);
        String Name=sharedPreferences.getString("name","");
        String TelNo=sharedPreferences.getString("telNo","");
        name.setText(Name);
        telNo.setText(TelNo);

    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences sharedPreferences=getSharedPreferences("MySP",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("name",name.getText().toString());
        editor.putString("telNo",telNo.getText().toString());
        editor.apply();
    }
}