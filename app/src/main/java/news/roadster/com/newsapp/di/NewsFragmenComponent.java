package news.roadster.com.newsapp.di;

import dagger.Subcomponent;
import news.roadster.com.newsapp.fragment.NewsFragment;

@ActivityScope
@Subcomponent(modules = NewsFragmentModule.class)
public interface NewsFragmenComponent {
    void inject(NewsFragment newsFragment);
}
