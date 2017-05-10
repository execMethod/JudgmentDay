package com.neighborcell.judgmentday.Data;
import com.neighborcell.testament.Data.*;
import java.io.*;
import java.util.*;

public class JDRowTimetable extends TSRow implements Serializable
{
  private String line = "";
  private String dest = "";

  private List<JDTime> tableWorkday = new ArrayList<JDTime>();
  private List<JDTime> tableHoliday = new ArrayList<JDTime>();

  public void setDest(String dest)
  {
    this.dest = dest;
  }

  public String getDest()
  {
    return dest;
  }

  public void setLine(String line)
  {
    this.line = line;
  }

  public String getLine()
  {
    return line;
  }

  public JDTime getNextTime( Calendar now )
  {
    return getNextTime(now, false);
  }

  private JDTime getNextTime(Calendar now, boolean isTomorrow)
  {
    JDTime next = null;
    List<JDTime> table;
    int week = now.get(Calendar.DAY_OF_WEEK);
    if (
      (Calendar.SATURDAY == week) 
      || (Calendar.SUNDAY == week)
      )
    {
      table = tableHoliday;
    }
    else
    {
      table = tableWorkday;
    }
    for (JDTime time : table)
    {
      if (time.isAlready(now))
      {
        break;
      }
      next = time;
    }
    if (null == next)
    {
      if (!isTomorrow)
      {
        // check for tomorrow table
        Calendar tomorrow = (Calendar) now.clone();
        tomorrow.add(Calendar.DATE, 1);
        tomorrow.set(Calendar.HOUR_OF_DAY, 0);
        tomorrow.set(Calendar.MINUTE, 0);
        next = getNextTime(tomorrow, true);
      }
    }
    return next;
  }

  public void addTimeWorkday(JDTime workday)
  {
    this.tableWorkday.add(workday);
    Collections.sort( tableWorkday, new JDTimeComparator() );
  }

  public void addTimeHoliday(JDTime holiday)
  {
    this.tableHoliday.add(holiday);
    Collections.sort( tableHoliday, new JDTimeComparator() );
  }
  
  private class JDTimeComparator implements Comparator<JDTime>
  {
    @Override
    public int compare(JDTime p1, JDTime p2)
    {
      return p1.getValue() < p2.getValue() ? 1 : -1;
    }
  }

}
