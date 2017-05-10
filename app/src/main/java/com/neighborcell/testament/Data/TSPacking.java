package com.neighborcell.testament.Data;
import java.util.*;
import java.io.*;
import com.neighborcell.testament.Util.*;
import android.telecom.*;

public class TSPacking implements Serializable, TSFileInf
{
  private String FILE_PATH = "TSPacking.dat";
  private boolean isFirst = true;
  
  private Map<String,Serializable> pack = new HashMap<String,Serializable>();
  
  public void zSetFirst(boolean isFirst)
  {
    this.isFirst = isFirst;
  }
  
  public boolean zGetFirst()
  {
    return isFirst;
  }
  
  public String zGetPath()
  {
    return FILE_PATH;
  }
  
  public void zSetPack( String key, Serializable data)
  {
    pack.put( key, data );
  }
  
  public Serializable zGetPack( String key )
  {
    return pack.get( key );
  }
}

