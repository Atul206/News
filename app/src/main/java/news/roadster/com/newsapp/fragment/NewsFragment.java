package news.roadster.com.newsapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import news.roadster.com.newsapp.activity.MainActivity;
import news.roadster.com.newsapp.NApplication;
import news.roadster.com.newsapp.R;
import news.roadster.com.newsapp.di.NewsFragmentModule;
import news.roadster.com.newsapp.pojo.Article;
import news.roadster.com.newsapp.repo.NewsViewModel;

/**
 * News fragment: list of fragment details showing
 */
public class NewsFragment extends Fragment implements NewsListView {

    @Inject
    NewsListPresenter newsListPresenter;

    @Inject
    NewsListAdapter newsListAdapter;

    private RecyclerView recyclerView;

    private NewsViewModel newsViewModel;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.article_view, container, false);
        initUI(view);
        return view;
    }

    private void initUI(View view) {
        recyclerView = view.findViewById(R.id.list);
        LinearLayoutManager linearLayout = new LinearLayoutManager(getActivity());
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        recyclerView.setLayoutManager(linearLayout);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        NApplication.getAppComponent().plus(new NewsFragmentModule(getContext(), this)).inject(this);
        recyclerView.setAdapter(newsListAdapter);
        newsViewModel = ViewModelProviders.of(getActivity()).get(NewsViewModel.class);
        onObserveNewsModel();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (newsViewModel.getNewsRepository().hasActiveObservers()) {
            newsViewModel.getNewsRepository().removeObservers(getActivity());
        }
    }

    public void onObserveNewsModel(){
        newsViewModel.getNewsRepository().observe(getActivity(), newsData -> {
            //Check if newsdata getting null or empty
            if(newsData != null && newsData.getArticles() != null) {
                newsListAdapter.updateList(newsData.getArticles());
            }
            //Offline manage by ViewModelClass
        });
    }

    @Override
    public void openWebView(Article article) {
        ((MainActivity)getActivity()).openDetailActivity(article);
    }
}
