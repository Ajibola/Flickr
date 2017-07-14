package sample.app.flickr.model;

import sample.app.flickr.R;
import sample.app.flickr.search.image.ISearchPhoto;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by hp on 7/14/2017.
 */

public class PhotoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<Photo> photoList;
    private final ISearchPhoto.Presenter presenter;

    public PhotoAdapter(@NonNull ISearchPhoto.Presenter presenter) {
        this.presenter = presenter;
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

    public void addAll(Collection<Photo> collection) {
        photoList.addAll(collection);
    }

    public List<Photo> getAll() {
        return photoList;
    }
}
