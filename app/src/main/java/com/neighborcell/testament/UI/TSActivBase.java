package com.neighborcell.testament.UI;

import android.app.*;
import android.content.*;
import android.os.*;
import android.widget.*;
import com.neighborcell.testament.Util.*;

public abstract class TSActivBase extends Activity
{
  public void zReport(String msg)
  {
    Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT).show();
  }

  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent intent)
  {
    super.onActivityResult(requestCode, resultCode, intent);

    if (0 < resultCode - 1)
    {
      zFinish(resultCode - 1, getIntent());
    }
    return;
  }

  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    TSLog.zDebug();
    try
    {
      xCreate();
    }
    catch ( Exception e )
    {
      TSLog.zErr(e);
      zReport(e.getMessage());
    }
  }
  protected abstract void xCreate();

  @Override
  protected void onResume()
  {
    super.onResume();
    TSLog.zDebug();
    try
    {
      xResume();
    }
    catch ( Exception e )
    {
      TSLog.zErr(e);
      zReport(e.getMessage());
    }
  }
  protected abstract void xResume();

  @Override
  protected void onPause()
  {
    TSLog.zDebug();
    try
    {
      xPause();
    }
    catch ( Exception e )
    {
      TSLog.zErr(e);
      zReport(e.getMessage());
    }
    super.onPause();
  }
  protected abstract void xPause();

  public void contentView()
  {
    setContentView(xLayoutId());
  }
  protected abstract int xLayoutId();
  
  public void zFinish(int resultCode, Intent intent)
  {
    setResult(resultCode, intent);
    super.finish();
  }
  
}
