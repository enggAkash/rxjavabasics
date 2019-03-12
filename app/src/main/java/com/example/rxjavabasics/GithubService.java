package com.example.rxjavabasics;

import com.example.rxjavabasics.model.ArticlePost;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubService {

    @GET("users/{user}/starred")
    Observable<List<GithubRepo>> getStarredRepositories(@Path("user") String userName);

    @GET("posts")
    Observable<List<ArticlePost>> getPosts();

}
