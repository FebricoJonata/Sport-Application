package com.example.sportapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sportapp.R;
import com.example.sportapp.database.modal.Ticket;

import java.util.List;

public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.ViewHolder> {

    Context ctx;
    List<Ticket> ticketList;

    public TicketAdapter(Context ctx, List<Ticket> ticketList) {
        this.ctx = ctx;
        this.ticketList = ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    @NonNull
    @Override
    public TicketAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.history_card_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TicketAdapter.ViewHolder holder, int position) {
        holder.historyIDTxt.setText(String.valueOf(ticketList.get(position).getId()));
        holder.nameTxt.setText(String.valueOf(ticketList.get(position).getName()));
        holder.categoryTxt.setText(String.valueOf(ticketList.get(position).getCategory()));
        holder.dateTxt.setText(String.valueOf(ticketList.get(position).getDate()));
        holder.quantityTxt.setText(String.valueOf(ticketList.get(position).getQuantity()));
    }

    @Override
    public int getItemCount() {
        return ticketList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nameTxt, categoryTxt, dateTxt, quantityTxt, historyIDTxt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            historyIDTxt = itemView.findViewById(R.id.historyIDTxt);
            nameTxt = itemView.findViewById(R.id.nameTxt);
            categoryTxt = itemView.findViewById(R.id.categoryTxt);
            dateTxt = itemView.findViewById(R.id.dateTxt);
            quantityTxt = itemView.findViewById(R.id.quantityTxt);
        }
    }
}
