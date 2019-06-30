package news.roadster.com.newsapp.repo;

import android.app.Application;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class NewsViewModel extends AndroidViewModel {

    @Inject
    NewsRepository newsRepository;

    public NewsViewModel(@NonNull Application application, String countryCode) {
        super(application);
        newsRepository.fetchInformation(countryCode);
    }

}
