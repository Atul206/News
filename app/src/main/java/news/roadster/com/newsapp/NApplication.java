package news.roadster.com.newsapp;

import android.app.Application;

import javax.inject.Inject;

import news.roadster.com.newsapp.di.AppComponent;
import news.roadster.com.newsapp.di.AppModule;
import news.roadster.com.newsapp.di.DaggerAppComponent;

public class NApplication extends Application {

    public static AppComponent appComponent;

    @Inject
    NApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        initComponent();
    }

    public void initComponent(){
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(application))
                .build();
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
