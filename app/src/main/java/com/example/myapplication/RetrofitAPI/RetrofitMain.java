package com.example.myapplication.RetrofitAPI;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitMain extends AppCompatActivity {

    RecyclerView recyclerView;
    List<DataModel> arrayList;
    DataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_main);
        recyclerView = findViewById(R.id.rv);
        arrayList = new ArrayList<>();


        getHeros();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

    }

    private void getHeros() {

        Call<List<DataModel>> call = RetrofitClient.getInstance().getMyApi().getHeros();
        call.enqueue(new Callback<List<DataModel>>() {
            @Override
            public void onResponse(Call<List<DataModel>> call, Response<List<DataModel>> response) {
                arrayList = response.body();



                //displaying the string array into listview
                recyclerView.setAdapter(new DataAdapter(arrayList, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<List<DataModel>> call, Throwable t) {

                Toast.makeText(RetrofitMain.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }


        });

    }


}
