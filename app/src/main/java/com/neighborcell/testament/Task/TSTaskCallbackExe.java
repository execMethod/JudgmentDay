package com.neighborcell.testament.Task;

import com.neighborcell.testament.Util.*;
import android.os.*;

public class TSTaskCallbackExe<PARAM> implements Runnable
{
  private int status;
  private TSTaskCallback<PARAM> cb;
  private PARAM data;

  public TSTaskCallbackExe( TSTaskCallback<PARAM> cb)
  {
    this.cb = cb;
    this.status = TSTaskCallback.CALLBACK_STATUS_ERROR;
    this.data = null;
  }

  public void zSetParameter( int status, PARAM data )
  {
    //NCLog.i("set status;" + status );
    this.status = status;
    this.data = data;
  }

  @Override
  public void run()
  {
    //NCLog.d();
    //NCLog.i("run status;" + status );
    cb.xCallback(status,data);
  }
  
  public void zExecute( Handler handler)
  {
    handler.post(this);
  }
}
