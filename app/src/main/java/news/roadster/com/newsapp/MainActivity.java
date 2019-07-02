package news.roadster.com.newsapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import news.roadster.com.newsapp.pojo.Article;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void openDetailActivity(Article article) {

    }
}
