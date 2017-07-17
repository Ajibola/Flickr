package sample.app.flickr.widget;

import sample.app.flickr.R;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import sample.app.flickr.model.Photo;

/**
 * The UI view that holds the image and its title
 */
public class PhotoViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.img_photo) ImageView photoImage;
    @BindView(R.id.tv_title) TextView textTitle;

    public PhotoViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    /**
     * renders the title of the photo and the image
     * @param photo the data object to be rendered
     */
    public void render(Photo photo) {
        renderPhoto(photo.getUrl());
        renderTitle(photo.getTitle());
    }

    private void renderPhoto(String photoUrl) {
        getImage(photoUrl, photoImage);
    }

    private void renderTitle(String title) {
        textTitle.setText(title);
    }

    private void getImage(String photo, ImageView photoImageView) {
        Glide.with(photoImageView.getContext()).load(photo)
                .placeholder(R.mipmap.flickr_empty_place_holder)
                .error(R.mipmap.flickr_empty_place_holder)
                .into(photoImageView);
    }
}

