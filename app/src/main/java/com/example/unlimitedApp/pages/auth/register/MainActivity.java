package com.example.unlimitedApp.pages.auth.register;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.unlimitedApp.HomePageActivity;
import com.example.unlimitedApp.R;
import com.example.unlimitedApp.models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView login_btn,without_login_btn;

    EditText fullName, age, email, password, confirmPassword;

    private FirebaseAuth mAuth;

    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pages_register_activity);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            startActivity(new Intent(MainActivity.this, HomePageActivity.class));
        }



        //set back button (back to login page)
        login_btn = (TextView) findViewById(R.id.register_btn);
        login_btn.setLinksClickable(true);
        // go to login page without login
        without_login_btn = (TextView) findViewById(R.id.without_login_btn);
        without_login_btn.setLinksClickable(true);

        //set form inputs
        fullName = (EditText) findViewById(R.id.fullName);
        age = (EditText) findViewById(R.id.age);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        confirmPassword = (EditText) findViewById(R.id.confirmPassword);
        register = (Button) findViewById(R.id.register);
        register.setOnClickListener(this);

        login_btn.setOnClickListener(this);
        without_login_btn.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register_btn:
                startActivity(new Intent(v.getContext(), com.example.unlimitedApp.pages.auth.login.MainActivity.class));
                break;
            case R.id.without_login_btn:
                startActivity(new Intent(v.getContext(), com.example.unlimitedApp.HomePageActivity.class));
                break;
            case R.id.register:
                registerUser();
                break;
        }
    }

    private void registerUser() {

        String fullName = this.fullName.getText().toString();
        String age = this.age.getText().toString();
        String email = this.email.getText().toString();
        String password = this.password.getText().toString();
        String confirmPassword = this.confirmPassword.getText().toString();
        // get current activity
        if (fullName.isEmpty()) {
            this.fullName.setError(getString(R.string.error_field_fullname_required));
            this.fullName.requestFocus();
            return;
        }
        if (age.isEmpty()) {
            this.age.setError(getString(R.string.error_field_age_required));
            this.age.requestFocus();
            return;
        }
        if (email.isEmpty()) {
            this.email.setError(getString(R.string.error_field_email_required));
            this.email.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            this.password.setError(getString(R.string.error_field_password_required));
            this.password.requestFocus();
            return;
        }
        if (confirmPassword.isEmpty()) {
            this.confirmPassword.setError(getString(R.string.error_field_confirm_password_required));
            this.confirmPassword.requestFocus();
            return;
        }

        if (!password.equals(confirmPassword)) {
            this.confirmPassword.setError(getString(R.string.error_field_confirm_password_not_match));
            this.confirmPassword.requestFocus();
            return;
        }

        if (age.length() > 2) {
            this.age.setError(getString(R.string.error_field_age_length2_invalid));
            this.age.requestFocus();
            return;
        }

        if (email.length() > 30) {
            this.email.setError(getString(R.string.error_field_email_length_invalid));
            this.email.requestFocus();
            return;
        }

        if(!(email.contains("@") && email.contains("."))) {
            this.email.setError(getString(R.string.error_field_email_invalid));
            this.email.requestFocus();
            return;
        }

        if (password.length() > 30) {
            this.password.setError(getString(R.string.error_field_password_length_invalid));
            this.password.requestFocus();
            return;
        }

        // make register disable
        register.setEnabled(false);
        register.setText(getString(R.string.register_btn_loading));
        //create user and save it to firebase

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Integer intAge = Integer.parseInt(age);
                            User user = new User(fullName, email, password, intAge);
                            FirebaseDatabase database = FirebaseDatabase.getInstance();
                            DatabaseReference myRef = database.getReference("users");
                            myRef.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                               @Override
                               public void onComplete(@NonNull Task<Void> task) {
                                   if (task.isSuccessful()) {

                                       Toast.makeText(MainActivity.this, getString(R.string.User_created_successfully), Toast.LENGTH_SHORT).show();
                                       // Sign in success, update UI with the signed-in user's information
                                       FirebaseUser fUser = FirebaseAuth.getInstance().getCurrentUser();
                                       Intent intent = new Intent(MainActivity.this, HomePageActivity.class);
                                       startActivity(intent);
                                       finish();

                                   }else{
                                       Toast.makeText(MainActivity.this, getString(R.string.error_is)+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                   }

                                   register.setEnabled(true);
                                   register.setText(getString(R.string.pages_register_button));
                               }
                            });

                        }else{
                            // If sign in fails, display a message to the user.
                            Toast.makeText(MainActivity.this, getString(R.string.Authentication_failed), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

}