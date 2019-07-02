package news.roadster.com.newsapp.repo;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import news.roadster.com.newsapp.NApplication;
import news.roadster.com.newsapp.util.OfflineManager;
import news.roadster.com.newsapp.network.NewsService;
import news.roadster.com.newsapp.pojo.NewsData;

import static news.roadster.com.newsapp.BuildConfig.NEWS_API_KEY;

public class NewsRepository extends LiveData<NewsData> {

    private static NewsRepository newsRepository;

    private final NewsService newsService;

    Context context;

    public NewsRepository(NApplication application, NewsService newsService) {
        this.newsService = newsService;
        context = application;
    }

    public static NewsRepository getInstance(NApplication application, NewsService newsService) {
        if (newsRepository == null)
            return newsRepository = new NewsRepository(application, newsService);
        else return newsRepository;
    }

    public void fetchInformation() {
        newsService.getNewList("in", NEWS_API_KEY)
                .observeOn(Schedulers.computation())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<NewsData>() {
                    @Override
                    public void onNext(NewsData newsData) {
                        OfflineManager.putPref(context, OfflineManager.OFFLINE_NEWS_DATA, newsData);
                        postValue(newsData);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("Test", e.getMessage() + " Message");
                        NewsData newsData = OfflineManager.getPref(context,OfflineManager.OFFLINE_NEWS_DATA, null);
                        if(newsData == null){
                            Log.e("Test", "getting offfline null");
                        } else{
                            postValue(newsData);
                        }
                    }

                    @Override
                    public void onComplete() {
                        Log.d("Test","Done");
                    }
                });
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onInactive() {
        super.onInactive();
    }
}
