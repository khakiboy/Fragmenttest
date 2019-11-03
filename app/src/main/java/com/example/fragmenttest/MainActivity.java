package com.example.fragmenttest;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    FragmentTransaction transaction;
    Button but1;
    Button but2;
    TextView label;
    FrameLayout fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        but1=findViewById(R.id.but1);
        but2=findViewById(R.id.but2);
        label=findViewById(R.id.main_lable);
        fragment=findViewById(R.id.fragment);
        final Fragment1 fragment1=new Fragment1();
        fragment1.changeText=new ChangeText() {
            @Override
            public void onClick() {
                label.setText("clickshod");
            }
        };
        final Fragment2 fragment2=new Fragment2();
        transaction=getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment,fragment1);
        transaction.commit();
        label.setText("Fragment1");

        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction=getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment,fragment1);
                transaction.commit();
                label.setText("Fragment1");
            }
        });
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction=getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment,fragment2);
                transaction.commit();
                label.setText("Fragment2");
            }
        });


    }
}
