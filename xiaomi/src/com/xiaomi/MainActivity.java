package com.xiaomi;

import com.xiaomi.phone.PhoneActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Intent intent = new Intent();
		intent.setClass(this, PhoneActivity.class);
		startActivity(intent);
	}
}
