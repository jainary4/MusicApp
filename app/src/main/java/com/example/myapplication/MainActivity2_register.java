package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputEditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity2_register extends AppCompatActivity {
    private EditText email_d;
    private EditText password_d;
    private EditText confirm_password_d;
    private Button create_account;
    public FirebaseAuth Mauth= FirebaseAuth.getInstance();
    Register_Model user= new Register_Model();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_register);
        email_d = findViewById(R.id.email_register_customer);
        password_d=findViewById(R.id.password_register_customer);
        confirm_password_d= findViewById(R.id.confirm_password_register_customer);
        String Email = email_d.getText().toString().trim();
        String Password = password_d.getText().toString();
        String Confirm_Password = confirm_password_d.getText().toString();
        create_account = findViewById(R.id.register_customer_button);
        create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(Email);
                register_task(Email,Password,Confirm_Password);
            }
        });

    }
    public void register_task(String email, String password,String confirm_password){
        if(!user.is_empty(email)){
            email_d.setError("Email field cant be empty");
            return;
        }
        if(!user.is_empty(password)){
            password_d.setError("password field cant be empty");
            return;
        }
        if(!user.is_empty(confirm_password)){
            confirm_password_d.setError("confirm password field cant be empty");
            return;
        }

        if(!user.pattern_match(email)){
            Toast.makeText(this,"email is not of the right format", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!user.password_check_length(password)){
            Toast.makeText(this,"password length is less than 6", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!user.password_match(password, confirm_password)){
            Toast.makeText(this,"Confirm password does not match password", Toast.LENGTH_SHORT).show();
            return;
        }
        Mauth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(MainActivity2_register.this, "Account Successfully Created",Toast.LENGTH_SHORT).show();
                 }
                else{
                    Toast.makeText(MainActivity2_register.this, "Error"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}