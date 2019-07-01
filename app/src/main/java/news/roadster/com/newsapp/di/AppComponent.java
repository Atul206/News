package news.roadster.com.newsapp.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import news.roadster.com.newsapp.NApplication;
import news.roadster.com.newsapp.fragment.NewsFragment;
import news.roadster.com.newsapp.network.NewsService;
import news.roadster.com.newsapp.repo.NewsRepository;
import news.roadster.com.newsapp.repo.NewsViewModel;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(NApplication application);
    void inject(NewsViewModel newsViewModel);
    NewsFragmenComponent plus(NewsFragmentModule newsFragmentModule);
}
