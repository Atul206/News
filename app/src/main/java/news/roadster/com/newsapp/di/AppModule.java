package news.roadster.com.newsapp.di;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import news.roadster.com.newsapp.NApplication;
import news.roadster.com.newsapp.network.NetworkGenerator;
import news.roadster.com.newsapp.repo.NewsRepository;

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

    @Singleton
    @Provides
    public Gson gson() {
        return new GsonBuilder()
                .setLenient()
                .create();
    }
}
