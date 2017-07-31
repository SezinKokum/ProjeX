package com.tatlicilar.proje;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BaseActivity extends AppCompatActivity {

    private ProgressDialog mProgressDialog;

    public void showPressDialog(){
        if(mProgressDialog == null){
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(true);
        }
        mProgressDialog.show();
    }
   public void hideProgressDialog(){
       if(mProgressDialog != null && mProgressDialog.isShowing()){
           mProgressDialog.hide();
       }
   }

   public void onDestroy(){
        super.onDestroy();
       hideProgressDialog();
   }
}
