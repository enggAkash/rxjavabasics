package com.example.rxjavabasics;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GithubRepoAdapter extends BaseAdapter {

    private List<GithubRepo> githubRepos = new ArrayList<>();
    Context mContext;

    public GithubRepoAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return githubRepos.size();
    }

    @Override
    public GithubRepo getItem(int position) {
        if (position < 0 || position >= githubRepos.size())
            return null;
        else
            return githubRepos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView == null ? createView(parent) : convertView;

        GithubViewHolder githubViewHolder = (GithubViewHolder) view.getTag();
        githubViewHolder.setGithubRepo(getItem(position));

        return view;
    }

    public void setGithubRepos(List<GithubRepo> githubRepos) {
        if (githubRepos == null)
            return;

        this.githubRepos.clear();
        this.githubRepos.addAll(githubRepos);
        notifyDataSetChanged();
    }

    private View createView(ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_github_repo, parent, false);

        GithubViewHolder gitHubViewHolder = new GithubViewHolder(view, mContext);
        view.setTag(gitHubViewHolder);

        return view;
    }

    public void add(GithubRepo githubRepo) {
        githubRepos.add(githubRepo);
        notifyDataSetChanged();
    }

    private static class GithubViewHolder {
        Context context;
        private TextView textRepoName;
        private TextView textRepoDescription;
        private TextView textRepoLanguage;
        private TextView textStars;

        public GithubViewHolder(View itemView, Context context) {
            textRepoName = itemView.findViewById(R.id.text_repo_name);
            textRepoDescription = itemView.findViewById(R.id.text_repo_description);
            textRepoLanguage = itemView.findViewById(R.id.text_repo_language);
            textStars = itemView.findViewById(R.id.text_stars);
            this.context = context;
        }

        public void setGithubRepo(GithubRepo githubRepo) {
            textRepoName.setText(githubRepo.getName());
            textRepoDescription.setText(githubRepo.getDescription());
            textRepoLanguage.setText(context.getString(R.string.repo_language, githubRepo.getLanguage()));
            textStars.setText(context.getString(R.string.repo_stars, githubRepo.getStargazersCount()));

        }
    }
}
