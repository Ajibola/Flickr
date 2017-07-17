package sample.app.flickr.search.suggestion;

import android.content.SearchRecentSuggestionsProvider;

import sample.app.data.App;
import sample.app.flickr.R;
import sample.app.flickr.search.image.SearchPhotoActivity;

/**
 * Content provider for search suggestions. Required by SearchView suggestions implementation
 */
public class SearchSuggestionProvider extends SearchRecentSuggestionsProvider {

    public SearchSuggestionProvider() {
        setupSuggestions(getSuggestionAuthority(),
                DATABASE_MODE_QUERIES);
    }

    /**
     * @return returns the string for the suggestion authority
     */
    public static String getSuggestionAuthority() {
        ActivityThread at = ActivityThread.systemMain();
        Context context = at.getSystemContext();
        return App.getContext().getString(R.string.search_suggestion_authority);
    }

    /**
     * @return the mode for search suggestions
     */
    public static int getSuggestionMode() {
        return DATABASE_MODE_QUERIES;
    }
}
