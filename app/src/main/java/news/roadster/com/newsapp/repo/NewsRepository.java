package news.roadster.com.newsapp.repo;

import android.content.Context;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import news.roadster.com.newsapp.NApplication;
import news.roadster.com.newsapp.network.NewsService;
import news.roadster.com.newsapp.pojo.NewsData;

import static news.roadster.com.newsapp.BuildConfig.NEWS_API_KEY;

public class NewsRepository extends LiveData<List<NewsData>> {

    Context context;

    @Inject
    NewsService newsService;

    @Inject
    public NewsRepository(NApplication application){
        context = application;
    }

    public void fetchInformation(String countryCode){
        newsService.getNewList("in", NEWS_API_KEY)
                .observeOn(Schedulers.computation())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<NewsData>>() {
                    @Override
                    public void onNext(List<NewsData> newsData) {
                        setValue(newsData);
                    }

                    @Override
                    public void onError(Throwable e) {
                        //Log.d(TAG, e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        //Log.d(TAG, e.getMessage());
                    }
                });
    }

    @Override
    protected void onActive() {
        super.onActive();
    }

    @Override
    protected void onInactive() {
        super.onInactive();
    }

    @Nullable
    @Override
    public List<NewsData> getValue() {
        return super.getValue();
    }
}
