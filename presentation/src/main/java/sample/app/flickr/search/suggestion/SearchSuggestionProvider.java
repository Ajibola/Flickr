package sample.app.flickr.search.suggestion;

import android.content.SearchRecentSuggestionsProvider;

/**
 * Content provider for search suggestions. Required by SearchView suggestions implementation
 */
public class SearchSuggestionProvider extends SearchRecentSuggestionsProvider {

    public final static String AUTHORITY = "sample.app.flickr.search.suggestion.SearchSuggestionProvider";
    public final static int MODE = DATABASE_MODE_QUERIES;

    public SearchSuggestionProvider() {
        setupSuggestions(AUTHORITY, MODE);
    }

}
