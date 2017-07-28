package com.tatlicilar.proje;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private Button girisBtn;
    private CheckBox beniHatirla;
    private Button facebookBtn;
    private Button googleBtn;
    private Button kaydolBtn;

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        girisBtn = (Button)findViewById(R.id.girisBtn);
        beniHatirla = (CheckBox)findViewById(R.id.beniHatirla);
        facebookBtn = (Button)findViewById(R.id.facebook);
        googleBtn = (Button)findViewById(R.id.google);
        kaydolBtn = (Button)findViewById(R.id.kayitBtn);

        kaydolBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(Login.this, KayitOl.class);
                startActivity(intent);
            }
        });

    }
}
