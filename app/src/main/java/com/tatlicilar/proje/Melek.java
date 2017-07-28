package com.tatlicilar.proje;

/**
 * Created by sezinkokum on 27.07.2017.
 */

public class Melek {

    private String uid;
    private String ad;
    private String soyad;
    private String parola;
    private String email;
    private String uyelikTuru;
    private String tarih;
//    private String uyelikTuru;
//    private String tarih;
//    private int resim;

    public Melek() {
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public Melek(String ad, String soyad, String parola, String email, String uyelikTuru, String tarih ) {
//        String uyelikTuru, String tarih, int resim, String url,
        this.uid = uid;
        this.ad = ad;
        this.soyad = soyad;
        this.parola = parola;
        this.email = email;
        this.uyelikTuru = uyelikTuru;
        this.tarih = tarih;

//        this.uyelikTuru = uyelikTuru;
//        this.tarih = tarih;
//        this.resim = resim;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public String getUyelikTuru() {
//        return uyelikTuru;
//    }
//
//    public void setUyelikTuru(String uyelikTuru) {
//        this.uyelikTuru = uyelikTuru;
//    }
//

    public String getUyelikTuru() {
        return uyelikTuru;
    }

    public void setUyelikTuru(String uyelikTuru) {
        this.uyelikTuru = uyelikTuru;
    }

//    public String getTarih() {
//        return tarih;
//    }
//
//    public void setTarih(String tarih) {
//        this.tarih = tarih;

//    public int getResim() {
//        return resim;
//    }
//
//    public void setResim(int resim) {
//        this.resim = resim;
//    }
//

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
