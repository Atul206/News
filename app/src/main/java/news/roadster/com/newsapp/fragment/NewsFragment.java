package news.roadster.com.newsapp.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import news.roadster.com.newsapp.NApplication;
import news.roadster.com.newsapp.R;
import news.roadster.com.newsapp.di.NewsFragmentModule;
import news.roadster.com.newsapp.repo.NewsViewModel;

/**
 * News fragment: list of fragment details showing
 */
public class NewsFragment extends Fragment implements NewsListView {

    @Inject
    NewsListPresenter newsListPresenter;

    private NewsViewModel newsViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.article_view, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        newsViewModel = ViewModelProviders.of(getActivity()).get(NewsViewModel.class);
        NApplication.getAppComponent().plus(new NewsFragmentModule(this, newsViewModel, getActivity())).inject(this);
        newsListPresenter.onObserveNewsModel();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(newsViewModel.getNewsRepository().hasActiveObservers()){
            newsViewModel.getNewsRepository().removeObservers(getActivity());
        }
    }

    @Override
    public void populateInformation() {

    }

    @Override
    public void populateOfflineInforamtion() {

    }
}
