package com.demotxt.droidsrce.homedashboard;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

public class Contactus extends AppCompatActivity {

    ImageView close_;
    Dialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.contactus);

        dialog = new Dialog(Contactus.this);
        ImageView call = (ImageView) findViewById(R.id.mobile_image1);
        ImageView mail = (ImageView) findViewById(R.id.mobile_image);

        close_ = findViewById(R.id.close);


        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialContactPhone("+ 91 9543887979");

            }
        });

        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Network_config.is_Network_Connected_flag(getApplicationContext())) {
                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("message/rfc822");
                    i.putExtra(Intent.EXTRA_EMAIL, new String[]{"chennaicivilengineers@gmail.com"});
                    i.putExtra(Intent.EXTRA_SUBJECT, "");
                    i.putExtra(Intent.EXTRA_TEXT, "");
                    try {
                        startActivity(Intent.createChooser(i, "Send mail"));
                    } catch (android.content.ActivityNotFoundException ex) {
                        Toast.makeText(Contactus.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Network_config.customAlert(dialog, getApplicationContext(), getResources().getString(R.string.app_name),
                            getResources().getString(R.string.connection_message));
                }


            }
        });


        close_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Contactus.this, MainActivity.class);
                startActivity(i);
                finish();


            }
        });


    }

    private void dialContactPhone(final String phoneNumber) {
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)));
    }
}