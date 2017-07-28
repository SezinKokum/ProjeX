package com.tatlicilar.proje;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.UUID;
public class KayitOl extends AppCompatActivity {

    private static final String TAG = KayitOl.class.getSimpleName();
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    private ChildEventListener mChildEventListener;
    public EditText ad;
    public EditText soyad;
    public EditText password;
    public EditText email;
    private Button kaydol;
    private String userId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit_ol);
        ad = (EditText) findViewById(R.id.ad);
        soyad = (EditText)findViewById(R.id.soyad);
        password = (EditText)findViewById(R.id.sifre);
        email = (EditText)findViewById(R.id.email);
        kaydol = (Button)findViewById(R.id.kaydol);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference("users");

        kaydol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: Send messages on click
                    createUser();
            }
        });

//        mChildEventListener = new ChildEventListener() {
//
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                // ne zaman yeni mesaj eklenirse tetiklenecek
//                //giden mesajı alır friendlymessage objesine çevirir ve adapter e ekler ve listviewde basılacak
//                Melek melek = dataSnapshot.getValue(Melek.class); // onjeyi deserialize edecek
////                mMessageAdapter.add(friendlyMessage);
//            }
//
//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//                //var olan mesajın contenti değiştiğinde tetiklenecek
//            }
//
//            @Override
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
//                //var olan mesaj silindiğinde tetiklenecek
//            }
//
//            @Override
//            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//                //mesajdakiler pozisyon değiştirirse tetiklenecek
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                //değişiklik yaparken hata oluşursa tetiklenecek
//            }
//        };
//
//        mDatabaseReference.addChildEventListener(mChildEventListener);
    }
    private void createUser() {
        // TODO
        // In real apps this userId should be fetched
        // by implementing firebase auth
        String add = ad.getText().toString();
        String soyadd = soyad.getText().toString();
        String parola = password.getText().toString();
        String mail = email.getText().toString();

            userId = mDatabaseReference.push().getKey();


        Melek melek = new Melek(add, soyadd, parola, mail);

        mDatabaseReference.child(userId).setValue(melek);

        addUserChangeListener();
    }
    /**
     * User data change listener
     */
    private void addUserChangeListener() {
        // User data change listener
        mDatabaseReference.child(userId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Melek melek = dataSnapshot.getValue(Melek.class);

                // Check for null
                if (melek == null) {
                    Log.e(TAG, "User data is null!");
                    return;
                }

                Log.e(TAG, "User data is changed!" + melek.getAd() + ", " + melek.getEmail());

//                // clear edit text
//                mail.setText("");
//                add.setText("");

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.e(TAG, "Failed to read user", error.toException());
            }
        });
    }
//    private void updateUser(String ad,String soyad, String password, String email) {
//        // updating the user via child nodes
//        if (!TextUtils.isEmpty(ad))
//            mDatabaseReference.child(userId).child("ad").setValue(ad);
//        if (!TextUtils.isEmpty(soyad))
//            mDatabaseReference.child(userId).child("soyad").setValue(soyad);
//        if (!TextUtils.isEmpty(password))
//            mDatabaseReference.child(userId).child("password").setValue(password);
//        if (!TextUtils.isEmpty(email))
//            mDatabaseReference.child(userId).child("email").setValue(email);
//    }
}
