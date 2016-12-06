package com.anwesome.uiview.rotateupanimdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.anwesome.uiview.rotateupanim.RotateUpAnim;

public class MainActivity extends AppCompatActivity {
    private Button h1,h2;
    private TextView t1;
    private RotateUpAnim rotateUpAnim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rotateUpAnim = new RotateUpAnim(this);
        rotateUpAnim.start();
        h1 = (Button)findViewById(R.id.hello_button);
        h2 = (Button)findViewById(R.id.h2_button);
        t1 = (TextView)findViewById(R.id.hello_text);
        h1.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view) {
                rotateUpAnim.addView(h1);
            }
        });
        h2.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view) {
                rotateUpAnim.addView(h2);
            }
        });
        t1.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view) {
                rotateUpAnim.addView(t1);
            }
        });
    }

}
