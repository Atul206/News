package news.roadster.com.newsapp.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsService {

    @GET("top-headlines?country=us&apiKey=99b55b35b2624beda5fe6779275f05a33")
    Call<String> getNewList(@Query("country") String countryCode, @Query("apiKey") String apiKey);
}
