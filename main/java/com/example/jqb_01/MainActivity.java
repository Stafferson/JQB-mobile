package com.example.jqb_01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText ed_gmail, ed_password;
    private FirebaseAuth mAuth;
    String text_gmail, text_password;
    FirebaseUser user;
    TextView tv1;

    @Override
    public void onStart() {
        super.onStart();
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            Intent i = new Intent(this, Main_menu.class);
            startActivity(i);
        }
        /*SharedPreferences sp = getPreferences(MODE_PRIVATE);
        int a = sp.getInt("is_logged", 0);
        if (a == 1) {
            Intent i = new Intent(this, Main_menu.class);
            startActivity(i);
        }*/
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();

        ed_gmail = findViewById(R.id.editText_gmail);
        ed_password = findViewById(R.id.editText_password);
        tv1 = findViewById(R.id.textView_password_forgot);
    }
    public void sign_in(View view) {
        text_gmail = ed_gmail.getText().toString();
        text_password = ed_password.getText().toString();
        if (text_password.isEmpty() || text_gmail.isEmpty()){
            Toast.makeText(MainActivity.this, "Please write your email and password",
                    Toast.LENGTH_SHORT).show();
        }
        else {
            mAuth.signInWithEmailAndPassword(text_gmail, text_password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                /*SharedPreferences sp = getPreferences(MODE_PRIVATE);
                                SharedPreferences.Editor ed = sp.edit();
                                ed.putInt("is_logged", 1);
                                ed.putInt("islogged1", 0);
                                ed.apply();*/
                                Intent i = new Intent(getApplicationContext(), Main_menu.class);
                                startActivity(i);
                            } else {
                                Toast.makeText(MainActivity.this, "Error",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }

    public void login(View view) {
        text_gmail = ed_gmail.getText().toString();
        text_password = ed_password.getText().toString();
        if (text_password.isEmpty() || text_gmail.isEmpty()){
            Toast.makeText(MainActivity.this, "Please write your email and password",
                    Toast.LENGTH_LONG).show();
        }
        else if (text_password.length() < 4){
            Toast.makeText(MainActivity.this, "Lenght < 4",
                    Toast.LENGTH_SHORT).show();
        }
        else {
            mAuth.createUserWithEmailAndPassword(text_gmail, text_password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Toast.makeText(MainActivity.this, "Account created.",
                                        Toast.LENGTH_SHORT).show();
                                //startActivity(i);
                                FirebaseUser user = mAuth.getCurrentUser();
                                ed_gmail.setText("");
                                ed_password.setText("");
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(MainActivity.this, "Error.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }

    public void forgot_onCLick(View view) {
        //Toast.makeText(MainActivity.this, "Write your email to sent the message",
                //Toast.LENGTH_LONG).show();
        text_gmail = ed_gmail.getText().toString();
        String a = text_gmail;
        if (a == "" || a.isEmpty() || !a.contains("@")) {
            Toast.makeText(MainActivity.this, "Write your email to sent the message",
                    Toast.LENGTH_LONG).show();
        }
        else {
            FirebaseAuth.getInstance().sendPasswordResetEmail(a)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(MainActivity.this, "Message sent",
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                    });
        }
    }
}
