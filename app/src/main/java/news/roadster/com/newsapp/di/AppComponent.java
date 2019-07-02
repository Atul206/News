package news.roadster.com.newsapp.di;

import javax.inject.Singleton;

import dagger.Component;
import news.roadster.com.newsapp.activity.MainActivity;
import news.roadster.com.newsapp.NApplication;
import news.roadster.com.newsapp.activity.NewsDetailActivity;
import news.roadster.com.newsapp.repo.NewsViewModel;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(NApplication application);
    void inject(NewsViewModel newsViewModel);
    void inject(MainActivity mainActivity);
    void inject(NewsDetailActivity newsDetailActivity);
    NewsFragmenComponent plus(NewsFragmentModule newsFragmentModule);
}
