package com.example.iotproject;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    Accelerometer accelerometer;
    TextView tx1,tx2,tx3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        accelerometer= new Accelerometer(this);
        tx1= findViewById(R.id.tx1);
        tx2= findViewById(R.id.tx2);
        tx3= findViewById(R.id.tx3);
        tx1.setText("X = "+accelerometer.x);
        tx2.setText("Y = "+accelerometer.y );
        tx3.setText("Z = "+accelerometer.z );
        accelerometer.setListener(new Accelerometer.Listener() {
            @Override
            public void onTranslation(float tx, float ty, float tz) {
                accelerometer.x= accelerometer.x+tx;
                accelerometer.x= accelerometer.x+ty;
                accelerometer.x= accelerometer.x+tz;

                tx1.setText("X = "+accelerometer.x);
                tx2.setText("Y = "+accelerometer.y );
                tx3.setText("Z = "+accelerometer.z );

            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();
        accelerometer.register();
    }

    @Override
    protected void onPause() {
        super.onPause();
        accelerometer.unregister();
    }
}
