package news.roadster.com.newsapp.fragment;

import news.roadster.com.newsapp.pojo.Article;

public interface NewsListView {
    void populateInformation();

    void populateOfflineInforamtion();

    void openWebView(Article article);
}
