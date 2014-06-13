package com.rekz.photogallery;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		FragmentTransaction trans = getFragmentManager().beginTransaction();
		trans.add(R.id.container, new GalleryFragment());
		//trans.addToBackStack(null);
		trans.commit();
	}
}
