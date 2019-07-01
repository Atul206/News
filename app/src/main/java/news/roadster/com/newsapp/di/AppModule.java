package news.roadster.com.newsapp.di;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import news.roadster.com.newsapp.NApplication;
import news.roadster.com.newsapp.network.NetworkGenerator;
import news.roadster.com.newsapp.network.NewsService;
import news.roadster.com.newsapp.repo.NewsRepository;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {
    NApplication application;

    public AppModule(NApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public NApplication provideApplication(){
        return application;
    }


    @Singleton
    @Provides
    public NewsRepository provideNewsRepository(){
        String baseUrl = "https://newsapi.org/v2/";
        return NewsRepository.getInstance(application, NetworkGenerator.generateNewsService(baseUrl));
    }
}
