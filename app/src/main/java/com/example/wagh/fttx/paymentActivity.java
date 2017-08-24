package com.example.wagh.fttx;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by wagh on 24/8/17.
 */

public class paymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.payment_layout);


        Button Submit;

        Submit=(Button)findViewById(R.id.SubmitButton);

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(getApplicationContext(),"Preview Phase Ends Here XD",Toast.LENGTH_LONG).show();
            }
        });
    }
}
