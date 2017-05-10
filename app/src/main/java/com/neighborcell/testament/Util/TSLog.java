package com.neighborcell.testament.Util;

import android.app.*;
import android.os.*;
import android.util.*;
import java.io.*;
import java.text.*;
import java.util.*;

public final class TSLog
{
  private static final String DIR = "/neighborcell/";
  private static final String FNAME = "app.log";
  
  private static String tag = "testament";
  private static String path = DIR + tag + "/";
  
  private static final String crlf = System.getProperty("line.separator");
  private static boolean isLoggable = true;

  public static void zSetTag(String tag)
  {
    if( null == tag || tag.isEmpty() )
    {
      return;
    }
    TSLog.tag = tag;
    TSLog.path = DIR + tag + "/";
  }
  
  public static void zSetLoggable(boolean isLoggable)
  {
    TSLog.isLoggable = isLoggable;
  }

  public static void zDebug()
  {
    if (!isLoggable)
    {
      return;
    }
    Log.d(tag, "");
    zFileout(zFormatMessage());
  }

  public static void zInfo(String msg)
  {
    if (!isLoggable)
    {
      return;
    }
    Log.i(tag, msg);
    zFileout(zFormatMessage(msg));

  }

  public static void zErr(Throwable t)
  {
    if (!isLoggable)
    {
      return;
    }
    
    Log.e(tag, "", t);
    zFileout(zFormatMessage(t.getMessage()));

    StringWriter sw = new StringWriter();
    PrintWriter pw = new PrintWriter(sw);
    try
    {
      t.printStackTrace(pw);
      pw.flush();
      pw.close();
      zFileout(sw.getBuffer().toString());
      pw = null;
    }
    catch ( Exception e )
    {

    }
    finally
    {
      if (null != pw)
      {
        try
        {
          pw.close();
        }
        catch ( Exception ex )
        {

        }
      }
    }

    //printStackTrace(t);
  }

  private static void zPrintStackTrace(Throwable th)
  {
    String filePath = Environment.getExternalStorageDirectory() + FNAME;
    File file = new File(filePath);
    if (!file.getParentFile().exists())
    {
      file.getParentFile().mkdir();
    }

    FileOutputStream fos = null;
    try
    {
      fos = new FileOutputStream(file, true);
      OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
      PrintWriter pw = new PrintWriter(osw);
      th.printStackTrace(pw);
      pw.flush();
      pw.close();
    }
    catch (Exception e)
    {

    }
    finally
    {
      if (null != fos)
      {
        try
        {
          fos.close();
        }
        catch ( Exception ex )
        {

        }
      }
    }
  }

  private static String zFormatMessage()
  {
    int rank = 4;

    Calendar c = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/ HH:mm:ss.SSS");
    sdf.format(c.getTime());

    Thread th = Thread.currentThread();
    StackTraceElement st[] = th.getStackTrace();
    StringBuffer sb = new StringBuffer();

    if (st.length < rank - 1)
    {
      return "";
    }

    sb.append(sdf.format(c.getTime()));
    sb.append("#");
    sb.append(st[rank].getFileName());
    sb.append("[");
    sb.append(st[rank].getLineNumber());
    sb.append("] @");
    sb.append(st[rank].getMethodName());
    sb.append(crlf);

    return sb.toString();
  }

  private static String zFormatMessage(String msg)
  {
    int rank = 4;

    Calendar c = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/ HH:mm:ss.SSS");
    sdf.format(c.getTime());

    Thread th = Thread.currentThread();
    StackTraceElement st[] = th.getStackTrace();
    StringBuffer sb = new StringBuffer();

    if (st.length < rank - 1)
    {
      return "";
    }

    sb.append(sdf.format(c.getTime()));
    sb.append("#");
    sb.append(st[rank].getFileName());
    sb.append("[");
    sb.append(st[rank].getLineNumber());
    sb.append("]:");
    sb.append(msg);
    sb.append(crlf);

    return sb.toString();
  }

  private static void zClear()
  {
    //zClear( PATH_LOG );
  }

  public static void zClear(String filename)
  {
    String filePath = Environment.getExternalStorageDirectory() + path + filename;
    File file = new File(filePath);
    if (!file.getParentFile().exists())
    {
      file.getParentFile().mkdir();
    }

    FileOutputStream fos = null;
    try
    {
      fos = new FileOutputStream(file, false);
      OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
      BufferedWriter bw = new BufferedWriter(osw);
      bw.write("");
      bw.flush();
      bw.close();
    }
    catch (Exception e)
    {

    }
    finally
    {
      if (null != fos)
      {
        try
        {
          fos.close();
        }
        catch ( Exception ex )
        {

        }
      }
    }
  }

  private static void zFileout(String msg)
  {
    zFileout( FNAME, msg);
  }

  public static void zFileout(String filename, String msg)
  {
    String filePath = Environment.getExternalStorageDirectory() + path + filename;
    File file = new File(filePath);
    if (!file.getParentFile().exists())
    {
      file.getParentFile().mkdir();
    }

    FileOutputStream fos = null;
    try
    {
      fos = new FileOutputStream(file, true);
      OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
      BufferedWriter bw = new BufferedWriter(osw);
      bw.write(msg);
      bw.flush();
      bw.close();
    }
    catch (Exception e)
    {

    }
    finally
    {
      if (null != fos)
      {
        try
        {
          fos.close();
        }
        catch ( Exception ex )
        {

        }
      }
    }
  }
}

