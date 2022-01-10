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

public class MainActivityLum6 extends AppCompatActivity  implements SensorEventListener {
    private static final String TAG ="Light";
    private SensorManager sensorManager;
    private Sensor light;
    TextView l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lum6);
       l= (TextView) findViewById(R.id.l);
        Log.d(TAG,"OnCreate:Initializing Sensor services");
        sensorManager=(SensorManager) getSystemService(Context.SENSOR_SERVICE);
        light=sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        if(light!=null){
            sensorManager.registerListener(MainActivityLum6.this,light,SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG,"OnCreate: Registered LightSensor Listener");
        }
        else {
            l.setText("LightSensor not supported");
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Log.d(TAG, "OnSensorChanged:l"+sensorEvent.values[0]);
        l.setText("light: "+sensorEvent.values[0]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}