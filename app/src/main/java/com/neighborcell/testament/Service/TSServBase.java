package com.neighborcell.testament.Service;

import android.app.*;
import android.content.*;
import android.os.*;
import com.neighborcell.testament.Util.*;

public abstract class TSServBase extends Service
{
  @Override
  public void onCreate()
  {
    TSLog.zDebug();
    super.onCreate();
    
    try
    {
      xCreate();
    }
    catch ( Exception e )
    {
      TSLog.zErr(e);
    }
  }
  
  protected abstract void xCreate();

  @Override
  public int onStartCommand(Intent intent, int flags, int startId) 
  {
    //NCLog.d();
    
    try
    {
      Intent out = xStartCommand(intent);
      if( null != out )
      {
        sendBroadcast(out);
      }
    }
    catch (Exception e)
    {
      TSLog.zErr(e);
    }
    return START_STICKY;
  }
  
  protected abstract Intent xStartCommand(Intent arg);

  @Override
  public IBinder onBind(Intent intent)
  {
    return null;
  }

  @Override
  public void onDestroy()
  {
    //NCLog.d();
    super.onDestroy();
  }
}
