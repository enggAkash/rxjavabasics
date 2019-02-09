package com.example.rxjavabasics;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class GithubClient {

    private static final String GITHUB_BASE_URL = "https://api.github.com/";

    private static GithubClient instance;
    private static GithubService githubService;

    private GithubClient() {
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();

        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(GITHUB_BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        githubService = retrofit.create(GithubService.class);
    }

    public static GithubClient getInstance() {
        if (instance == null)
            instance = new GithubClient();
        return instance;
    }

    public Observable<List<GithubRepo>> getStarredRepo(@NonNull String userName) {
        return githubService.getStarredRepositories(userName);
    }

}
