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

public class MainActivityHum6 extends AppCompatActivity  implements SensorEventListener {


    private static final String TAG ="Humidity";
    private SensorManager sensorManager;
    private Sensor humidity;
    TextView h;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_hum6);
        h= (TextView) findViewById(R.id.h);
        Log.d(TAG,"OnCreate:Initializing Sensor services");
        sensorManager=(SensorManager) getSystemService(Context.SENSOR_SERVICE);
        humidity =sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
        if(humidity !=null){
            sensorManager.registerListener(MainActivityHum6.this, humidity,SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG,"OnCreate: Registered  proximitySensor Listener");
        }
        else {
            h.setText("Relative Humidity Sensor not supported");
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Log.d(TAG, "OnSensorChanged:p"+sensorEvent.values[0]);
        h.setText("Relative humidity: "+sensorEvent.values[0]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}