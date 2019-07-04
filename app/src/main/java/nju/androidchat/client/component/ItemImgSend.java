package nju.androidchat.client.component;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.StyleableRes;

import com.bumptech.glide.Glide;

import java.util.UUID;

import lombok.Setter;
import nju.androidchat.client.R;

public class ItemImgSend extends LinearLayout implements View.OnLongClickListener {




    @StyleableRes
    int index0 = 0;

    private ImageView imageView;
    private Context context;
    private UUID messageId;
    private String url;
    @Setter
    private OnRecallMessageRequested onRecallMessageRequested;

    public ItemImgSend(Context context, String url, UUID messageId, OnRecallMessageRequested onRecallMessageRequested) {
        super(context);
        this.context = context;
        inflate(context, R.layout.item_img_send, this);
        this.imageView = findViewById(R.id.chat_item_content_img);
        this.messageId = messageId;
        this.onRecallMessageRequested = onRecallMessageRequested;
        this.setOnLongClickListener(this);
        setURL(url);
    }

    public String getURL() {
        return this.url;
    }

    public void setURL(String URL) {
        this.url = URL;
        setURLimage(url);
    }

    public void setURLimage(String url) {
        //https://www.cnblogs.com/guilin-hu/p/5706916.html
        Glide.with(context).load(url).into(this.imageView);
    }

    @Override
    public boolean onLongClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("确定要撤回这条消息吗？")
                .setPositiveButton("是", (dialog, which) -> {
                    if (onRecallMessageRequested != null) {
                        onRecallMessageRequested.onRecallMessageRequested(this.messageId);
                    }
                })
                .setNegativeButton("否", ((dialog, which) -> {
                }))
                .create()
                .show();

        return true;
    }


}
