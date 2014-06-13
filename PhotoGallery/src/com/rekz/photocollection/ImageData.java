package com.rekz.photocollection;

/*
 * Data fields for an image
 */
public final class ImageData {

	private String mImagePath = null;
	private long mDateTaken = 0;
	private String mLongitude = null;
	private String mLatiTude = null;

	
	public String getImagePath() {
		return mImagePath;
	}
	public long getImageDateTaken() {
		return mDateTaken;
	}
	public String getLongitude() {
		return mLongitude;
	}
	public String getLatiTude() {
		return mLatiTude;
	}
	public void setImagePath(String arg) {
		mImagePath = arg;
	}
	public void setImageDateTaken(long arg) {
		mDateTaken = arg;
	}
	public void setLongitude(String arg) {
		mLongitude = arg;
	}
	public void setLatiTude(String arg) {
		mLatiTude = arg;
	}

}
