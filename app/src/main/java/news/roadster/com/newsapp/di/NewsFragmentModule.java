package news.roadster.com.newsapp.di;

import android.content.Context;

import androidx.lifecycle.LifecycleOwner;
import dagger.Module;
import dagger.Provides;
import news.roadster.com.newsapp.fragment.NewsListPresenter;
import news.roadster.com.newsapp.fragment.NewsListView;
import news.roadster.com.newsapp.repo.NewsViewModel;

@Module
public class NewsFragmentModule {
    public final NewsListView newsListView;
    public final NewsViewModel newsViewModel;
    private final LifecycleOwner lifeCycleOwner;

    public NewsFragmentModule(NewsListView newsListView, NewsViewModel newsViewModel1, LifecycleOwner lifeCycleOwner){
        this.newsListView = newsListView;
        this.newsViewModel = newsViewModel1;
        this.lifeCycleOwner = lifeCycleOwner;
    }

    @ActivityScope
    @Provides
    public NewsListPresenter newsListPresenter(){
        return new NewsListPresenter(lifeCycleOwner, newsViewModel, newsListView);
    }
}
