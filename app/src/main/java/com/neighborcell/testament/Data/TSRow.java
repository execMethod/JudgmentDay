package com.neighborcell.testament.Data;
import java.util.*;
import java.io.*;

public class TSRow implements Serializable
{
  private static long uniqCnt = 0;
  private String uniq;
  
  public TSRow()
  {
    uniq = zCreUniq();
  }
  
  private String zCreUniq()
  {
    Date date = new Date();
    String ret = String.format("%d_%d", date.getTime(), uniqCnt );
    if( Long.MAX_VALUE == uniqCnt )
    {
      uniqCnt = 0;
    }
    else
    {
      uniqCnt++;
    }
    return ret;
  }
  
  public String zGetUniq()
  {
    return uniq;
  }
  
  public boolean zChkUniq( String uniq )
  {
    return 0 == this.uniq.compareTo( uniq );
  }

  public boolean zEqual( TSRow row )
  {
    return zChkUniq( row.uniq );
  }
  
  public void zCopy( TSRow row )
  {
    uniq = row.uniq;
  }
}
