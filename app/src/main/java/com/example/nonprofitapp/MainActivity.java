package com.example.nonprofitapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

/*    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }*/

    Recycleadapter adapt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Getdataservice service = RetrofitInstance.getRetrofitInstance().create(Getdataservice.class);
        System.out.println("Service : " + service);



        //Call<List<Pokemon>> call = service.getPokemons();
       /* call.enqueue(new Callback<List<Pokemon>>() {
            @Override
            public void onResponse(Call<List<Pokemon>> call, Response<List<Pokemon>> response) {

                System.out.println(response.body());
                generateData(response.body());

            }

            @Override
            public void onFailure(Call<List<Pokemon>> call, Throwable t) {

                Toast.makeText(getApplicationContext(),"Something went wrong!!!",Toast.LENGTH_SHORT).show();

            }
        });*/
        // starting from Json object

        Call<Example> call = service.getExampleObj();
        System.out.println("Call : " + call);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                ArrayList<Organization> pokarray = new ArrayList<>();

                Example pokojo = response.body();

                try{
                    pokarray = new ArrayList<>(pokojo.getOrganizations());
                    generateData(pokarray);

                }catch(NullPointerException e){
                    System.out.println(e.getMessage());
                }

            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

                Toast.makeText(getApplicationContext(),"Something went wrong!!!",Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void generateData(ArrayList<Organization> pokes/*List<Pokemon>poklist*/){


        //ArrayList<Pokemon> pokes = (ArrayList<Pokemon>) poklist;

        adapt = new Recycleadapter(pokes,getApplicationContext());

        @SuppressLint("WrongConstant") LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);

        RecyclerView recyclerView = findViewById(R.id.recycle_poke);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapt);

    }
}
