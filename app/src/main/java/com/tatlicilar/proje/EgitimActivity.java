package com.tatlicilar.proje;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class EgitimActivity extends AppCompatActivity implements EgitimAdapter.AdapterListener {

    List<Egitim> egitimList = new ArrayList<>();
    EgitimAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_egitim);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mAdapter = new EgitimAdapter(egitimList,this,this);
        recyclerView.setAdapter(mAdapter);
        RecyclerView.LayoutManager mLayoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        egitimkategorileri();
    }

    private void egitimkategorileri() {
        egitimList.add(new Egitim("Okulöncesi Eğitim Türkçe Oyun","Neval Göksel","Bütün objeler Türkçe seslendirilmiştir.",R.drawable.egitim1,"http://www.letstry-ict.eu/advisor/frontend/index.php?showDetail=1&detail_id=34&search_term=&filter_7_5=1"));
        egitimList.add(new Egitim("Tadya Mutlu Bir Gün","Neval Göksel","Günlük yaşamda kullandığımız nesneleri, eylemleri, sosyal aktiviteleri kapsamlı şekilde öğretimi amaçlar",R.drawable.egitim2,"http://www.letstry-ict.eu/advisor/frontend/index.php?showDetail=1&detail_id=22&search_term=&filter_7_5=1"));
        egitimList.add(new Egitim("Şekiller - Çocuk Oyunu", "Neval Göksel","\tŞekillerin eğlenceli şekilde öğretimi amaçlanmaktadır.",R.drawable.egitim3,"http://www.letstry-ict.eu/advisor/frontend/index.php?showDetail=1&detail_id=23&search_term=&filter_7_5=1"));
        egitimList.add(new Egitim("Kavram Öğretimi", "Neval Göksel","İletişim, akademik ve günlük yaşamda kullanabilecekleri kavramları eğlenceli şekilde öğretmen için tasarlanmıştır.",R.drawable.egitim4,"http://www.letstry-ict.eu/advisor/frontend/index.php?showDetail=1&detail_id=18&search_term=&filter_7_5=1"));
        egitimList.add(new Egitim("Tohum 2", "Neval Göksel","\t4 yaş ve üzeri çocuklar için, nesne fotolarını eşleme, vücut bölümlerini tanıma ve eylemleri tanıma içeren işlevsel uygulamadır.",R.drawable.egitim5,"http://www.letstry-ict.eu/advisor/frontend/index.php?showDetail=1&detail_id=16&search_term=&filter_7_5=1"));

        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClickImage(Egitim egitim) {
        Toast.makeText(this, egitim.getEgitimIsmi(),
                Toast.LENGTH_LONG).show();
    }
    @Override
    public void onClickName(Egitim egitim) {

        Intent newIntent=new Intent(EgitimActivity.this,WebViewActivity.class);
        newIntent.putExtra("url",egitim.getUrl());
        startActivity(newIntent);

    }
}
