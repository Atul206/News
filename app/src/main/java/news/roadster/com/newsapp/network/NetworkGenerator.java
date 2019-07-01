package news.roadster.com.newsapp.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkGenerator {

    private static NewsService newsService;

    public NetworkGenerator() {
    }

    public static NewsService generateNewsService(String baseUrl){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit.create(NewsService.class);
    }

    public static Gson gson() {
        return new GsonBuilder()
                .setLenient()
                .create();
    }
}
