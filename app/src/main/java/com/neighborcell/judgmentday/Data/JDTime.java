package com.neighborcell.judgmentday.Data;
import java.io.*;
import java.util.*;

public class JDTime implements Serializable
{
  // hours 0-23
  private int hh = 0;
  // minutes 0-59
  private int mm = 0;

  public JDTime( int hh, int mm )
  {
    this.hh = hh;
    this.mm = mm;
  }
  
  public boolean isAlready( Calendar now )
  {
    boolean isAlready = true;
    int hours = now.get( Calendar.HOUR_OF_DAY );
    int minutes = now.get( Calendar.MINUTE );

    if( hours < hh )
    {
      isAlready = false;
    }
    else if( hours == hh )
    {
      if( minutes <= mm )
      {
        isAlready = false;
      }
    }
    return isAlready;
  }
  
  /*
  public String getString()
  {
    return hh + ":" + mm;
  }
  */
  
  public int getValue()
  {
    return ( hh * 60 ) + mm;
  }
  
  public int getDiff(Calendar now)
  {
    int hnow = now.get(Calendar.HOUR_OF_DAY);
    int mnow = now.get(Calendar.MINUTE);
    int diff = ( ( hnow - hh ) * 60 ) + ( mnow - mm );
    if( 0 > diff )
    {
      // tomorrow
      diff += 24 * 60;
    }
    return diff;
  }
  
  public void addMinute( int minute )
  {
    if( 0 == minute )
    {
      return;
    }
    int addh = ( minute / 60 );
    int addm = ( minute % 60 );
    mm += addm;
    if( 60 < mm )
    {
      mm -= 60;
      addh += 1;
    }
    hh += addh;
  }
  
  public int getHour()
  {
    return hh;
  }
  
  public int getMinute()
  {
    return mm;
  }
  
}

