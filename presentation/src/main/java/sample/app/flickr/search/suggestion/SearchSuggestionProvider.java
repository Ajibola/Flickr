package sample.app.flickr.search.suggestion;

import android.content.SearchRecentSuggestionsProvider;

/**
 * Created by hp on 7/14/2017.
 */

public class SearchSuggestionProvider extends SearchRecentSuggestionsProvider {

    public final static String AUTHORITY = "sample.app.flickr.search.suggestion.SearchSuggestionProvider";
    public final static int MODE = DATABASE_MODE_QUERIES;

    public SearchSuggestionProvider() {
        setupSuggestions(AUTHORITY, MODE);
    }

}
