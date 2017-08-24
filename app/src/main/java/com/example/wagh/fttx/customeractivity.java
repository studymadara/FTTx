package com.example.wagh.fttx;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONObject;

/**
 * Created by wagh on 24/8/17.
 */

public class customeractivity extends AppCompatActivity {


    EditText CAF;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.customer_layout);

        final Button customerNext;



        customerNext=(Button)findViewById(R.id.customerNextButton);

        CAF=(EditText) findViewById(R.id.CAFNo);

        customerNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent ii = new Intent(customeractivity.this,offerActivity.class);
                startActivity(ii);
            }
        });

        CAF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast toast = Toast.makeText(getApplicationContext(),"Camera open", Toast.LENGTH_SHORT);
                toast.show();

                IntentIntegrator integrator = new IntentIntegrator(customeractivity.this);
                //integrator.setDesiredBarcodeFormats(IntentIntegrator.ONE_D_CODE_TYPES);
                integrator.setPrompt("Scan a barcode");
                //integrator.setResultDisplayDuration(0);
                //integrator.setWide();  // Wide scanning rectangle, may work better for 1D barcodes
                integrator.setCameraId(0);  // Use a specific camera of the device
                integrator.initiateScan();
            }
        });



    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        //retrieve scan result
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);

        if (scanningResult != null) {
            //we have a result

            try
            {
                //JSONObject obj = new JSONObject(scanningResult.getContents());
                String scanContent = scanningResult.toString();
                //String scanFormat = obj.getString("Value");

                // display it on screen
                CAF.setText(scanContent);

            }
            catch (Exception e)
            {

            }


        }else{
            Toast toast = Toast.makeText(getApplicationContext(),"No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
