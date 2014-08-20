package com.example.njupt.zhb.imageprocesssystem;

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
public class SelectAlgActivity extends Activity implements OnItemClickListener {
	private static final String DYNAMICACTION_Broadcast = "Broadcast.njupt.zhb.selectAlg";
	private ListView listView;

	public void sendFlagToActivity(String flag) {
		Intent intent = new Intent();
		intent.setAction(DYNAMICACTION_Broadcast);
		intent.putExtra("selectFlag", flag);
		sendBroadcast(intent);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("Choose Image processing type!");
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
		data.add("ͼ�����");
		data.add("��ֵ�˲�");
		data.add("ƽ���˲�");
		data.add("�Ҷȴ���");
		data.add("ͼ���ֵ��");
		data.add("ͼ��ȡ��");
		data.add("ͼ����ת90");
		data.add("ֱ��ͼ����");
		data.add("�޲����ݶ�");
		data.add("Sobel�ݶ�");
		data.add("3*3������˹�ݶ�");
		data.add("�Ҷ�ֱ��ͼ");
		data.add("Sobel��ɫ���");
		data.add("Laplace��ɫ���");
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
