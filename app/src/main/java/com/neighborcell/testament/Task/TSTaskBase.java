package com.neighborcell.testament.Task;

import android.content.*;
import android.os.*;
import com.neighborcell.testament.Util.*;
import java.util.concurrent.*;

public abstract class TSTaskBase<PARAM>
{
  private static final int PARA = 2;
  
  private TSTaskCallback<PARAM> callback = null;
  private ExecutorService exes = null;
  private Handler handler;
  
  public TSTaskBase()
  {
    exes = Executors.newFixedThreadPool(PARA);
    handler = new Handler();
  }
  
  public void zSetCallback( TSTaskCallback<PARAM> callback )
  {
    this.callback = callback;
  }
  
  protected void zExeCallback(int status, PARAM param)
  {
    if(null == callback)
    {
      return;
    }
    TSTaskCallbackExe<PARAM> callbackExe = new TSTaskCallbackExe<PARAM>( callback );
    callbackExe.zSetParameter(status,param);
    callbackExe.zExecute(handler);
  }
  
  public void zExecute()
  {
    exes.shutdown();
  }
  
  public void zAddShot( PARAM param )
  {
    exes.execute( new NCTaskThreadExe( param ) );
  }
  
  protected abstract PARAM zShot( PARAM param );
  
  public class NCTaskThreadExe implements Runnable
  {
    PARAM param;

    public NCTaskThreadExe(PARAM param)
    {
      this.param = param;
    }

    @Override
    public void run()
    {
      try
      {
        this.param = zShot(param);
      }
      catch( Exception e )
      {
        TSLog.zErr(e);
      }
    }
  }
}
