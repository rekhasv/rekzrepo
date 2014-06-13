package com.rekz.photogallery;


import java.util.Date;

import com.rekz.photocollection.ImageData;

import android.app.Dialog;
import android.app.Fragment;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class GalleryFragment extends Fragment {
	
	private GalleryAdapter mAdapter;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.gallery_frag, container, false);
		GridView gridview = (GridView) view.findViewById(R.id.gallery_grid);
		mAdapter = new GalleryAdapter(getActivity());
		gridview.setAdapter(mAdapter);
		gridview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				launchImageView(position);
			}
		});
		return view;
	}
	

	/*
	 * Launch the grid item as a dialog 
	 */
	protected void launchImageView(int position) {
		
		Dialog dialog = new Dialog(getActivity(),android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        dialog.setContentView(R.layout.image_fulldialog);
        
        // Set the data associated with the grid item
        ImageView imgView = (ImageView) dialog.findViewById(R.id.image_dialog_view);
        ImageData data = (ImageData) mAdapter.getItem(position);
        imgView.setImageBitmap(BitmapFactory.decodeFile(data.getImagePath()));
        
        long dateInMillis = data.getImageDateTaken();
        String dateString = DateFormat.format("MM/dd/yyyy", new Date(dateInMillis)).toString();
        ((TextView) dialog.findViewById(R.id.date_text)).setText(dateString);
        dialog.show();
	}

}
