package com.tatlicilar.proje;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {

    private Button chatBtn;
    private Button egitimBtn;
    private Button profilBtn;
    Intent intent, intent2, intent3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        chatBtn = (Button)findViewById(R.id.chatBtn);
        egitimBtn = (Button)findViewById(R.id.egitimBtn);
        profilBtn= (Button)findViewById(R.id.profilBtn);
        chatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(HomePage.this, ChatActivity.class);
                startActivity(intent);
            }

        });

        egitimBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent2 = new Intent(HomePage.this, EgitimActivity.class);
                startActivity(intent2);
            }

        });

        profilBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent3 = new Intent(HomePage.this, Profil.class);
                startActivity(intent3);
            }

        });
    }
}
