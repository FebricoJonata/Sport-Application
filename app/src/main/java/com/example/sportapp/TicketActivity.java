package com.example.sportapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.sportapp.adapter.InformationAdapter;
import com.example.sportapp.database.modal.Information;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class TicketActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);

        RecyclerView information_RV = findViewById(R.id.information_RV);

        //Add item dengan menggunakan Array List
        List<Information> informationList = new ArrayList<>();
        informationList.add(new Information(R.drawable.vip, "VIP Ticket | Rp. 450.000", "The Match will be held on 20-05-2023"));
        informationList.add(new Information(R.drawable.platinum_ticket, "Platinum Ticket | Rp. 225.000", "The Match will be held on 20-05-2023"));
        informationList.add(new Information(R.drawable.golden_ticket, "Golden Ticket | Rp. 150.000", "The Match will be held on 20-05-2023"));
        informationList.add(new Information(R.drawable.ticket_regular, "Regular Ticket | Rp. 100.000", "The Match will be held on 20-05-2023"));
        informationList.add(new Information(R.drawable.vip, "VIP Ticket | Rp. 450.000", "The Match will be held on 13-07-2023"));
        informationList.add(new Information(R.drawable.platinum_ticket, "Platinum Ticket | Rp. 300.000", "The Match will be held on 13-07-2023"));
        informationList.add(new Information(R.drawable.golden_ticket, "Golden Ticket | Rp. 225.000", "The Match will be held on 13-07-2023"));
        informationList.add(new Information(R.drawable.ticket_regular, "Regular Ticket | Rp. 125.000", "The Match will be held on 13-07-2023"));
        informationList.add(new Information(R.drawable.vip, "VIP Ticket | Rp. 500.000", "The Match will be held on 25-12-2023"));
        informationList.add(new Information(R.drawable.platinum_ticket, "Platinum Ticket | Rp. 300.000", "The Match will be held on 25-12-2023"));
        informationList.add(new Information(R.drawable.golden_ticket, "Golden Ticket | Rp. 275.000", "The Match will be held on 25-12-2023"));
        informationList.add(new Information(R.drawable.ticket_regular, "Regular Ticket | Rp. 175.000", "The Match will be held on 25-12-2023"));


        //panggil Adapter
        InformationAdapter adapter = new InformationAdapter(this, informationList);
        adapter.setInformationList(informationList);

        information_RV.setAdapter(adapter);
        information_RV.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton ticket_btn = findViewById(R.id.ticket_btn);
        ticket_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TicketActivity.this, BuyTicketActivity.class);
                startActivity(intent);
            }
        });

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setSelectedItemId(R.id.ticket);
        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.article:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.ticket:
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