package com.example.sportapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.sportapp.adapter.InformationAdapter;
import com.example.sportapp.database.modal.Information;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView information_RV = findViewById(R.id.information_RV);

        //Add item dengan menggunakan Array List
        List<Information> informationList = new ArrayList<>();
        informationList.add(new Information(R.drawable.anthony_sinisuka_ginting, "New Winner Has Born! Incredible Ginting", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Sapiente, neque."));
        informationList.add(new Information(R.drawable.tai_tzu_ying, "5 Fact About Tai Tzu Ying you should know!", "Lorem sit amet consectetur adipisicing elit ipsum dolor sit"));
        informationList.add(new Information(R.drawable.yuta_watabane, "Yuta Watanabe high school story that will make you Amaze", "Lorem ipsum adipisicing elit. Sapiente, neque."));
        informationList.add(new Information(R.drawable.christie, "Intense training from Jonathan Christie", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Nemo dolorem doloremque culpa!"));
        informationList.add(new Information(R.drawable.momota, "The art of playing badminton by Momota", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Nemo dolorem doloremque culpa!"));
        informationList.add(new Information(R.drawable.badminton, "The Champion of Indonesia Open 2025", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Nemo dolorem doloremque culpa!"));
        informationList.add(new Information(R.drawable.badminton, "Next Tournament will be fierce because...", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Nemo dolorem doloremque culpa!"));
        informationList.add(new Information(R.drawable.yuta_watabane, "Who is the next partner of Yuta watabane for China open", "Lorem ipsum adipisicing elit. Sapiente, neque."));
        informationList.add(new Information(R.drawable.tai_tzu_ying, "Tai Tzu Ying Will playing double next year?!", "Lorem sit amet consectetur adipisicing elit ipsum dolor sit"));
        informationList.add(new Information(R.drawable.momota, "Momota will take break for year because of injury", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Nemo dolorem doloremque culpa!"));

        //panggil Adapter
        InformationAdapter adapter = new InformationAdapter(this, informationList);
        adapter.setInformationList(informationList);

        information_RV.setAdapter(adapter);
        information_RV.setLayoutManager(new LinearLayoutManager(this));




        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setSelectedItemId(R.id.article);
        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.article:
                        return true;

                    case R.id.ticket:
                        startActivity(new Intent(getApplicationContext(), TicketActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.history:
                        startActivity(new Intent(getApplicationContext(), HistoryActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

    }
}