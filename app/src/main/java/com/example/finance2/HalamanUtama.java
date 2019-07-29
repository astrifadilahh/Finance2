package com.example.finance2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HalamanUtama extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_utama);
    }

    public void beranda(View view) {
        Intent i = new Intent(HalamanUtama.this, BerandaAkun.class);
        startActivity(i);
    }

    public void catatan(View view) {
        Intent i = new Intent(HalamanUtama.this, Catatan.class);
        startActivity(i);
    }

    public void daftar(View view) {
        Intent i = new Intent(HalamanUtama.this, DaftarBelanja.class);
        startActivity(i);
    }

    public void anggaran(View view) {
        Intent i = new Intent(HalamanUtama.this, Anggaran.class);
        startActivity(i);
    }

    public void apk(View view) {
        Intent i = new Intent(HalamanUtama.this, TentangAplikasi.class);
        startActivity(i);
    }
}
