package com.example.android.mrasyidridhotobing_1202150064_modul4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;


public class AsyncTaskGambar extends AppCompatActivity {
    //deklarasi variabel
    ImageView gambar;
    EditText url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task_gambar);

        //pemanggilan variabel yang ada
        gambar = (ImageView)findViewById(R.id.gambar);
        url = (EditText)findViewById(R.id.url);
    }

    //method saat button ditekan
    public void searchGambar(View view) {
        //loading gambar dari internet ke imageview
        Picasso.with(AsyncTaskGambar.this).load(url.getText().toString())
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher)
                .into(gambar);
    }
}
