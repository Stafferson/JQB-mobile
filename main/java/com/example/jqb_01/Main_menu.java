package com.example.jqb_01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Main_menu extends AppCompatActivity {

    private FirebaseAuth mAuth;
    FirebaseUser user;
    Button bt_test, bt_suggestion, bt_log_out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();

        bt_log_out = findViewById(R.id.button_log_out);
        bt_test = findViewById(R.id.button_tests_main_menu);
        bt_suggestion = findViewById(R.id.button_result);



        SharedPreferences sp = getSharedPreferences("PREF", MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        int a = sp.getInt("test_is_done", 0);
        if (a == 1) {
            bt_suggestion.setClickable(true);
            bt_suggestion.setEnabled(true);
        }
        else {
            bt_suggestion.setClickable(false);
            bt_suggestion.setEnabled(false);
        }
    }

    public void visit_test(View view) {
        if (user.isEmailVerified()) {
            Intent i = new Intent(getApplicationContext(), test1_activity.class);
            startActivity(i);
        }
        else {
            user.sendEmailVerification()
                    .addOnCompleteListener(this, new OnCompleteListener() {
                        @Override
                        public void onComplete(@NonNull Task task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Main_menu.this,
                                        "Verification email sent to " + user.getEmail(),
                                        Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(Main_menu.this,
                                        "Failed to send verification email.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }

    public void log_out(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Are you sure?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                mAuth.signOut();
                Intent j = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(j);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        builder.show();
    }

    public void result_onClick(View view) {
        Intent i = new Intent(getApplicationContext(), Conclusion_Activity.class);
        startActivity(i);
    }
}
