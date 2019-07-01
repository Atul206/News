package news.roadster.com.newsapp.fragment;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import javax.inject.Inject;

import androidx.lifecycle.LifecycleOwner;
import news.roadster.com.newsapp.NApplication;
import news.roadster.com.newsapp.repo.NewsViewModel;

public class NewsListPresenter {

    private  final NewsViewModel newsViewModel;
    private final NewsListView view;
    private final LifecycleOwner lifecycleOwner;

    public NewsListPresenter(LifecycleOwner lifeCycleOwner, NewsViewModel model, NewsListView listView) {
        newsViewModel = model;
        view = listView;
        this.lifecycleOwner = lifeCycleOwner;
    }


    public void onObserveNewsModel(){
        newsViewModel.getNewsRepository().observe(lifecycleOwner, newsData -> {
            if(newsData != null ) {
                view.populateInformation();
            }else{
                view.populateOfflineInforamtion();
            }
        });
    }
}
