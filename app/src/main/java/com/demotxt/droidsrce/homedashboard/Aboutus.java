package com.demotxt.droidsrce.homedashboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class Aboutus extends AppCompatActivity {

    ImageView close_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutus);

        close_ = findViewById(R.id.close);

        close_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Aboutus.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}