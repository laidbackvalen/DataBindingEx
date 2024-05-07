package com.example.databindingexample;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.databindingexample.data.User;
import com.example.databindingexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(mainBinding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        User user = new User();
        user.setName("valen");
        user.setEmail("valen.patel1@gmail.com");
        user.setPassword("abc@123");
        mainBinding.setUser(user);


//        CountDownTimer countDownTimer = new CountDownTimer(5000, 1000) {
//            @Override
//            public void onTick(long l) {
//
//            }
//
//            @Override
//            public void onFinish() {
//                user.setName("Kavisha Patel");
//            }
//        };
//        countDownTimer.start();


        mainBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             mainBinding.editText.setText("heehahaha");
            }
        });
    }
}