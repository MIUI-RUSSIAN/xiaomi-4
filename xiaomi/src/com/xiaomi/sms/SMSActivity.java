package com.xiaomi.sms;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

public class SMSActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ContentResolver cr = getContentResolver();
		String strUriInbox = "content://sms";
		Uri uriSms = Uri.parse(strUriInbox);

		String[] projection = new String[] { "_id", "address", "person",
				"body", "date", "type","deleted" };
		Cursor cur = cr.query(uriSms, projection, null, null, "date desc");
		
		
		while (cur.moveToNext()) {
			System.out.println(cur.getString(0) +"     "+ cur.getString(1)
					+"     "+ cur.getString(2) +"     "+ cur.getString(3) +"     "+ cur.getString(4)
					+"     "+ cur.getString(5)+"     "+ cur.getString(6));
		}

		// Cursor c_groups = managedQuery( uriSms , new String[] {
		// "date","person" }, select, null, "date DESC");

	}

}
