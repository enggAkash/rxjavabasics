package com.example.rxjavabasics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.rxjavabasics.adapter.PostAdapter;
import com.example.rxjavabasics.model.ArticlePost;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class RxjavaWithRetrofit extends AppCompatActivity {

    RecyclerView postRv;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava_with_retrofit);

        postRv = findViewById(R.id.post_recyclerview);
        postRv.setHasFixedSize(true);
        postRv.setLayoutManager(new LinearLayoutManager(this));

        fetchPosts();

    }

    private void fetchPosts() {
        compositeDisposable.add(
                GithubClient.getInstance().getArticlePosts()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<List<ArticlePost>>() {
                            @Override
                            public void accept(List<ArticlePost> articlePosts) throws Exception {
                                displayPosts(articlePosts);
                            }
                        })
        );
    }

    private void displayPosts(List<ArticlePost> articlePosts) {
        PostAdapter postAdapter = new PostAdapter(this, articlePosts);

        postRv.setAdapter(postAdapter);

    }


    @Override
    protected void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }
}
