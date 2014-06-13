package com.rekz.photocollection;

import java.util.ArrayList;

/*
 * Interface for setting up and downloading images
 */
public interface ImageCollection {
	
	public void initializeSetup();
	public ArrayList<ImageData> getImageData();
   
}
