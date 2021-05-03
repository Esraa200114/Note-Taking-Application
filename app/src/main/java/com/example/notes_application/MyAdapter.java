package com.example.notes_application;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.noteViewHolder> {

    ArrayList<Note> Notes;

    public MyAdapter(ArrayList<Note> Notes) {
        this.Notes = Notes;
    }

    @NonNull
    @Override
    //This method is called one time only for each item displayed on screen for the first time.
    public noteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_item_note,null,false);
        return new noteViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull noteViewHolder holder, int position) {

        Note n = Notes.get(position);
        holder.title_tv.setText(n.getTitle());
        holder.dbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Notes.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, Notes.size());
            }
        });
        holder.cdate_tv.setText(n.getCdate());

    }

    @Override
    public int getItemCount() {

        return Notes.size();
    }

    class noteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView title_tv;
        TextView cdate_tv;
        Button  dbutton;

        //Holder class for recycler view
        public noteViewHolder (@NonNull View itemview){

            super(itemview);

            title_tv = itemview.findViewById(R.id.note_title);
            dbutton = itemview.findViewById(R.id.delete_btn);
            cdate_tv = itemview.findViewById(R.id.note_cdate);
        }

        @Override
        public void onClick(View v) {

        }
    }
}

