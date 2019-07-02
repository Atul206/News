package news.roadster.com.newsapp.activity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import news.roadster.com.newsapp.NApplication;
import news.roadster.com.newsapp.R;
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
        //Inject MainActivity
        NApplication.getAppComponent().inject(this);
    }


    public void openDetailActivity(Article article) {
        //check device is online or not
        if (NewsUtil.isOnline(this)) {
            Intent intent = new Intent(this, NewsDetailActivity.class);
            intent.putExtra("NEWS_DETAIL", gson.toJson(article));
            startActivity(intent);
        } else {
            //When device is offline
            Snackbar.make(mainLayout, "Device is offline", 3000).show();
        }
    }
}
