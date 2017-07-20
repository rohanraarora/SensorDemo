package in.codingninjas.sensordemo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.hardware.Sensor.TYPE_ACCELEROMETER;
import static android.hardware.Sensor.TYPE_ALL;
import static android.hardware.Sensor.TYPE_LIGHT;
import static android.provider.MediaStore.ACTION_IMAGE_CAPTURE;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager mSensorManager;
    ImageView imageView;

    private static final int REQUEST_IMAGE_CAPTURE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        SensorManager sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
//
//        Sensor accSensor = sensorManager.getDefaultSensor(TYPE_ACCELEROMETER);

        //sensorManager.registerListener(this,accSensor,SensorManager.SENSOR_DELAY_NORMAL);

//        Sensor lightSensor = sensorManager.getDefaultSensor(TYPE_LIGHT);
//
//        if(lightSensor!= null){
//            sensorManager.registerListener(this,lightSensor,SensorManager.SENSOR_DELAY_NORMAL);
//
//        }
//        List<Sensor> sensors = sensorManager.getSensorList(TYPE_ALL);
//        for(Sensor sensor: sensors){
//            Log.d("sensor",sensor.getName());
//        }

        imageView = (ImageView) findViewById(R.id.imageView);


    }

    public void openCamera(View view){
        Intent takePictureIntent = new Intent();
        takePictureIntent.setAction(ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePictureIntent,REQUEST_IMAGE_CAPTURE);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

//        float lux = sensorEvent.values[0];
//
//        textView.setText(lux + "lx");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK && data!=null){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(bitmap);

        }
    }
}
