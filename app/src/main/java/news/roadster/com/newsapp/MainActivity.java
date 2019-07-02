package news.roadster.com.newsapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import news.roadster.com.newsapp.pojo.Article;
import news.roadster.com.newsapp.util.NewsUtil;

public class MainActivity extends AppCompatActivity {

    @Inject
    public Gson gson;

    LinearLayoutCompat mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainLayout = findViewById(R.id.main_container);
        NApplication.getAppComponent().inject(this);
    }


    public void openDetailActivity(Article article) {
        if(NewsUtil.isOnline(this)) {
            Intent intent = new Intent(this, NewsDetailActivity.class);
            intent.putExtra("NEWS_DETAIL", gson.toJson(article));
            startActivity(intent);
        }else{
            Snackbar.make(mainLayout, "Device is offline", 3000).show();
        }
    }
}
