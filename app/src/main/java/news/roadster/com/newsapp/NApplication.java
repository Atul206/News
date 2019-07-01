package news.roadster.com.newsapp;

import android.app.Application;

import javax.inject.Inject;

import news.roadster.com.newsapp.di.AppComponent;
import news.roadster.com.newsapp.di.AppModule;
import news.roadster.com.newsapp.di.DaggerAppComponent;
import news.roadster.com.newsapp.network.NewsService;
import news.roadster.com.newsapp.repo.NewsRepository;

public class NApplication extends Application {

    public static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initComponent();
    }

    public void initComponent(){
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        appComponent.inject(this);
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    /*
        Visible for testing mode
     */

    public void setTestComponent(AppComponent testingComponent) {
        appComponent = testingComponent;
    }
}
