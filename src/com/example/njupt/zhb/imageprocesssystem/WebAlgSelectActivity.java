package com.example.njupt.zhb.imageprocesssystem;

/*
 *@author: ZhengHaibo
 *web:     blog.csdn.net/nuptboyzhb
 *mail:    zhb931706659@126.com
 *2012-9-11  Nanjing njupt
 */
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/*
 ���ߣ�֣���� 2012-08-12 Email:zhb931706659@126.com
 */
public class WebAlgSelectActivity extends Activity implements
		OnItemClickListener {
	private static final String DYNAMICACTION_Broadcast_WEB = "Broadcast.njupt.zhb.webselectAlg";
	private ListView listView;

	public void sendFlagToActivity(String flag) {
		Intent intent = new Intent();
		intent.setAction(DYNAMICACTION_Broadcast_WEB);
		intent.putExtra("selectFlag", flag);
		sendBroadcast(intent);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("Please keep you WiFi openning and connected to njupt!");
		listView = new ListView(this);
		List<String> list = getData();
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_expandable_list_item_1, list);
		listView.setAdapter(adapter);
		setContentView(listView);
		listView.setOnItemClickListener(this);// �󶨼����ӿ�
	}

	private List<String> getData() {
		List<String> data = new ArrayList<String>();
		data.add("DCT�任");
		data.add("С���任wavelet(9/7 ˫����С����)");
		return data;
	}

	/* ʵ��OnItemClickListener�ӿ� */
	@Override
	public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
		// finish();
		String posString = Integer.toString(position);
		sendFlagToActivity(posString);
		finish();
	}
}
