package com.demotxt.droidsrce.homedashboard;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class Chennai_zone extends AppCompatActivity {

    public ArrayList<offers_model> countries_lang = new ArrayList<offers_model>();
    Button north, south, central;
    String status;
    Adapter_card_listview adapt;

    ListView lv;
    Dialog dialog;
    ImageView close_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zone_wise);
        dialog = new Dialog(getApplicationContext());
        north = findViewById(R.id.north);
        south = findViewById(R.id.south);
        central = findViewById(R.id.central);

        close_ = findViewById(R.id.close);

        close_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Chennai_zone.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        north.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Network_config.is_Network_Connected_flag(getApplicationContext())) {
                    Intent i = new Intent(Chennai_zone.this, Zonewise_list.class);
                    i.putExtra("zone", "north");
                    startActivity(i);
                } else {
                    Network_config.customAlert(dialog, getApplicationContext(), getResources().getString(R.string.app_name),
                            getResources().getString(R.string.connection_message));
                }


            }
        });

        south.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Network_config.is_Network_Connected_flag(getApplicationContext())) {
                    Intent i = new Intent(Chennai_zone.this, Zonewise_list.class);
                    i.putExtra("zone", "south");
                    startActivity(i);
                } else {
                    Network_config.customAlert(dialog, getApplicationContext(), getResources().getString(R.string.app_name),
                            getResources().getString(R.string.connection_message));
                }


            }
        });

        central.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Network_config.is_Network_Connected_flag(getApplicationContext())) {
                    Intent i = new Intent(Chennai_zone.this, Zonewise_list.class);
                    i.putExtra("zone", "central");
                    startActivity(i);
                } else {
                    Network_config.customAlert(dialog, getApplicationContext(), getResources().getString(R.string.app_name),
                            getResources().getString(R.string.connection_message));
                }


            }
        });
    }
}