package news.roadster.com.newsapp.pojo;

import java.io.Serializable;
import java.util.List;

public class NewsData implements Serializable {
    List<Article> articles;
    int totalResults;
    String status;

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
