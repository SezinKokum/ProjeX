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

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
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
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

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

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            private static final String TAG = "GoogleActivity";
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };
        kaydolBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(Login.this, KayitOl.class);
                startActivity(intent);
            }
        });

        googleBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
            public void onClick(View view) {

            }
//                // [START config_signin]
//                // Configure Google Sign In
//                GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                        .requestIdToken(getString(R.string.default_web_client_id))
//                        .requestEmail()
//                        .build();
//                // [END config_signin]
//
//                mGoogleApiClient = new GoogleApiClient.Builder(this)
//                        .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
//                        .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
//                        .build();
//
//                // [START initialize_auth]
//                mAuth = FirebaseAuth.getInstance();
//                // [END initialize_auth]
//            }
//
//            // [START on_start_check_user]
//            @Override
//            public void onStart() {
//                super.onStart();
//                // Check if user is signed in (non-null) and update UI accordingly.
//                FirebaseUser currentUser = mAuth.getCurrentUser();
//                updateUI(currentUser);
//            }
//            // [END on_start_check_user]
//
//            // [START onactivityresult]
//            @Override
//            public void onActivityResult(int requestCode, int resultCode, Intent data) {
//                super.onActivityResult(requestCode, resultCode, data);
//
//                // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
//                if (requestCode == RC_SIGN_IN) {
//                    GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
//                    if (result.isSuccess()) {
//                        // Google Sign In was successful, authenticate with Firebase
//                        GoogleSignInAccount account = result.getSignInAccount();
//                        firebaseAuthWithGoogle(account);
//                    } else {
//                        // Google Sign In failed, update UI appropriately
//                        // [START_EXCLUDE]
//                        updateUI(null);
//                        // [END_EXCLUDE]
//                    }
//                }
//            }
//            // [END onactivityresult]
//
//            // [START auth_with_google]
//            private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
//                Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());
//                // [START_EXCLUDE silent]
//                showProgressDialog();
//                // [END_EXCLUDE]
//
//                AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
//                mAuth.signInWithCredential(credential)
//                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                            @Override
//                            public void onComplete(@NonNull Task<AuthResult> task) {
//                                if (task.isSuccessful()) {
//                                    // Sign in success, update UI with the signed-in user's information
//                                    Log.d(TAG, "signInWithCredential:success");
//                                    FirebaseUser user = mAuth.getCurrentUser();
//                                    updateUI(user);
//                                } else {
//                                    // If sign in fails, display a message to the user.
//                                    Log.w(TAG, "signInWithCredential:failure", task.getException());
//                                    Toast.makeText(GoogleSignInActivity.this, "Authentication failed.",
//                                            Toast.LENGTH_SHORT).show();
//                                    updateUI(null);
//                                }
//
//                                // [START_EXCLUDE]
//                                hideProgressDialog();
//                                // [END_EXCLUDE]
//                            }
//                        });
//            }
//            // [END auth_with_google]
//
//            // [START signin]
//            private void signIn() {
//                Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
//                startActivityForResult(signInIntent, RC_SIGN_IN);
//            }
//            // [END signin]
//
//            private void signOut() {
//                // Firebase sign out
//                mAuth.signOut();
//
//                // Google sign out
//                Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(
//                        new ResultCallback<Status>() {
//                            @Override
//                            public void onResult(@NonNull Status status) {
//                                updateUI(null);
//                            }
//                        });
//            }
//
//            private void revokeAccess() {
//                // Firebase sign out
//                mAuth.signOut();
//
//                // Google revoke access
//                Auth.GoogleSignInApi.revokeAccess(mGoogleApiClient).setResultCallback(
//                        new ResultCallback<Status>() {
//                            @Override
//                            public void onResult(@NonNull Status status) {
//                                updateUI(null);
//                            }
//                        });
//            }
//
//            private void updateUI(FirebaseUser user) {
//                hideProgressDialog();
//                if (user != null) {
//                    mStatusTextView.setText(getString(R.string.google_status_fmt, user.getEmail()));
//                    mDetailTextView.setText(getString(R.string.firebase_status_fmt, user.getUid()));
//
//                    findViewById(R.id.sign_in_button).setVisibility(View.GONE);
//                    findViewById(R.id.sign_out_and_disconnect).setVisibility(View.VISIBLE);
//                } else {
//                    mStatusTextView.setText(R.string.signed_out);
//                    mDetailTextView.setText(null);
//
//                    findViewById(R.id.sign_in_button).setVisibility(View.VISIBLE);
//                    findViewById(R.id.sign_out_and_disconnect).setVisibility(View.GONE);
//                }
//            }
//
//            @Override
//            public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
//                // An unresolvable error has occurred and Google APIs (including Sign-In) will not
//                // be available.
//                Log.d(TAG, "onConnectionFailed:" + connectionResult);
//                Toast.makeText(this, "Google Play Services error.", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onClick(View v) {
//                int i = v.getId();
//                if (i == R.id.sign_in_button) {
//                    signIn();
//                } else if (i == R.id.sign_out_button) {
//                    signOut();
//                } else if (i == R.id.disconnect_button) {
//                    revokeAccess();
//                }
//            }
//            }
//        }
//
//    @Override
//    public void onClick(View view) {
//
//    }
//
//    @Override
//    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
//
//    });
//
//    // [START on_start_check_user]
//    @Override
//    public void onStart() {
//        super.onStart();
//        // Check if user is signed in (non-null) and update UI accordingly.
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        updateUI(currentUser);
//    }

    });
}
}
