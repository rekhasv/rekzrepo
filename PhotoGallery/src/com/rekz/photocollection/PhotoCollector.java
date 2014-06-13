package com.rekz.photocollection;

import java.util.ArrayList;

import android.content.Context;

/*
 * Photocollector for getting images
 */
public class PhotoCollector {

	public enum DataSource { EPhoneGallery,
		EInstagram,
		EPicasa,
		EFlickr ,
		ENone
	};

	private final DataSource mDataSource;
	private ImageCollection mCollector = null;
	
	/*
	 * Constructor
	 */
	public PhotoCollector(Context context, DataSource source) {
		mDataSource = source;
		switch (mDataSource) {
		case EPhoneGallery:
			mCollector = new PhoneGalleryCollection(context);
			break;
		case EFlickr:
			mCollector = new FlickrCollection(context);
			break;
		default:
			break;
		}
	}
	/*
	 * Gets an array of imagedata info
	 */
	public ArrayList<ImageData> getImages() {
		if(mCollector != null) {
			mCollector.initializeSetup();
			return mCollector.getImageData();
		}
		return null;
	}

}
