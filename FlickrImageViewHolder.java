package chayan.everymoments;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

//import android.content.Context;

/**
 * Created by CHAYAN_PC on 05-01-2018.
 */

public class FlickrImageViewHolder extends RecyclerView.ViewHolder {
    protected ImageView thumbnail;
    protected TextView title;

    public FlickrImageViewHolder(View view) {
        super(view);
        this.thumbnail = view.findViewById(R.id.thumbnail);
        this.title = view.findViewById(R.id.title);
    }

}
