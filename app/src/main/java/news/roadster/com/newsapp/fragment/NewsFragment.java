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
import androidx.recyclerview.widget.RecyclerView;
import news.roadster.com.newsapp.R;
import news.roadster.com.newsapp.repo.NewsRepository;
import news.roadster.com.newsapp.repo.NewsViewModel;

/**
 * News fragment: list of fragment details showing
 */
public class NewsFragment extends Fragment {

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
        onObserveNewsModel();
    }

    private void onObserveNewsModel(){
        newsViewModel.getNewsRepository().observe(this, newsData -> {
            if(newsData != null ) {
                Log.d("Test", newsData.toString());
            }else{
                Log.d("Test", "Getting null or empty");
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(newsViewModel.getNewsRepository().hasActiveObservers()){
            newsViewModel.getNewsRepository().removeObservers(getActivity());
        }
    }
}
