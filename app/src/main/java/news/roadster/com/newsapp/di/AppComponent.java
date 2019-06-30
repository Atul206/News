package news.roadster.com.newsapp.di;

import javax.inject.Singleton;

import dagger.Component;
import news.roadster.com.newsapp.NApplication;
import news.roadster.com.newsapp.fragment.NewsFragment;

@Component(modules = AppModule.class)
public interface AppComponent {

}
