package com.example.android.mrasyidridhotobing_1202150064_modul4;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class AsyncTaskMahasiswa extends AppCompatActivity {
    //pendeklarasian variabel
    ListView listMhswa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task_mahasiswa);
        //memanggil variabel
        listMhswa = (ListView) findViewById(R.id.listnamamahasiswa);
    }

    //method saat button ditekan
    public void mulai(View view) {
        new getData(listMhswa).execute(); //proses asynctask dimulai
    }

    class getData extends AsyncTask<String, Integer, String> {
        ListView listMhswa;
        ArrayAdapter adapter;
        ArrayList<String> listNama;
        ProgressDialog dialog;

        public getData(ListView listMhswa) {
            this.listMhswa = listMhswa;
            dialog = new ProgressDialog(AsyncTaskMahasiswa.this);
            listNama = new ArrayList<>();
        }

        //method ketika asynctask belum dijalankan
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //menampilkan proses dialog
            dialog.setTitle("Loading Data");
            dialog.setIndeterminate(true);
            dialog.setProgress(0);
            dialog.setMax(100);
            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dialog.setCancelable(true);
            dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel Process", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialog.dismiss();
                    getData.this.cancel(true);
                }
            });
            dialog.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            adapter = new ArrayAdapter<>
                    (AsyncTaskMahasiswa.this, android.R.layout.simple_list_item_1, listNama); //membuat adapter

            String[] mhs = getResources().getStringArray(R.array.listnama);
            //logika perulangan untuk menyimpan array
            for (int a = 0; a < mhs.length; a++) {
                final long persen = 100L * a / mhs.length;
                final String nama = mhs[a];
                try {
                    Runnable change = new Runnable() {
                        @Override
                        public void run() {
                            dialog.setMessage((int) persen + "% - Adding " + nama);
                        }
                    };
                    runOnUiThread(change);
                    Thread.sleep(300);
                    listNama.add(mhs[a]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        //method sesudah asynctask dijalankan
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            listMhswa.setAdapter(adapter);
            dialog.dismiss();

        }
    }
}
