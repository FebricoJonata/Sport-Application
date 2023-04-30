package com.example.sportapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sportapp.database.TicketDatabaseHelper;
import com.example.sportapp.database.modal.Ticket;

public class BuyTicketActivity extends AppCompatActivity {

    EditText name_input, category_input, date_input, quantity_input;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_ticket);

        init();

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TicketDatabaseHelper ticketDB = new TicketDatabaseHelper(BuyTicketActivity.this);
                ticketDB.addData(name_input.getText().toString(), category_input.getText().toString(),
                        date_input.getText().toString(), Integer.valueOf(quantity_input.getText().toString()));

                //Refresh Activity
                Intent intent = new Intent(BuyTicketActivity.this, BuyTicketActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    void init(){
        name_input = findViewById(R.id.name_input);
        category_input = findViewById(R.id.category_input);
        date_input = findViewById(R.id.date_input);
        quantity_input = findViewById(R.id.quantity_input);
        add_button = findViewById(R.id.add_button);
    }
}