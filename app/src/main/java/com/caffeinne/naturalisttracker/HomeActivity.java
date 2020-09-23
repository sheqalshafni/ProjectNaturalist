package com.caffeinne.naturalisttracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.caffeinne.naturalisttracker.HabitatsActivity.FarmlandHabitatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id._habitatsListView)
    ListView _habitatsListView;

    String[] Habitats = {"Farmland Habitats", "Desert Habitats", "Wetland Habitats",
            "Mountain & Grassland Habitats", "Forest & River Habitats", "Legendary Animals: Dark",
            "Legendary Animals: Light", "Legendary Animals: Red & Blond", "Legendary Animals: Patterned"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);


        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, Habitats);

        _habitatsListView.setAdapter(arrayAdapter);

        _habitatsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    Intent _farmlandHabitatActivity = new Intent(HomeActivity.this, FarmlandHabitatActivity.class);
                    startActivity(_farmlandHabitatActivity);
                } else if (position == 1) {
                    Toast.makeText(HomeActivity.this, Habitats[position], Toast.LENGTH_SHORT).show();
                } else if (position == 2) {
                    Toast.makeText(HomeActivity.this, Habitats[position], Toast.LENGTH_SHORT).show();
                } else if (position == 3) {
                    Toast.makeText(HomeActivity.this, Habitats[position], Toast.LENGTH_SHORT).show();
                } else if (position == 4) {
                    Toast.makeText(HomeActivity.this, Habitats[position], Toast.LENGTH_SHORT).show();
                } else if (position == 5) {
                    Toast.makeText(HomeActivity.this, Habitats[position], Toast.LENGTH_SHORT).show();
                } else if (position == 6) {
                    Toast.makeText(HomeActivity.this, Habitats[position], Toast.LENGTH_SHORT).show();
                } else if (position == 7) {
                    Toast.makeText(HomeActivity.this, Habitats[position], Toast.LENGTH_SHORT).show();
                } else if (position == 8) {
                    Toast.makeText(HomeActivity.this, Habitats[position], Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}