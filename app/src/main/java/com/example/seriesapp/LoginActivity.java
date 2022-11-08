package com.example.seriesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private  EditText txemail, txpass;
    private Button brnLong;

    private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPreferences=getSharedPreferences("preferences",MODE_PRIVATE);
        if (sharedPreferences.getBoolean("loged in",false)){
            finish();
            Intent intent= new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
        }
        referenciar();

    }



    private void referenciar() {
        txemail=findViewById(R.id.EditEmail);
        txpass=findViewById(R.id.Editpass);

    }

    public void clickLogin(View view) {
       String email= txemail.getText().toString();
       String password= txpass.getText().toString();
       if (email.equals("pedro@gmail.com")&& password.equals("123456")){
           Intent intent = new Intent(LoginActivity.this,MainActivity.class);
           startActivity(intent);


           SharedPreferences.Editor editor=sharedPreferences.edit();
           editor.putBoolean("loged in", true);
           editor.apply();
           finish();


       }else{
           Toast.makeText(this, R.string.mensajeerror, Toast.LENGTH_SHORT).show();
       }


    }



}