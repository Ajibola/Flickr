package sample.app.flickr.search.image;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

/**
 * RecyclerView scroll listener implementation for bottom less scrolling
 *
 */
abstract class EndlessScroll extends RecyclerView.OnScrollListener {

    // recyclerview is set to refresh when there are less than 20 visible items
    private int visibleThreshold = 20;
    private int currentPage = 1;
    private int previousTotalItemCount = 0;
    private boolean loading = true;

    private final RecyclerView.LayoutManager mLayoutManager;

    public EndlessScroll(StaggeredGridLayoutManager layoutManager) {
        this.mLayoutManager = layoutManager;
        visibleThreshold = visibleThreshold * layoutManager.getSpanCount();
    }

    private int getLastVisibleItem(int[] lastVisibleItemPositions) {
        int maxSize = 0;
        for (int i = 0; i < lastVisibleItemPositions.length; i++) {
            if (i == 0) {
                maxSize = lastVisibleItemPositions[i];
            } else if (lastVisibleItemPositions[i] > maxSize) {
                maxSize = lastVisibleItemPositions[i];
            }
        }
        return maxSize;
    }

    @Override
    public void onScrolled(RecyclerView view, int dx, int dy) {
        super.onScrolled(view, dx, dy);

        int lastVisibleItemPosition;
        int totalItemCount = mLayoutManager.getItemCount();

        int[] lastVisibleItemPositions = ((StaggeredGridLayoutManager) mLayoutManager)
                .findLastCompletelyVisibleItemPositions(null);
        lastVisibleItemPosition = getLastVisibleItem(lastVisibleItemPositions);

        if (loading) {
            if (totalItemCount > previousTotalItemCount) {
                loading = false;
                previousTotalItemCount = totalItemCount;
            }
        }

        if (!loading && (lastVisibleItemPosition + visibleThreshold) >= totalItemCount) {
            currentPage++;
            onLoadMore(currentPage);
            loading = true;
        }
    }

    public abstract void onLoadMore(int page);

}
