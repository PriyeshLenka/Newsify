package com.nextgen.newsify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class NewsDetailActivity extends AppCompatActivity {
    String title,desc,content,imageURL,url;
    private TextView titleTV1,subDescTV1,contentTV1;
    private ImageView newsIV1;
    private Button readNewsBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_news_detail);
        title = getIntent().getStringExtra("title");
        desc = getIntent().getStringExtra("Description");
        content = getIntent().getStringExtra("content");
        imageURL = getIntent().getStringExtra("UrlToImage");
        url = getIntent().getStringExtra("Url");

        titleTV1 = findViewById(R.id.idTVTitle1);
        subDescTV1 = findViewById(R.id.idTVSubDesc1);
        contentTV1 =findViewById(R.id.idTVContent1);
        newsIV1 = findViewById(R.id.idIVNews1);
        readNewsBtn = findViewById(R.id.idBtnReadNews);
        titleTV1.setText(title);
        subDescTV1.setText(desc);
        contentTV1.setText(content);
        Picasso.get().load(imageURL).into(newsIV1);
        readNewsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });


    }
}