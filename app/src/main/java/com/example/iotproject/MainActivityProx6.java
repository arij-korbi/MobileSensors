package com.example.iotproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivityProx6 extends AppCompatActivity implements SensorEventListener {

    private static final String TAG ="Proximity";
    private SensorManager sensorManager;
    private Sensor proximity;
    TextView p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_prox6);
        p= (TextView) findViewById(R.id.p);
        Log.d(TAG,"OnCreate:Initializing Sensor services");
        sensorManager=(SensorManager) getSystemService(Context.SENSOR_SERVICE);
        proximity=sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        if(proximity!=null){
            sensorManager.registerListener(MainActivityProx6.this,proximity,SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG,"OnCreate: Registered  proximitySensor Listener");
        }
        else {
            p.setText("proximitySensor not supported");
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Log.d(TAG, "OnSensorChanged:p"+sensorEvent.values[0]);
        p.setText("proximity: "+sensorEvent.values[0]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}