package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity_login extends AppCompatActivity {
   public  Button create_account;
   private EditText email;
   private EditText password;
   public Button login;
   FirebaseAuth fAuth;
   Login_Model model = new Login_Model();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);
        email=  findViewById(R.id.email_customer_login);
        password = findViewById(R.id.password_customer_login);
        login = findViewById(R.id.login_customer_button);
        fAuth  = FirebaseAuth.getInstance();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Email = email.getText().toString().trim();
                String Password = email.getText().toString().trim();
                if(model.is_empty(Email)){
                    email.setError("Email field cant be empty");
                    return;
                }
                if(model.is_empty(Password)){
                    password.setError("password field cant be empty");
                    return;
                }
                if(model.pattern_match(Email)){
                    email.setError("Email format is wrong");
                    return;
                }
                if(model.password_check_length(Password)){
                    password.setError("Wrong password");
                    return;
                }
                fAuth.signInWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){

                        }
                        else{
                            Toast.makeText(MainActivity_login.this, "Error in logging in", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

        create_account = findViewById(R.id.register_customer_button);
        create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity_login.this, MainActivity_Sections.class);
                startActivity(intent);
            }
        });


    }

}