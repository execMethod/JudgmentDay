package com.neighborcell.judgmentday.Data;
import com.neighborcell.judgmentday.Data.*;
import com.neighborcell.testament.Data.*;
import java.io.*;
import java.util.*;

public class JDRowTerminal extends TSRow implements Serializable
{
  private int type = JDRowStop.JDROWSTOP_TYPE_FAVORITE;
  private String stop = "";
  private String way = "";
  
  private List<JDRowTimetable> tables = new ArrayList<JDRowTimetable>();

  public void setType(int type)
  {
    this.type = type;
  }

  public int getType()
  {
    return type;
  }

  public void setWay(String way)
  {
    this.way = way;
  }

  public String getWay()
  {
    return way;
  }
  
  public void setStop(String stop)
  {
    this.stop = stop;
  }

  public String getStop()
  {
    return stop;
  }

  public void addTables( JDRowTimetable timetable )
  {
    this.tables.add( timetable );
  }

  public JDRowStop getNextStop( Calendar now )
  {
    //Calendar now = Calendar.getInstance();
    int min = Integer.MAX_VALUE;
    JDRowTimetable tbl = null;
    JDTime tim = null;
    for( JDRowTimetable table : tables )
    {
      JDTime time = table.getNextTime( now );
      if( null == time )
      {
        continue;
      }
      int diff = time.getDiff( now );
      if( min > diff )
      {
        min = diff;
        tbl = table;
        tim = time;
      }
    }
    
    if( null == tbl )
    {
      return null;
    }
    
    // todo:ダイヤ遅延をどう具体的に検出するか要検討
    Random rnd = new Random();
    int late = (int)( rnd.nextGaussian() * rnd.nextGaussian() * 10 );
    late = late >= 0 ? late : ( late * -1 );
    int stat = JDRowStop.JDROWSTOP_STATUS_NONE;
    if( 0 < late )
    {
      if( rnd.nextBoolean() )
      {
        stat = JDRowStop.JDROWSTOP_STATUS_JAM;
      }
      else
      {
        stat = JDRowStop.JDROWSTOP_STATUS_WEATHER;
      }
    }
    // 遅延を考慮
    tim.addMinute( late );
    
    JDRowStop row = new JDRowStop();
    row.setStatus( stat );
    row.setNext( tim );
    row.setType( type );
    row.setLine( tbl.getLine() );
    row.setStop( stop );
    row.setDest( tbl.getDest() );
    row.setLate( late );
    return row;
  }
}

