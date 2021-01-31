package com.example.jqb_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Conclusion_Activity extends AppCompatActivity {

    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conclusion_);

        SharedPreferences sp = getSharedPreferences("PREF", Context.MODE_PRIVATE);

        tv1 = findViewById(R.id.textView_suggestions);

        int a = sp.getInt("amount", 99);
        Log.d("mLog", String.valueOf(a));

        String absolute = sp.getString("absolute", "duck");
        Log.d("mLog", sp.getString("absolute", "joe111111111111111111111111111111111"));
        tv1.setText(absolute);
        //String[] arr = new String[25];
        //for (int i = 0; i < a; i++) {
        //    arr[i] = sp.getString("profession" + i, "joe");
        //}

        //for (int j = 0; j < a; j++) {
        //    Log.d("mLog", sp.getString("professions" + j, "joe1"));
        //}

    }
}
