package news.roadster.com.newsapp.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import androidx.recyclerview.widget.RecyclerView;
import news.roadster.com.newsapp.R;
import news.roadster.com.newsapp.pojo.Article;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.ViewHolder> {

    private Context context;

    private  List<Article> articles;

    public NewsListAdapter(Context context, List<Article> articleList){
        this.context = context;
        this.articles = articleList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.article_item,
                parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setItem(articles.get(position), position);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void updateList(List<Article> articles) {
        this.articles = articles;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }

        public void setItem(Article article, int position) {

        }
    }
}
