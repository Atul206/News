package news.roadster.com.newsapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.gson.Gson;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import news.roadster.com.newsapp.pojo.Article;

public class MainActivity extends AppCompatActivity {

    @Inject
    public Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NApplication.getAppComponent().inject(this);
    }


    public void openDetailActivity(Article article) {
        Intent intent = new Intent(this, NewsDetailActivity.class);
        intent.putExtra("NEWS_DETAIL", gson.toJson(article));
        startActivity(intent);
    }
}
