package sample.app.flickr.search.image;

import android.app.SearchManager;

import sample.app.flickr.R;
import sample.app.flickr.model.Photo;
import sample.app.flickr.model.PhotoAdapter;
import sample.app.flickr.search.BaseActivity;
import sample.app.flickr.search.suggestion.SearchSuggestionProvider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.SearchRecentSuggestions;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Main app entry point
 */
public class SearchPhotoActivity extends BaseActivity implements ISearchPhoto.View {

    @BindView(R.id.rv_images) RecyclerView recyclerViewImage;
    private static final String STATE_IMAGE_LIST = "imageList";

    ISearchPhoto.Presenter presenter;
    int page = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,
                StaggeredGridLayoutManager.VERTICAL);
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        recyclerViewImage.setLayoutManager(layoutManager);

        presenter = new SearchPhotoPresenter(this);

        if (savedInstanceState != null) {
            ArrayList<Photo> currPhotoList = (ArrayList<Photo>) savedInstanceState.getSerializable(STATE_IMAGE_LIST);
            showImages(currPhotoList);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        setIntent(intent);
        handleSearchIntent(intent);
    }

    public void handleSearchIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            SearchRecentSuggestions suggestions = new SearchRecentSuggestions(this,
                    SearchSuggestionProvider.AUTHORITY, SearchSuggestionProvider.MODE);
            suggestions.saveRecentQuery(query, null);
            presenter.searchImage(query, Integer.toString(page));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        MenuItem searchMenuItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) searchMenuItem.getActionView();

        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
            searchView.setSubmitButtonEnabled(true);
        }

        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        ArrayList<Photo> currPhotoList = (ArrayList<Photo>) ((PhotoAdapter) recyclerViewImage.getAdapter()).getAll();
        outState.putSerializable(STATE_IMAGE_LIST, currPhotoList);
    }

    @Override
    public void showImages(List<Photo> photoList) {
        PhotoAdapter adapter = new PhotoAdapter(presenter);
        adapter.addAll(photoList);
        recyclerViewImage.setAdapter(adapter);
        recyclerViewImage.getAdapter().notifyDataSetChanged();
    }
}
