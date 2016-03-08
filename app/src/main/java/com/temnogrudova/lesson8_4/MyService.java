package com.temnogrudova.lesson8_4;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

  final String LOG_TAG = "myLogs";
  MyBinder binder = new MyBinder();
  public void onCreate() {
    super.onCreate();
    Log.d(LOG_TAG, "MyService onCreate");
  }

  public IBinder onBind(Intent intent) {
    Log.d(LOG_TAG, "MyService onBind");
    return binder;
  }

  public void onRebind(Intent intent) {
    super.onRebind(intent);
    Log.d(LOG_TAG, "MyService onRebind");
  }
  
  public boolean onUnbind(Intent intent) {
    Log.d(LOG_TAG, "MyService onUnbind");
    return super.onUnbind(intent);
  }
  
  public void onDestroy() {
    super.onDestroy();
    Log.d(LOG_TAG, "MyService onDestroy");
  }

  //MyBinder расширяет стандартный Binder, мы добавляем в него один метод getService. Этот метод возвращает наш сервис MyService.
  class MyBinder extends Binder {
    MyService getService() {
      return MyService.this;
    }
  }

  int getSum(int a, int b) {
    int s = a+b;
    return s;
  }

}