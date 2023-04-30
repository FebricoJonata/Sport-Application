package com.example.sportapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sportapp.InformationDetailsActivity;
import com.example.sportapp.R;
import com.example.sportapp.database.modal.Information;

import java.util.List;

public class InformationAdapter extends RecyclerView.Adapter<InformationAdapter.ViewHolder> {


    Context ctx;
    List<Information> informationList;

    public InformationAdapter(Context ctx, List<Information> informationList) {
        this.ctx = ctx;
        this.informationList = informationList;
    }

    public void setInformationList(List<Information> informationList) {
        this.informationList = informationList;
    }

    @NonNull
    @Override
    public InformationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.information_card_view, parent, false);
        return new InformationAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InformationAdapter.ViewHolder holder, int position) {
        holder.image.setImageResource(informationList.get(position).getImage());
        holder.tittleTxt.setText(informationList.get(position).getTittle());
        holder.descriptionTxt.setText(informationList.get(position).getDescription());

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ctx, InformationDetailsActivity.class);
                intent.putExtra("image", informationList.get(position).getImage());
                intent.putExtra("tittle", informationList.get(position).getTittle());
                intent.putExtra("description", informationList.get(position).getDescription());
                ctx.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return informationList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tittleTxt, descriptionTxt;
        ImageView image;

        LinearLayout parentLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            image = itemView.findViewById(R.id.image_view);
            tittleTxt = itemView.findViewById(R.id.tittleTxt);
            descriptionTxt = itemView.findViewById(R.id.descriptionTxt);
        }
    }
}
