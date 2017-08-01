package com.tatlicilar.proje;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.FacebookSdk;
import com.facebook.login.widget.LoginButton;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.ChildEventListener;
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
    private SignInButton google2;
    private LoginButton facebook2;
    private Button kaydolBtn;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    public static final int RC_SIGN_IN = 1;
    private String mUsername;
    private ChildEventListener mChildEventListener;
    Intent intent, intent2;
    public static final String ANONYMOUS = "anonymous";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        girisBtn = (Button)findViewById(R.id.girisBtn);
        beniHatirla = (CheckBox)findViewById(R.id.beniHatirla);
//        facebook2 = (LoginButton)findViewById(R.id.facebook2);
        google2 = (SignInButton)findViewById(R.id.google2);
        kaydolBtn = (Button)findViewById(R.id.kayitBtn);

        kaydolBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(Login.this, KayitOl.class);
                startActivity(intent);
            }
        });



        google2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent2 = new Intent(Login.this, GoogleSignIn.class);
                startActivity(intent2);
            }

    });

//        facebook2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                intent2 = new Intent(Login.this, GoogleSignIn.class);
//                startActivity(intent2);
//            }
//
//        });
}
}
