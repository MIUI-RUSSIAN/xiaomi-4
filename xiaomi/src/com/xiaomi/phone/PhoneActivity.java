package com.xiaomi.phone;

import java.lang.reflect.Method;

import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.android.internal.telephony.ITelephony;
import com.common.BaseActivity;

public class PhoneActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 初始化监听器
		phoner();
		// 监听事件
		phoneListener();

	}

	private ITelephony iTelephony;
	private TelephonyManager manager;

	/**
	 * 初始化手机通讯状态监控服务
	 */
	private void phoner() {
		manager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
		Class<TelephonyManager> c = TelephonyManager.class;
		Method getITelephonyMethod = null;
		try {
			getITelephonyMethod = c.getDeclaredMethod("getITelephony",
					(Class[]) null);
			getITelephonyMethod.setAccessible(true);
			iTelephony = (ITelephony) getITelephonyMethod.invoke(manager,
					(Object[]) null);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	private void phoneListener() {
		manager.listen(new PhoneStateListener() {

			@Override
			public void onCallStateChanged(int state, String incomingNumber) {
				// TODO Auto-generated method stub
				super.onCallStateChanged(state, incomingNumber);
				Log.e("state", "" + state+"  "+incomingNumber);
				switch (state) {
				// 挂断
				case 0:{}
				// 判断是否有电话接入
				case 1: {

					Log.e("1+++incomingNumber", incomingNumber);
					// // 当电话接入时，自动挂断。
					// iTelephony.endCall();
					// System.out.println("uncall");
				}
					break;
				// 判断电话播出
				case 2: {
					// 当电话接入时，自动挂断。
					// iTelephony.endCall();
					Log.e("2+++++incomingNumber", incomingNumber);
					System.out.println("uncall");
				}
					break;
				}
			}

		}, PhoneStateListener.LISTEN_CALL_STATE);

	}

}
