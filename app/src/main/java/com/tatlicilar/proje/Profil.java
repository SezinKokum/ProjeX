package com.tatlicilar.proje;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Profil extends AppCompatActivity {

    private static int RESULT_LOAD_IMAGE = 1;
    private Button degistirBtn;
    private Button acilBtn;
    private Button paylasilanlarBtn;
    private Button mesajlarBtn;
    private Intent intent, intent2,intent3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        degistirBtn = (Button)findViewById(R.id.resimdegistirBtn);
        acilBtn = (Button)findViewById(R.id.acilBtn);
        paylasilanlarBtn = (Button)findViewById(R.id.paylasilanBtn);
        mesajlarBtn =(Button)findViewById(R.id.mesajlarBtn);
        degistirBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, RESULT_LOAD_IMAGE);

            }
        });
        acilBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        paylasilanlarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent2 = new Intent(Profil.this, HomePage.class);
                startActivity(intent2);
            }
        });

        mesajlarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent3 = new Intent(Profil.this, ChatActivity.class);
                startActivity(intent3);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ImageView image2 = (ImageView) findViewById(R.id.profilResmi);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            image2.setImageURI(selectedImage); //profil fotoğrafına set ediyorum
        }
    }
}
