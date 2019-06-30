package news.roadster.com.newsapp.network;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsService {

    @GET("https://newsapi.org/v2/top-headlines?country=us&apiKey=99b55b35b2624beda5fe6779275f05a3")
    Call<String> getNewList();
}
