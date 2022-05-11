package com.example.myapplication.SharedPreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;

public class SharedPreferenceActivity extends AppCompatActivity {

   private EditText name,age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);
        name = findViewById(R.id.edit1);
        age=  findViewById(R.id.edit2);
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sharedPreferences = getSharedPreferences("myref",MODE_PRIVATE);
        String n = sharedPreferences.getString("name","");
        int a = sharedPreferences.getInt("age",0);
        name.setText(n);
        age.setText(String.valueOf(a));

    }

    @Override
    protected void onPause() {
            super.onPause();
            SharedPreferences sharedPreferences = getSharedPreferences("myref",MODE_PRIVATE);

            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("name",name.getText().toString());
            edit.putInt("age",Integer.parseInt(age.getText().toString()));
            edit.apply();
    }
}