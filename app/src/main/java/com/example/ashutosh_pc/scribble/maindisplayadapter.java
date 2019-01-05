package com.example.ashutosh_pc.scribble;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class maindisplayadapter extends RecyclerView.Adapter<maindisplayadapter.appViewHolder> {
    private ArrayList<TextActivity> displaylist;
    private Context ctx;
    private Random random=new Random();

    public maindisplayadapter(ArrayList<TextActivity> displaylist, Context ctx) {
        this.displaylist = displaylist;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public appViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater lif=LayoutInflater.from(ctx);
        View inflatedview=lif.inflate(R.layout.text_items,parent,false);
        return new appViewHolder(inflatedview);
    }

    @Override
    public void onBindViewHolder(@NonNull final appViewHolder holder, final int position) {
        final TextActivity currentitem=displaylist.get(position);
        int color= Color.argb(255,random.nextInt(256),random.nextInt(256),random.nextInt(256));
        holder.cardView.setCardBackgroundColor(color);
        holder.appTitle.setText(currentitem.getHeadtext());
        holder.currenttime.setText(currentitem.getDate());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ctx,noting_space.class);
                intent.putExtra("KEY",currentitem);
                intent.putExtra("POS",holder.getAdapterPosition());
                ctx.startActivity(intent);

            }
        });
    }


    @Override
    public int getItemCount() {
        return displaylist.size();
    }

    class appViewHolder extends RecyclerView.ViewHolder{

        TextView appTitle,currenttime;
        CardView cardView;
        public appViewHolder(View itemView) {
            super(itemView);
            appTitle=itemView.findViewById(R.id.nameview);
            currenttime=itemView.findViewById(R.id.dateview);
            cardView=itemView.findViewById(R.id.cardview);
        }
    }

}
