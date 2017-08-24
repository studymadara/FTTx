package com.example.wagh.fttx;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by wagh on 24/8/17.
 */

public class offerActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.offer_layout);


        Button OfferNext;

        OfferNext=(Button)findViewById(R.id.OfferPageNextButton);

        OfferNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent ii = new Intent(offerActivity.this,paymentActivity.class);
                startActivity(ii);
            }
        });
    }
}

