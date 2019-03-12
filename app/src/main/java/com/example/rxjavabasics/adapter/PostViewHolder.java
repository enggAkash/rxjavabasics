package com.example.rxjavabasics.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.rxjavabasics.R;

public class PostViewHolder extends RecyclerView.ViewHolder {

    TextView title, body, author;

    public PostViewHolder(@NonNull View itemView) {
        super(itemView);

        title = itemView.findViewById(R.id.title);
        body = itemView.findViewById(R.id.body);
        author = itemView.findViewById(R.id.author);
    }
}
