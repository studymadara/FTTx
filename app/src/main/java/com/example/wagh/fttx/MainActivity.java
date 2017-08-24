package com.example.wagh.fttx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {


    //init
    EditText buildingid,pincode,state,district,city,locality,buildingname,flatno;
    Button checkServiceFeasibility;

    String s_buildingid,s_pincode,s_state,s_district,s_city,s_locality,s_buildingname,s_flatno;

    String p_buildingid="\\w{10}";
    String p_pincode,p_state,p_district,p_city,p_locality,p_buildingname,p_flatno;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //binding

        buildingid=(EditText)findViewById(R.id.buildingID);
        pincode=(EditText)findViewById(R.id.pincode);
        state=(EditText)findViewById(R.id.state);
        district=(EditText)findViewById(R.id.district);
        city=(EditText)findViewById(R.id.city);
        locality=(EditText)findViewById(R.id.locality);
        buildingname=(EditText)findViewById(R.id.buildingname);
        flatno=(EditText)findViewById(R.id.flatno);
        checkServiceFeasibility=(Button) findViewById(R.id.checkServiceFeasibility);


        checkServiceFeasibility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startValidation();

                Intent ii = new Intent(MainActivity.this,customeractivity.class);
                startActivity(ii);

            }
        });

    }

    public void startValidation()
    {
        s_buildingid=buildingid.getText().toString();

        Pattern r = Pattern.compile(p_buildingid);

        Matcher rr=r.matcher(s_buildingid);

        if(rr.find())
        {
            Toast.makeText(getApplicationContext(),"Valid Building ID",Toast.LENGTH_LONG).show();

        }
        else
        {
            buildingid.setText("");
            Toast.makeText(getApplicationContext(),"Invalid Building ID",Toast.LENGTH_LONG).show();
        }


    }

}
