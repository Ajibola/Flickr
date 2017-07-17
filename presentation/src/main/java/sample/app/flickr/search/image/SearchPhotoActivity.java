package sample.app.flickr.search.image;

import android.app.SearchManager;

import sample.app.flickr.R;
import sample.app.flickr.model.Photo;
import sample.app.flickr.model.PhotoAdapter;
import sample.app.flickr.search.suggestion.SearchSuggestionProvider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.SearchRecentSuggestions;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sample.app.flickr.widget.LoadingDialog;

/**
 * Search Activity for loading images from the image search API
 */
public class SearchPhotoActivity extends AppCompatActivity implements ISearchPhoto.View {

    @BindView(R.id.rv_images) RecyclerView recyclerViewImage;
    private SearchView searchView;
    private final String STATE_IMAGE_LIST = "state_image_list";

    private LoadingDialog loadingDialog;
    private ISearchPhoto.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new SearchPhotoPresenter(this);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,
                StaggeredGridLayoutManager.VERTICAL);
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        recyclerViewImage.setLayoutManager(layoutManager);
        recyclerViewImage.setOnScrollListener(new EndlessScroll(layoutManager) {
            @Override
            public void onLoadMore(int page) {
                presenter.loadMoreImages(Integer.toString(page));
            }
        });

        if (savedInstanceState != null) {
            Serializable serializableObject = savedInstanceState.getSerializable(STATE_IMAGE_LIST);
            if (serializableObject instanceof ArrayList<?>) {
                ArrayList<Photo> currPhotoList = (ArrayList<Photo>) serializableObject;
                showImages(currPhotoList, false);
            }
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        setIntent(intent);
        handleSearchIntent(intent);
    }

    private void handleSearchIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            SearchRecentSuggestions suggestions = new SearchRecentSuggestions(this,
                    SearchSuggestionProvider.getSuggestionAuthority(), SearchSuggestionProvider.getSuggestionMode());
            suggestions.saveRecentQuery(query, null);
            presenter.searchImage(query);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        MenuItem searchMenuItem = menu.findItem(R.id.search);
        searchView = (SearchView) searchMenuItem.getActionView();

        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
            searchView.setSubmitButtonEnabled(true);
            //close the searchview when suggestions are clicked or selected
            searchView.setOnSuggestionListener(new SearchView.OnSuggestionListener() {
                @Override
                public boolean onSuggestionSelect(int position) {
                    closeSearchView();
                    return false;
                }

                @Override
                public boolean onSuggestionClick(int position) {
                    closeSearchView();
                    return false;
                }
            });
            //close the searchview when the search field is submitted
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    closeSearchView();
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    return false;
                }
            });
        }

        return true;
    }

    private void closeSearchView() {
        if (searchView != null) {
            searchView.setQuery("", false);
            searchView.setIconified(true);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        ArrayList<Photo> currPhotoList = (ArrayList<Photo>) ((PhotoAdapter) recyclerViewImage.getAdapter()).getAll();
        outState.putSerializable(STATE_IMAGE_LIST, currPhotoList);
    }

    @Override
    public void showLoading() {
        if (loadingDialog == null) {
            loadingDialog = new LoadingDialog(this);
        }

        loadingDialog.show();
    }

    @Override
    public void hideLoading() {
        if (loadingDialog != null) {
            loadingDialog.dismiss();
            loadingDialog = null;
        }
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showImages(List<Photo> photoList, boolean update) {
        PhotoAdapter adapter;

        if (recyclerViewImage.getAdapter() == null) {
            adapter = new PhotoAdapter();
            recyclerViewImage.setAdapter(adapter);
        } else {
            adapter = (PhotoAdapter) recyclerViewImage.getAdapter();
        }

        if (update) {
            adapter.updateList(photoList);
        } else {
            adapter.refreshList(photoList);
        }
    }
}
