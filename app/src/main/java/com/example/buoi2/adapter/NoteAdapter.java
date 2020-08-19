package com.example.buoi2.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.buoi2.R;
import com.example.buoi2.model.Note;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {
    private List<Note> noteList;
    private Context context;
    private List<Note> listSearch = new ArrayList<>();


    public NoteAdapter(List<Note> noteList, Context context) {
        this.noteList = noteList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_note, parent, false);

        ViewHolder myHolder = new ViewHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Note item = noteList.get(position);
        holder.tvId.setText("Id: " + item.getId() + "");
        holder.tvUserId.setVisibility(View.GONE);
        holder.tvTitle.setVisibility(View.GONE);
        if (item.getCompleted()==true){
holder.tvId.setTextColor(Color.BLUE);
        }else {
            holder.tvId.setTextColor(Color.RED);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
                alertDialog.setView(R.layout.item_note);
                AlertDialog dialog = alertDialog.show();
                ImageView imgStar;
                TextView tvUserId;
                TextView tvId;
                TextView tvTitle;

                tvUserId = (TextView) dialog.findViewById(R.id.tvUserId);
                tvId = (TextView) dialog.findViewById(R.id.tvId);
                tvTitle = (TextView) dialog.findViewById(R.id.tvTitle);

                tvUserId.setText("User id: " + item.getUserId() + "");
                tvId.setText("Id: " + item.getId() + "");
                tvTitle.setText("Title: " + item.getTitle() + "");


            }
        });
    }

    @Override
    public int getItemCount() {
       return noteList.size();
    }
    public void SearchId(ArrayList<Note> arrayListed) {
      noteList=arrayListed;


        notifyDataSetChanged();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ConstraintLayout parentConstraint;
        private LinearLayout linearLayout;
        private TextView tvUserId;
        private TextView tvId;
        private TextView tvTitle;
        private ImageView imgStar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parentConstraint = (ConstraintLayout) itemView.findViewById(R.id.parentConstraint);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
            tvUserId = (TextView) itemView.findViewById(R.id.tvUserId);
            tvId = (TextView) itemView.findViewById(R.id.tvId);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);

        }
    }
}
