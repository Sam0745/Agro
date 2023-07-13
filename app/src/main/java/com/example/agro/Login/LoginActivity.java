package com.example.agro.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.agro.Activities.MainActivity;
import com.example.agro.Session.SessionManagement;
import com.example.agro.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding loginXml;
    SharedPreferences sharedPreferences;
    SessionManagement sessionManagement;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginXml=ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(loginXml.getRoot());

        loginXml.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkValidation();
            }
        });

    }

    private void checkValidation() {

        sharedPreferences=getSharedPreferences("myPref",MODE_PRIVATE);
        sharedPreferences=getSharedPreferences("User",MODE_PRIVATE);
        sharedPreferences=getSharedPreferences("Email",MODE_PRIVATE);
        sharedPreferences=getSharedPreferences("PassWord",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();

            if (loginXml.etLoginEmail.getText().toString().isEmpty()||!loginXml.etLoginEmail.getText().toString().contains("@")){

                if (loginXml.etLoginEmail.getText().toString().isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Enter your Email Id", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "Enter valid Email", Toast.LENGTH_SHORT).show();
                }
            }else if (loginXml.etLoginPassword.getText().toString().isEmpty() || loginXml.etLoginPassword.getText().toString().length() < 7)
                if (loginXml.etLoginPassword.getText().toString().isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Enter the Password", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "Your Password must be 7 character ", Toast.LENGTH_SHORT).show();
                }
            else {
                sessionManagement = new SessionManagement(LoginActivity.this);
                sessionManagement.SaveEmail(loginXml.etLoginEmail.getText().toString());
                Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }




    }
}