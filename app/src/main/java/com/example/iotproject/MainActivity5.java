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

public class MainActivity5 extends AppCompatActivity implements SensorEventListener {
    private static final String TAG ="Gyroscope";

    private SensorManager sensorManager;
    private Sensor gyroscope;
    TextView rxValue, ryValue, rzValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        rxValue= (TextView) findViewById(R.id.rx1);
        ryValue= (TextView) findViewById(R.id.rx2);
        rzValue= (TextView) findViewById(R.id.rx3);
        Log.d(TAG,"OnCreate:Initializing Sensor services");
        sensorManager=(SensorManager) getSystemService(Context.SENSOR_SERVICE);
        gyroscope=sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        if(gyroscope!=null){
            sensorManager.registerListener(MainActivity5.this,gyroscope,SensorManager.SENSOR_DELAY_NORMAL);
            Log.d(TAG,"OnCreate: Registered gyroscope Listener");
        }
        else {
            rxValue.setText("Gyroscope not supported");
            ryValue.setText("Gyroscope not supported");
            rzValue.setText("Gyroscope not supported");

        }
    }


    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Log.d(TAG, "OnSensorChanged:x"+sensorEvent.values[0]+"y:"+sensorEvent.values[1]+"z:"+sensorEvent.values[2]);
        rxValue.setText("rxValues"+sensorEvent.values[0]);
        ryValue.setText("ryValues"+sensorEvent.values[1]);
        rzValue.setText("rzValues"+sensorEvent.values[2]);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }


}