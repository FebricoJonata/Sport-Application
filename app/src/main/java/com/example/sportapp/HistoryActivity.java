package com.example.sportapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sportapp.adapter.TicketAdapter;
import com.example.sportapp.database.TicketDatabaseHelper;
import com.example.sportapp.database.modal.Ticket;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);



        RecyclerView history_RV = findViewById(R.id.history_RV);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        ArrayList<Ticket> ticketList= new ArrayList<>();
        TicketAdapter adapter = new TicketAdapter(this, ticketList);

        TicketDatabaseHelper DB = new TicketDatabaseHelper(this);

//        ticketList.addAll(DB.getAllTicket());
        ticketList = (ArrayList<Ticket>) DB.getAllData();


        adapter.setTicketList(ticketList);
        history_RV.setAdapter(adapter);
        history_RV.setLayoutManager(new LinearLayoutManager(HistoryActivity.this));

        bottomNav.setSelectedItemId(R.id.history);
        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.article:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.ticket:
                        startActivity(new Intent(getApplicationContext(), TicketActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.history:
                        return true;
                }
                return false;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.top_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.deleteAll){
            confirmDialog();
        }
        return super.onOptionsItemSelected(item);
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete All?");
        builder.setMessage("Are you sure you want to delete all Data?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                TicketDatabaseHelper DB = new TicketDatabaseHelper(HistoryActivity.this);
                DB.deleteAllData();
                //Refresh Activity
                Intent intent = new Intent(HistoryActivity.this, HistoryActivity.class);
                startActivity(intent);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }


}