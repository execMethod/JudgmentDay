package com.neighborcell.judgmentday.Data;

import java.util.*;
import com.neighborcell.testament.Data.*;
import java.io.*;

public class JDRowStop extends TSRow
{
  public static final int JDROWSTOP_STATUS_NONE = 0;
  public static final int JDROWSTOP_STATUS_JAM = 1;
  public static final int JDROWSTOP_STATUS_WEATHER = 3;

  public static final int JDROWSTOP_TYPE_FAVORITE = 0;
  public static final int JDROWSTOP_TYPE_NEIGHBOR = 1;


  private int status = JDROWSTOP_STATUS_NONE;
  private JDTime next = null;
  private int type = JDROWSTOP_TYPE_FAVORITE;
  private String line = "";
  private String stop = "";
  private String dest = "";
  private int late = 0;
  

  public void setStatus(int status)
  {
    this.status = status;
  }

  public int getStatus()
  {
    return status;
  }

  public void setNext(JDTime next)
  {
    this.next = next;
  }

  public JDTime getNext()
  {
    return next;
  }

  public void setType(int type)
  {
    this.type = type;
  }

  public int getType()
  {
    return type;
  }

  public void setLine(String line)
  {
    this.line = line;
  }

  public String getLine()
  {
    return line;
  }

  public void setStop(String stop)
  {
    this.stop = stop;
  }

  public String getStop()
  {
    return stop;
  }

  public void setDest(String dest)
  {
    this.dest = dest;
  }

  public String getDest()
  {
    return dest;
  }
  
  public void setLate(int late)
  {
    this.late = late;
  }

  public int getLate()
  {
    return late;
  }
}
