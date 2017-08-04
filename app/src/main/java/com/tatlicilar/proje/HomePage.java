package com.tatlicilar.proje;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {

    private Button chatBtn;
    private Button egitimBtn;
    Intent intent, intent2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        chatBtn = (Button)findViewById(R.id.chatBtn);
        egitimBtn = (Button)findViewById(R.id.egitimBtn);

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

    }
}
