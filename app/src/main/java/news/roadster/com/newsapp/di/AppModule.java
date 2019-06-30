package news.roadster.com.newsapp.di;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Provides;
import news.roadster.com.newsapp.BuildConfig;
import news.roadster.com.newsapp.NApplication;
import news.roadster.com.newsapp.network.NewsService;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Singleton
public class AppModule {
    NApplication application;

    public AppModule(NApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Application provideApplication(){
        return application;
    }

    @Provides
    @Singleton
    Gson gson() {
        return new GsonBuilder()
                .setLenient()
                .create();
    }

    @Provides
    @Singleton
    public NewsService provideNewsService(){
        String baseUrl = "https://newsapi.org/v2/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit.create(NewsService.class);
    }
}
