package com.example.myapplication;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

public class Register_Model {
    private FirebaseAuth Mauth = FirebaseAuth.getInstance();
    private final String Pattern = "^[a-zA-Z0-9._-]+@[a-zA-Z]+(\\.[a-zA-Z]+)+$";

    public boolean is_empty(String email) {
        if(TextUtils.isEmpty(email)){
            return true;
        }
        return false;
    }
    public boolean pattern_match(String email){
        return email.matches(Pattern);
    }

    public boolean password_check_length(String password) {
        return (password.length() >= 6);
    }

    public boolean password_match(String password, String Confirm_Password) {
        return Confirm_Password.equals(password);
    }

    public Task<Boolean> checkIfEmailInUse(String email) {
        return Mauth.fetchSignInMethodsForEmail(email)
                .continueWith(task -> {
                    if (task.isSuccessful()) {
                        // Check if there are sign-in methods associated with the email
                        return !task.getResult().getSignInMethods().isEmpty();
                    } else {
                        // Handle the task failure here
                        Exception exception = task.getException();
                        if (exception instanceof FirebaseAuthException) {
                            // Firebase Authentication exception
                            // Handle specific exceptions here
                        } else {
                            // Other exceptions
                        }
                        return false;
                    }
                });
    }

    public void register_user(String password, String email) {

        Mauth.createUserWithEmailAndPassword(email, password);

    }
}
