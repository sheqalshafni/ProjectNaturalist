package com.caffeinne.naturalisttracker.HabitatsActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.caffeinne.naturalisttracker.Adapter.AnimalAdapter;
import com.caffeinne.naturalisttracker.Class.AnimalItem;
import com.caffeinne.naturalisttracker.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FarmlandHabitatActivity extends AppCompatActivity {

    @BindView(R.id._btnBack)
    ImageView _btnBack;
    @BindView(R.id._btnSellCollection)
    Button _btnSellCollection;
    @BindView(R.id._farmlandRecyclerView)
    RecyclerView animalRecyclerView;
    private RecyclerView.Adapter animalRecyclerViewAdapter;
    private RecyclerView.LayoutManager animalRecyclerViewLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmland_habitat);

        ButterKnife.bind(this);
        _btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        _allFarmlandAnimals();

        _btnSellCollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });

    }

    public void _allFarmlandAnimals () {

        ArrayList<AnimalItem> animalItemArrayList = new ArrayList<>();
        animalItemArrayList.add(new AnimalItem("Florida Cracker Cow", "$5.00", "Unstamped", "0"));
        animalItemArrayList.add(new AnimalItem("Angus Bull", "$5.00", "Unstamped", "0"));
        animalItemArrayList.add(new AnimalItem("Devon Bull", "$5.00", "Unstamped", "0"));
        animalItemArrayList.add(new AnimalItem("Hereford Bull", "$5.00", "Unstamped", "0"));
        animalItemArrayList.add(new AnimalItem("Angus Ox", "$5.00", "Unstamped", "0"));
        animalItemArrayList.add(new AnimalItem("Devon Ox", "$5.00", "Unstamped", "0"));
        animalItemArrayList.add(new AnimalItem("Old Spot Pig", "$5.00", "Unstamped", "0"));
        animalItemArrayList.add(new AnimalItem("Berkshire Pig", "$5.00", "Unstamped", "0"));
        animalItemArrayList.add(new AnimalItem("Big China Pig", "$5.00", "Unstamped", "0"));
        animalItemArrayList.add(new AnimalItem("Merino Sheep", "$5.00", "Unstamped", "0"));
        animalItemArrayList.add(new AnimalItem("Alpine Goat", "$5.00", "Unstamped", "0"));



        animalRecyclerViewLayoutManager = new LinearLayoutManager(this);
        animalRecyclerViewAdapter = new AnimalAdapter(animalItemArrayList);
        animalRecyclerView.setHasFixedSize(true);
        animalRecyclerView.setLayoutManager(animalRecyclerViewLayoutManager);
        animalRecyclerView.setAdapter(animalRecyclerViewAdapter);

    }
}