package nju.androidchat.client.component;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.annotation.GlideModule;

import androidx.annotation.StyleableRes;

import java.util.UUID;

import nju.androidchat.client.R;

public class ItemImgReceive extends LinearLayout {



    @StyleableRes
    int index0 = 0;

    private ImageView imageView;
    private Context context;
    private UUID messageId;
    private OnRecallMessageRequested onRecallMessageRequested;
    private String URL;

    public ItemImgReceive(Context context, String URL, UUID messageId) {
        super(context);
        this.context = context;
        inflate(context, R.layout.item_img_receive, this);
        this.imageView = findViewById(R.id.chat_item_content_img);
        this.messageId = messageId;
        setURL(URL);
    }

    public String getURL() {
        return this.URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
        setURLimage(URL);
    }
    //https://www.cnblogs.com/guilin-hu/p/5706916.html
    public void setURLimage(String url) {
        Glide.with(context).load(url).into(this.imageView);
    }
}
