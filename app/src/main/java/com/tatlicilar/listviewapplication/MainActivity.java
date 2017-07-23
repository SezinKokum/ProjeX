package com.tatlicilar.listviewapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView ulkeler;
    ArrayAdapter<String> myAdaptyer;
    ArrayList<String> ulkeİsmi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // xml kısmı: android:entries="@array/ulkeler"

        ulkeler= (ListView) findViewById(R.id.lv1);
        ulkeİsmi =new ArrayList<>();
        ulkeİsmi.add("Türkiye");
        ulkeİsmi.add("ABD");
        ulkeİsmi.add("Mısıe");
        // her bir kutuucuk için layout atıyoruz
        myAdaptyer=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ulkeİsmi);//ülkİsiminden al diyoruz
        //layoutlar andraidin kendi içinde superlerin içinde olanlardan create
        ulkeler.setAdapter(myAdaptyer);

        ulkeler.setOnItemClickListener(new AdapterView.OnItemClickListener()){
            public void onItemClick(AdapterView<?> parent, View view,int position,long id){
                Toast.makeText(MainActivity.this, ulkeİsmi.get(position),Toast.LENGTH_SHORT).show();}
        }
    }
};
}
}