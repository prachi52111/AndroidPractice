package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ListViewExample extends AppCompatActivity {

    ListView listView;

    String[] arr = {"Apple", "banana", "Chikoo", "Dadam", "Egg", "Fruit"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_example);
        listView = findViewById(R.id.list);

        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr);

        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListViewExample.this, arr[i], Toast.LENGTH_SHORT).show();

            }
        });


//      listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//                String str = listView.getItemAtPosition(i).toString();
//                Toast.makeText(ListViewExample.this, str, Toast.LENGTH_SHORT).show();
//
//                return true;
//
//            }
//        });
    }
}