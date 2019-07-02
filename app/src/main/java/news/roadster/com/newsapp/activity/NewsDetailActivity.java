package news.roadster.com.newsapp.activity;

import android.content.Intent;
import android.os.Bundle;

import com.google.gson.Gson;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import news.roadster.com.newsapp.NApplication;
import news.roadster.com.newsapp.R;
import news.roadster.com.newsapp.pojo.Article;

public class NewsDetailActivity extends AppCompatActivity {

    @Inject
    Gson gson;

    private Article article;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_main);
        NApplication.getAppComponent().inject(this);
        Intent intent = getIntent();
        article = gson.fromJson(intent.getExtras().getString("NEWS_DETAIL"), Article.class);
    }

    public Article getArticleData() {
        return article;
    }
}
