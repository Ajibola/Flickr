package sample.app.flickr.model;

import sample.app.flickr.R;
import sample.app.flickr.widget.PhotoViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * PhotoAdapter loads and manages items on the recycler view
 */
public class PhotoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<Photo> photoList;

    public PhotoAdapter() {
        photoList = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_photo, parent, false);
        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        PhotoViewHolder photoViewHolder = (PhotoViewHolder) holder;
        Photo photo = photoList.get(position);
        photoViewHolder.render(photo);
    }

    @Override
    public int getItemCount() {
        return photoList.size();
    }

    /**
     * Clears the existing collection and adds a new collection.
     * Calls for the UI to be re drawn with notifyDataSetChanged
     *
     * @param collection value to replace existing collection
     */
    public void refreshList(Collection<Photo> collection) {
        photoList.clear();
        photoList.addAll(collection);
        notifyDataSetChanged();
    }

    /**
     * Appends the parameter to the existing collection, and notifies the adapter of the newly inserted items
     *
     * @param collection list of items to be appended
     */
    public void updateList(Collection<Photo> collection) {
        int oldRange = photoList.size();
        photoList.addAll(collection);
        int newRange = photoList.size();
        notifyItemRangeInserted(oldRange, newRange);
    }

    /**
     * @return the current list of elements in the adapter
     */
    public List<Photo> getAll() {
        return photoList;
    }
}
