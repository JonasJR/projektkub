package com.exampel.projektkub;



import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.app.Activity;


public class Cube3D extends Activity {

	private Cubesurfaceview  view;
	private SensorManager sensorManager;
	private Sensor rotationSensor;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        view = new Cubesurfaceview(this, sensorManager, rotationSensor);
        
        setContentView(view);

		sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		rotationSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
	}


	@Override
	protected void onResume() 
	{
		// The activity must call the GL surface view's onResume() on activity onResume().
		super.onResume();
		view.onResume();

		sensorManager.registerListener(view, rotationSensor, SensorManager.SENSOR_DELAY_UI);
	}

	@Override
	protected void onPause() 
	{
		// The activity must call the GL surface view's onPause() on activity onPause().
		super.onPause();
		view.onPause();
	}	

    

    
}
