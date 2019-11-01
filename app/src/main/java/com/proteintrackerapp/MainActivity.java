package com.proteintrackerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnSetting = (Button) findViewById(R.id.btnsetting);
        btnSetting.setOnClickListener(btnsetting);
        SharedPreferences prefs = MainActivity.this.getSharedPreferences("prefs_file",MODE_PRIVATE);

        String statusLogin = prefs.getString("isLogin",null);
        Button btnlogin = (Button)findViewById(R.id.btnlogin);
        btnlogin.setOnClickListener(myBtnLoginClick);

        if (statusLogin != null){     btnlogin.setText("Logout"); }
        else{
            btnlogin.setText("login"); }
    }


    private View.OnClickListener btnsetting = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, Setting.class);
            startActivity(intent);
        }

        ;
    };

    private View.OnClickListener myBtnLoginClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences prefs = MainActivity.this.getSharedPreferences("prefs_file", MODE_PRIVATE);

            String statusLogin = prefs.getString("isLogin", null);
            SharedPreferences.Editor edit = prefs.edit();

            Button btnLogin = (Button) findViewById(R.id.btnlogin);
            if (statusLogin != null) {
                edit.putString("isLogin", null);
                btnLogin.setText("Login");
            } else {
                edit.putString("isLogin", "Admin");
                btnLogin.setText("Logout");
            }
            edit.commit();
        }
    };
}

