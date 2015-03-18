package com.jomeslu.easyevent;

import java.lang.ref.WeakReference;
/**
 * 
 * @author jomeslu
 *
 */
public class LibEvent {


	private static LibEvent instance;

	private LibEvent() {};

	private   WeakReference<LibEventCallBackListener> mWeakReference;

	public static synchronized LibEvent getInstance() {

		if (instance == null) {
			instance = new LibEvent();
		}

		return instance;

	}

	public void registEventManagerListener(LibEventCallBackListener mOnEventCallBackListener) {
		if (mOnEventCallBackListener != null) {
			mWeakReference = new WeakReference<LibEventCallBackListener>(mOnEventCallBackListener);
		}
	}

	public void unRegistEventManagerListener() {
		if (mWeakReference != null) {
			mWeakReference.clear();
		}

	}

	public void notifyEvent(Object obj, int code) {
		if (mWeakReference != null&&mWeakReference.get()!=null) {
			mWeakReference.get().onEventResult(obj, code);
		}

	}

}
