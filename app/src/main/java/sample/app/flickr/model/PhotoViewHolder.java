package sample.app.flickr.model;

import sample.app.flickr.R;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hp on 7/14/2017.
 */

public class PhotoViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.img_photo) ImageView photoImage;
    @BindView(R.id.tv_title) TextView textTitle;

    public PhotoViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

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
        Glide.with(photoImageView).load(photo).into(photoImageView);
    }
}

