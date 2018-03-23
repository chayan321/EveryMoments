package chayan.everymoments;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ViewPhotoDetailsActivity extends BaseActivity {
    private ImageView imageView;

    private ImageView btnDownload;
    // String URL=photo.getLink()+"/download";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.flickrPrimaryBackgroundColor));
        }


        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_details);
        activateToolbarWithHomeEnabled();
        Intent intent = getIntent();
        final Photo photo = (Photo) intent.getSerializableExtra(PHOTO_TRANSFER);

        TextView photoTitle = findViewById(R.id.photo_title);
        photoTitle.setText("Title:" + photo.getTitle());

        TextView photoTags = findViewById(R.id.photo_tags);
        photoTags.setText("Tags:" + photo.getTitle());

        TextView photoAuthor = findViewById(R.id.photo_author);
        photoAuthor.setText(photo.getTitle());

        ImageView photoImage = findViewById(R.id.photo_image);
        Picasso.with(this).load(photo.getLink())
                .error(R.drawable.placeholder)
                .placeholder(R.drawable.placeholder)
                .into(photoImage);
        imageView = findViewById(R.id.share_image);
        btnDownload = findViewById(R.id.download_image);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("Text/plain");
                String shareBody = photo.getLink() + "/download";
                String shareSub = "EveryMoments";
                myIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                myIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
                //  myIntent.setPackage("com.whatsapp");
                startActivity(Intent.createChooser(myIntent, "share Using"));
            }
        });
        btnDownload.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String url = photo.getLink() + "/download";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        item.getItemId();
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
