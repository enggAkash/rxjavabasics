package com.example.rxjavabasics.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rxjavabasics.R;
import com.example.rxjavabasics.model.ArticlePost;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {

    Context context;
    List<ArticlePost> postList;

    public PostAdapter(Context context, List<ArticlePost> postList) {
        this.context = context;
        this.postList = postList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.posts_item, viewGroup, false);

        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder postViewHolder, int position) {

        ArticlePost post = postList.get(position);

        postViewHolder.title.setText(String.valueOf(post.getTitle()));
        postViewHolder.body.setText(post.getBody().substring(0, 20) + "...");
        postViewHolder.author.setText(String.valueOf(post.getUserID()));

    }

    @Override
    public int getItemCount() {
        return postList.size();
    }
}
