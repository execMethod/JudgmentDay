package com.neighborcell.testament;
import android.app.*;
import com.neighborcell.testament.Data.*;
import com.neighborcell.testament.Util.*;
import java.io.*;

public class TSApplication extends Application
{
  private TSPacking pack = new TSPacking();

  public void onCreate()
  {
    super.onCreate();

    try
    {

      TSLog.zInfo("========== APP START ==========");

      pack = (TSPacking) TSFile.zLoad(getBaseContext(), pack);

      if (pack.zGetFirst())
      {
        zFirstboot();
        pack.zSetFirst(false);
        zSavePack();
      }
    }
    catch (Exception e)
    {
      TSLog.zErr(e);
    }
  }

  protected void zFirstboot()
  {

  }

  protected Serializable zGetPack(String key)
  {
    return pack.zGetPack(key);
  }

  protected void zSetPack(String key, Serializable packdata)
  {
    pack.zSetPack(key, packdata);
    zSavePack();
  }

  protected void zSavePack()
  {
    TSFile.zSave(getBaseContext(), pack);
  }
}

