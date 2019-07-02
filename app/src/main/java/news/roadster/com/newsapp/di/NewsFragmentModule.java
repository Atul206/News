package news.roadster.com.newsapp.di;

import android.content.Context;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import news.roadster.com.newsapp.fragment.NewsListAdapter;
import news.roadster.com.newsapp.fragment.NewsListPresenter;
import news.roadster.com.newsapp.fragment.NewsListView;

@Module
public class NewsFragmentModule {
    public final NewsListView newsListView;
    public Context context;
    public NewsFragmentModule(Context context, NewsListView newsListView){
        this.newsListView = newsListView;
        this.context = context;
    }

    @ActivityScope
    @Provides
    public NewsListPresenter newsListPresenter(){
        return new NewsListPresenter(context, newsListView);
    }

    @ActivityScope
    @Provides
    public NewsListAdapter newsListAdapter(){
        return new NewsListAdapter(context, newsListView);
    }
}
