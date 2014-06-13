package com.rekz.photogallery;

import java.util.ArrayList;

import com.rekz.photocollection.ImageData;
import com.rekz.photocollection.PhotoCollector;
import com.rekz.photocollection.PhotoCollector.DataSource;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class GalleryAdapter extends BaseAdapter {

	//private final ArrayList<String> mImagePathList;
	private final ArrayList<ImageData> mImagePathList;
	private final Context mContext;
	public GalleryAdapter(Context context) {
		mContext = context;
		PhotoCollector collector = new PhotoCollector(context, DataSource.EPhoneGallery);
		mImagePathList = collector.getImages();
	}
	@Override
	public int getCount() {
		return mImagePathList.size();
	}

	@Override
	public Object getItem(int arg0) {
		return mImagePathList.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int pos, View view, ViewGroup parent) {
		View convertView = ((LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.image_item, parent, false);
		
		ImageView imageView = (ImageView) convertView.findViewById(R.id.gal_image);
		imageView.setImageBitmap(BitmapFactory.decodeFile(mImagePathList.get(pos).getImagePath()));
		return convertView;
	}
	
}
/*public class GalleryAdapter extends CursorAdapter{

	private final Context mContext; 
	
	public GalleryAdapter(Context context, Cursor c, int flags) {
		super(context, c, flags);
		mContext = context;
	}

	@Override
	public void bindView(View view, Context context, Cursor cursor) {
		
		int column = cursor.getColumnIndex(MediaStore.Images.Media.DATA);
		String path = cursor.getString(column);
		ImageView imageView = (ImageView) view.findViewById(R.id.gal_image);
		imageView.setImageBitmap(BitmapFactory.decodeFile(path));
		
	}

	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {
		View convertView = ((LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.image_item, parent, false);
		return convertView;
	}
	
}*/