package com.example.android.mrasyidridhotobing_1202150064_modul4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //method saat button LIST MAHASISWA ditekan
    public void listMahasiswa(View view) {
        //untuk berpindah ke AsyncTaskMahasiswa activity//
        Intent i = new Intent(MainActivity.this, AsyncTaskMahasiswa.class);
        startActivity(i);
    }

    //method saat button GAMBAR ditekan
    public void searchGambar(View view) {
        //untuk berpindah ke AsyncTaskGambar activity//
        Intent intent = new Intent(MainActivity.this, AsyncTaskGambar.class);
        startActivity(intent);
    }

}
