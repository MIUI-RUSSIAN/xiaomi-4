package com.xiaomi.db.sqlite;

import java.util.Enumeration;
import java.util.Properties;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import com.common.Constant;
import com.common.PropertiesUtil;

public class DatabaseHelper extends SQLiteOpenHelper {

	public DatabaseHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	}

	public DatabaseHelper(Context context, String name, int version) {
		this(context, name, null, version);
	}

	public DatabaseHelper(Context context, String name) {
		this(context, name, Constant.DBVERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// 第一次创建数据库
		// 读取sqlMap文件
		Properties p = new Properties();
		Enumeration<?> keys = PropertiesUtil.getKeys(p, "sqlMap.properties");
		while (keys.hasMoreElements()) {
			String sql = "" + p.get(keys.nextElement());
			db.execSQL(sql);
		}

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// 更新数据库

	}

}
