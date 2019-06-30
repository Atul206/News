package news.roadster.com.newsapp.network;

import java.util.List;

import io.reactivex.Observable;
import news.roadster.com.newsapp.pojo.NewsData;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsService {

    @GET("top-headlines?country=us&apiKey=99b55b35b2624beda5fe6779275f05a33")
    Observable<List<NewsData>> getNewList(@Query("country") String countryCode, @Query("apiKey") String apiKey);
}
