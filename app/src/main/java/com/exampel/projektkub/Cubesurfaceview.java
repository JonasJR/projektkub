package com.exampel.projektkub;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.GLSurfaceView;
import android.util.Log;
import android.view.MotionEvent;


public class Cubesurfaceview extends GLSurfaceView implements SensorEventListener {

	/*
	float touchedX = 0;
	float touchedY = 0;
	*/
	float[] rMat = new float[4];

	private SensorManager sensorManager;
	private Sensor rotationSensor;

	private Cuberenderer renderer;

	public Cubesurfaceview(Context context, SensorManager sensorManager, Sensor rotationSensor) {
		super(context);
        this.sensorManager = sensorManager;
        this.rotationSensor = rotationSensor;
		setEGLContextClientVersion(2);
        setRenderer(renderer = new Cuberenderer(this));
	}

	/*
	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		if (event.getAction() == MotionEvent.ACTION_DOWN)
		{
			touchedX = event.getX();
			touchedY = event.getY();
		} else if (event.getAction() == MotionEvent.ACTION_MOVE)
		{
			renderer.xAngle += (touchedX - event.getX())/2f;
			renderer.yAngle += (touchedY - event.getY())/2f;
			
			touchedX = event.getX();
			touchedY = event.getY();
		}
		return true;
		
	}
	*/

	@Override
	public void onSensorChanged(SensorEvent event) {
		SensorManager.getQuaternionFromVector(rMat, event.values);
        Log.d("LOG", "onSensorChanged: " + event.values[0] + " " + event.values[1] + " " + event.values[2] );
    }

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {

	}
}