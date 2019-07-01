package news.roadster.com.newsapp.fragment;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import javax.inject.Inject;

import androidx.lifecycle.LifecycleOwner;
import news.roadster.com.newsapp.NApplication;
import news.roadster.com.newsapp.repo.NewsViewModel;

public class NewsListPresenter {

    private final NewsListView view;
    private final Context context;

    public NewsListPresenter(Context context, NewsListView listView) {
        view = listView;
        this.context = context;
    }
}
