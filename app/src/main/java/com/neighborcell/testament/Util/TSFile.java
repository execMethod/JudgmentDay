package com.neighborcell.testament.Util;
import android.content.*;
import android.util.*;
import java.io.*;

public class TSFile
{
  public static void zSave(Context cont, TSFileInf obj)
  {
    zSave(cont, obj.zGetPath(), obj);
  }
  
  public static TSFileInf zLoad(Context cont, TSFileInf obj)
  {
    TSFileInf loaded = zLoad(cont,obj.zGetPath());
    if( null == loaded )
    {
      loaded = obj;
      zSave(cont,obj);
    }
    return loaded;
  }
  
  public static void zDelete(Context cont, String path)
  {
    try
    {
      cont.deleteFile(path);
    }
    catch (Exception e)
    {
      TSLog.zErr(e);
    }
  }
  
  public static void zSave(Context cont, String path, TSFileInf obj)
  {
    FileOutputStream fos = null;
    ObjectOutputStream oos = null;
    TSLog.zInfo("save path : " + path);
    try
    {
      fos = cont.openFileOutput(path, Context.MODE_PRIVATE);
      oos = new ObjectOutputStream(fos);
      oos.writeObject(obj);
      oos.close();
    } 
    catch (Exception e)
    {
      TSLog.zErr(e);
    }
    finally
    {
      try
      {
        if( null != fos)
        {
          fos.close();
        }
      }
      catch( IOException ex)
      {
        // no code
      }
    }
  }
  
  public static TSFileInf zLoad(Context cont, String path)
  {
    FileInputStream fis = null;
    ObjectInputStream ois = null;
    TSFileInf obj = null;
    try
    {
      fis = cont.openFileInput(path);
      ois = new ObjectInputStream(fis);
      obj = (TSFileInf) ois.readObject();
      ois.close();
    }
    catch (Exception e)
    {
      TSLog.zErr(e);
    }
    finally
    {
      try
      {
        if( null != fis )
        {
          fis.close();
        }
      }
      catch( IOException ex )
      {
        // no code
      }
    }
    return obj;
  }
}
