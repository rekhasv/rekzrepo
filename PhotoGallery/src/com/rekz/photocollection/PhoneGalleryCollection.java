package com.rekz.photocollection;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

/*
 * Photocollection for getting images from the phone
 */
public class PhoneGalleryCollection implements ImageCollection {

	private final Context mContext;
	
	
	public PhoneGalleryCollection(Context context) {
		mContext = context;
	}

	@Override
	public void initializeSetup() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<ImageData> getImageData() {
		return getImagesFromGallery();
	}

	private ArrayList<ImageData> getImagesFromGallery() {
		
		String[] projection = { MediaStore.Images.Media._ID, MediaStore.Images.Media.DATA, MediaStore.Images.Media.DATE_TAKEN , MediaStore.Images.Media.LONGITUDE, MediaStore.Images.Media.LATITUDE };
		String orderBy = MediaStore.Images.Media._ID;
		Cursor cursor = mContext.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, projection, null, null, orderBy);
		
		if(cursor != null && cursor.getCount() != 0) {
			ArrayList<ImageData> pathList = new ArrayList<ImageData>();
			cursor.moveToFirst();
			do{
				ImageData data = new ImageData();
				data.setImagePath(cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA)));
				/*data.setImageDateTaken(cursor.getString(cursor
                        .getColumnIndex(MediaStore.Images.Media.DATE_TAKEN)));*/
				
				long dateinMillis = cursor.getLong(cursor.getColumnIndex(MediaStore.Images.Media.DATE_TAKEN));
				data.setImageDateTaken(dateinMillis);
				data.setLongitude(cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.LONGITUDE)));
				data.setLatiTude(cursor.getString(cursor
                        .getColumnIndex(MediaStore.Images.Media.LATITUDE)));
				pathList.add(data);
			} while(cursor.moveToNext());
			
			return pathList;
		}
		return null;
	}

}
