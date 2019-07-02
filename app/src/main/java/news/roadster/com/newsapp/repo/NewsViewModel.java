package news.roadster.com.newsapp.repo;

import android.app.Application;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import news.roadster.com.newsapp.NApplication;
import news.roadster.com.newsapp.pojo.NewsData;

public class NewsViewModel extends AndroidViewModel {

    @Inject
    NewsRepository newsRepository;

    public NewsViewModel(@NonNull Application application) {
        super(application);
        NApplication.getAppComponent().inject(this);
        newsRepository.fetchInformation();
    }

    public LiveData<NewsData> getNewsRepository() {
        return newsRepository;
    }
}
