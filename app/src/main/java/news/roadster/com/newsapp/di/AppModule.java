package news.roadster.com.newsapp.di;

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
}
