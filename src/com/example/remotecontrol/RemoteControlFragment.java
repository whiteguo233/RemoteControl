package com.example.remotecontrol;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class RemoteControlFragment extends Fragment {
	private TextView mSelectTextView;
	private TextView mWorkingTextView;
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view=inflater.inflate(R.layout.fragment_remote_control,container,false);
		mSelectTextView=(TextView)view.findViewById(R.id.fragment_remote_control_selectedTextView);
		mWorkingTextView=(TextView)view.findViewById(R.id.fragment_remote_control_workingTextView);
		View.OnClickListener numberButtOnClickListener= new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				TextView textView=(TextView)v;
				String working=mWorkingTextView.getText().toString();
				String text=textView.getText().toString();
				if (working.equals("0")) {
					mWorkingTextView.setText(text);
				}else {
					mWorkingTextView.setText(working+text);
				}
			}
		};
		TableLayout tableLayout=(TableLayout)view.findViewById(R.id.fragment_remote_control_tableLayout);
		int number=1;
		for (int i = 2; i < tableLayout.getChildCount()-1; i++) {
			TableRow row=(TableRow)tableLayout.getChildAt(i);
			for (int j = 0; j < row.getChildCount(); j++) {
				Button button=(Button)row.getChildAt(j);
				button.setText(""+number);
				button.setOnClickListener(numberButtOnClickListener);
				number++;
			}
		}
		TableRow bottomrRow=(TableRow)tableLayout.getChildAt(tableLayout.getChildCount()-1);
		Button deleteButton=(Button)bottomrRow.getChildAt(0);
		deleteButton.setText("Delete");
		deleteButton.setTextAppearance(getActivity(), R.style.RemoteButton_textBold);
		deleteButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mWorkingTextView.setText("0");
			}
		});
		Button zeroButton=(Button)bottomrRow.getChildAt(1);
		zeroButton.setText("0");
		zeroButton.setOnClickListener(numberButtOnClickListener);
		Button enterButton=(Button)bottomrRow.getChildAt(2);
		enterButton.setText("Enter");
		enterButton.setTextAppearance(getActivity(), R.style.RemoteButton_textBold);
		enterButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				CharSequence working=mWorkingTextView.getText();
				if (working.length()>0) {
					mSelectTextView.setText(working);
				}
				mWorkingTextView.setText("0");
			}
		});
		return view;
	}

}
