package news.roadster.com.newsapp.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import news.roadster.com.newsapp.R;
import news.roadster.com.newsapp.pojo.Article;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.ViewHolder> {

    private Context context;

    private NewsListView listCallback;

    private List<Article> articles = new ArrayList<>();

    public NewsListAdapter(Context context, NewsListView newsListView){
        this.context = context;
        this.listCallback = newsListView;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.article_item,
                parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setItem(articles.get(position));
    }

    @Override
    public int getItemCount() {
        return articles == null ? 0 :articles.size();
    }

    public void updateList(List<Article> articles) {
        this.articles = articles;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView icon;
        private TextView title;
        private TextView description;
        private TextView news_link;
        private TextView source;
        private ConstraintLayout itemLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            icon = (ImageView) itemView.findViewById(R.id.icon);
            title = (TextView) itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.description);
            news_link = (TextView) itemView.findViewById(R.id.news_link);
            source = (TextView) itemView.findViewById(R.id.source);
            itemLayout = (ConstraintLayout) itemView.findViewById(R.id.item_layout);
        }

        public void setItem(Article article) {
            title.setText(article.getTitle());
            description.setText(article.getDescription());
            source.setText(article.getAuthor());
            news_link.setText(context.getString(R.string.read_more) +  article.getUrl());

            Picasso.get().load(article.getUrlToImage()).into(icon);

            itemLayout.setOnClickListener(v -> {
                listCallback.openWebView(article);
            });
        }
    }
}
