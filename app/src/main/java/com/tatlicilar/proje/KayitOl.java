package com.tatlicilar.proje;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.UUID;
public class KayitOl extends AppCompatActivity implements ExpandableListView.OnChildClickListener{

    private static final String TAG = KayitOl.class.getSimpleName();
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    private ChildEventListener mChildEventListener;
    public EditText ad;
    public EditText soyad;
    public EditText password;
    public EditText email;
    private Button kaydol;
    private Button date; // doğum tarihini değiştirmek için buton
    private TextView tarih;//üye ismi ve doğum tarihi bilgisi
    private String userId;
    private String uyelikTuru;
    private int year; // datepickerdaki yıl
    private int month; //datepickerdaki ay
    private int day; //datepickerdaki gün
    private String picker_tarih;
    private ExpandableListAdapter mExpandableListAdapter;
    private ExpandableListView mExpandableListView;
    static final int DATE_DIALOG_ID = 999;

    // Group/parent data
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listDataChild;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit_ol);

        mExpandableListView = (ExpandableListView) findViewById(R.id.explv1);
        // Preparing list data
        prepareListData();
        mExpandableListAdapter = new ExpandableListAdapters(this, listDataHeader, listDataChild);
        // Setting list adapter
        mExpandableListView.setAdapter(mExpandableListAdapter);
        mExpandableListView.setOnChildClickListener(this);

        ad = (EditText) findViewById(R.id.ad);
        soyad = (EditText)findViewById(R.id.soyad);
        password = (EditText)findViewById(R.id.sifre);
        email = (EditText)findViewById(R.id.email);
        kaydol = (Button)findViewById(R.id.kaydol);
        tarih= (TextView) findViewById(R.id.dtarih); //doğum tarihi
        date = (Button)findViewById(R.id.tarihSec);//datepicker ı başlatmak için basılan buton

        tarih.setText("01.01.1990"); //homepage açıldığında önceki classtan gelen bilgileri bu ekranda atıyorum
        //doğum tarhi değiştirme butonuna basıldıysa handle ediyorum
        date.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                showDialog(DATE_DIALOG_ID);
            }
        });


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
        String dtarihi = tarih.getText().toString();

            userId = mDatabaseReference.push().getKey();


        Melek melek = new Melek(add, soyadd, parola, mail,uyelikTuru,dtarihi);

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
// Preparing the list data
private void prepareListData() {
    listDataHeader = new ArrayList<String>();
    listDataChild = new HashMap<String, List<String>>();

    // Adding group/parent data
    listDataHeader.add("Üyelik Türü");

    // Adding child1 data
    List<String> uyelikTuru = new ArrayList<String>();
    uyelikTuru.add("Melek");
    uyelikTuru.add("Aile");
    uyelikTuru.add("Destekçi");
    uyelikTuru.add("Danışman");
    uyelikTuru.add("Admin");

    // Header, Child data
    listDataChild.put(listDataHeader.get(0), uyelikTuru);
}

    @Override
    public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
        TextView mTextView = (TextView) view.findViewById(R.id.tvListItem);

        Toast.makeText(getBaseContext(), mTextView.getText().toString(), Toast.LENGTH_SHORT).show();
        uyelikTuru = mTextView.getText().toString();
        return false;
    }
    //datepicker objesi yaratıyorum
    protected Dialog onCreateDialog(int id){
        if(id == DATE_DIALOG_ID)
            return new DatePickerDialog(this,dpickerListener, year,month,day);
        return null;
    }
    //datepickera basıldıysa handle ediyorum
    //ay bilgisini aldığımda mevcut aydan hep 1 ay az gösterdi o yüzden +1 diyerek kullandım
    private DatePickerDialog.OnDateSetListener dpickerListener
            = new DatePickerDialog.OnDateSetListener(){
        @Override
        public void onDateSet(DatePicker view, int year, int month, int day){
            if ((month+1) < 10){ //eğer ay tek haneli ise başına 0 ekledim
                picker_tarih = day + ".0" + (month+1) + "." + year;
            }
            else{ //ay çift haneli ise olduğu gibi aldım
                picker_tarih = day + "." + (month+1) + "." + year;
            }
            tarih.setText(picker_tarih) ;
        }
    };
}
