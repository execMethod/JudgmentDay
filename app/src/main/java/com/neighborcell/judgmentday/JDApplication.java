package com.neighborcell.judgmentday;
import com.neighborcell.judgmentday.Data.*;
import com.neighborcell.testament.*;
import com.neighborcell.testament.Util.*;
import java.util.*;

public class JDApplication extends TSApplication
{
  private static final String KEY_PACKING_DATA = "KEY_PACKING_DATA";
  
  static
  {
    TSLog.zSetLoggable(true);
    TSLog.zSetTag("JudgementDay");
  }
  
  @Override
  public void onCreate()
  {
    super.onCreate();
    TSLog.zDebug();
  }

  @Override
  protected void zFirstboot()
  {
    JDPacking packing = new JDPacking();
    
    JDRowTerminal terminal = new JDRowTerminal();
    terminal.setType( JDRowStop.JDROWSTOP_TYPE_FAVORITE );
    terminal.setStop("第２テクノパーク");
    terminal.setWay("新さっぽろ行き");
    
    JDRowTimetable tbl = new JDRowTimetable();
    tbl.setLine("新78テクノパーク線");
    tbl.setDest("新さっぽろ");
    tbl.addTimeWorkday( new JDTime( 8,35) );
    tbl.addTimeWorkday( new JDTime( 9,10) );
    tbl.addTimeWorkday( new JDTime( 9,40) );
    tbl.addTimeWorkday( new JDTime(10,40) );
    tbl.addTimeWorkday( new JDTime(11,40) );
    tbl.addTimeWorkday( new JDTime(12,40) );
    tbl.addTimeWorkday( new JDTime(13,40) );
    tbl.addTimeWorkday( new JDTime(14,40) );
    tbl.addTimeWorkday( new JDTime(15,40) );
    tbl.addTimeWorkday( new JDTime(16,40) );
    tbl.addTimeWorkday( new JDTime(17,15) );
    tbl.addTimeWorkday( new JDTime(17,40) );
    tbl.addTimeWorkday( new JDTime(17,52) );
    tbl.addTimeWorkday( new JDTime(18, 5) );
    tbl.addTimeWorkday( new JDTime(18,15) );
    tbl.addTimeWorkday( new JDTime(18,25) );
    tbl.addTimeWorkday( new JDTime(18,35) );
    tbl.addTimeWorkday( new JDTime(18,47) );
    tbl.addTimeWorkday( new JDTime(19, 7) );
    tbl.addTimeWorkday( new JDTime(19,27) );
    tbl.addTimeWorkday( new JDTime(19,47) );
    tbl.addTimeWorkday( new JDTime(20,10) );
    tbl.addTimeWorkday( new JDTime(20,30) );
    tbl.addTimeWorkday( new JDTime(20,52) );
    tbl.addTimeWorkday( new JDTime(21,15) );
    tbl.addTimeWorkday( new JDTime(21,40) );
    tbl.addTimeWorkday( new JDTime(22,10) );
    tbl.addTimeHoliday( new JDTime(18, 0) );
    terminal.addTables( tbl );
    packing.addTerminal( terminal );
    
    terminal = new JDRowTerminal();
    terminal.setType( JDRowStop.JDROWSTOP_TYPE_FAVORITE );
    terminal.setStop("もみじ台北２丁目");
    terminal.setWay("新さっぽろ行き");
    
    tbl = new JDRowTimetable();
    tbl.setLine("JRバス");
    tbl.setDest("新さっぽろ");
    tbl.addTimeWorkday( new JDTime( 6,16) );
    tbl.addTimeWorkday( new JDTime( 6,36) );
    tbl.addTimeWorkday( new JDTime( 6,51) );
    tbl.addTimeWorkday( new JDTime( 7, 3) );
    tbl.addTimeWorkday( new JDTime( 7, 9) );
    tbl.addTimeWorkday( new JDTime( 7,13) );
    tbl.addTimeWorkday( new JDTime( 7,24) );
    tbl.addTimeWorkday( new JDTime( 7,28) );
    tbl.addTimeWorkday( new JDTime( 7,34) );
    tbl.addTimeWorkday( new JDTime( 7,49) );
    tbl.addTimeWorkday( new JDTime( 7,54) );
    tbl.addTimeWorkday( new JDTime( 7,59) );
    tbl.addTimeWorkday( new JDTime( 8,19) );
    tbl.addTimeWorkday( new JDTime( 8,24) );
    tbl.addTimeWorkday( new JDTime( 8,32) );
    tbl.addTimeWorkday( new JDTime( 8,40) );
    tbl.addTimeWorkday( new JDTime( 8,42) );
    tbl.addTimeWorkday( new JDTime( 8,44) );
    tbl.addTimeWorkday( new JDTime( 8,49) );
    tbl.addTimeWorkday( new JDTime( 8,59) );
    tbl.addTimeWorkday( new JDTime( 9, 9) );
    tbl.addTimeWorkday( new JDTime( 9,17) );
    tbl.addTimeWorkday( new JDTime( 9,21) );
    tbl.addTimeWorkday( new JDTime( 9,27) );
    tbl.addTimeWorkday( new JDTime( 9,39) );
    tbl.addTimeWorkday( new JDTime( 9,47) );
    tbl.addTimeWorkday( new JDTime( 9,49) );
    tbl.addTimeWorkday( new JDTime( 9,59) );
    tbl.addTimeWorkday( new JDTime(10, 9) );
    tbl.addTimeWorkday( new JDTime(10,24) );
    tbl.addTimeWorkday( new JDTime(10,39) );
    tbl.addTimeWorkday( new JDTime(10,47) );
    tbl.addTimeWorkday( new JDTime(10,54) );
    tbl.addTimeWorkday( new JDTime(11, 9) );
    tbl.addTimeWorkday( new JDTime(11,24) );
    tbl.addTimeWorkday( new JDTime(11,41) );
    tbl.addTimeWorkday( new JDTime(11,47) );
    tbl.addTimeWorkday( new JDTime(12, 9) );
    tbl.addTimeWorkday( new JDTime(12,24) );
    tbl.addTimeWorkday( new JDTime(12,41) );
    tbl.addTimeWorkday( new JDTime(12,47) );
    tbl.addTimeWorkday( new JDTime(13, 9) );
    tbl.addTimeWorkday( new JDTime(13,24) );
    tbl.addTimeWorkday( new JDTime(13,39) );
    tbl.addTimeWorkday( new JDTime(13,47) );
    tbl.addTimeWorkday( new JDTime(13,54) );
    tbl.addTimeWorkday( new JDTime(14, 9) );
    tbl.addTimeWorkday( new JDTime(14,26) );
    tbl.addTimeWorkday( new JDTime(14,47) );
    tbl.addTimeWorkday( new JDTime(14,54) );
    tbl.addTimeWorkday( new JDTime(15, 9) );
    tbl.addTimeWorkday( new JDTime(15,19) );
    tbl.addTimeWorkday( new JDTime(15,29) );
    tbl.addTimeWorkday( new JDTime(15,39) );
    tbl.addTimeWorkday( new JDTime(15,47) );
    tbl.addTimeWorkday( new JDTime(15,54) );
    tbl.addTimeWorkday( new JDTime(16,20) );
    tbl.addTimeWorkday( new JDTime(16,37) );
    tbl.addTimeWorkday( new JDTime(16,47) );
    tbl.addTimeWorkday( new JDTime(16,54) );
    tbl.addTimeWorkday( new JDTime(17, 9) );
    tbl.addTimeWorkday( new JDTime(17,22) );
    tbl.addTimeWorkday( new JDTime(17,24) );
    tbl.addTimeWorkday( new JDTime(17,39) );
    tbl.addTimeWorkday( new JDTime(17,47) );
    tbl.addTimeWorkday( new JDTime(17,59) );
    tbl.addTimeWorkday( new JDTime(18,12) );
    tbl.addTimeWorkday( new JDTime(18,21) );
    tbl.addTimeWorkday( new JDTime(18,22) );
    tbl.addTimeWorkday( new JDTime(18,32) );
    tbl.addTimeWorkday( new JDTime(18,42) );
    tbl.addTimeWorkday( new JDTime(18,46) );
    tbl.addTimeWorkday( new JDTime(18,54) );
    tbl.addTimeWorkday( new JDTime(19,14) );
    tbl.addTimeWorkday( new JDTime(19,34) );
    tbl.addTimeWorkday( new JDTime(19,46) );
    tbl.addTimeWorkday( new JDTime(19,54) );
    tbl.addTimeWorkday( new JDTime(20,17) );
    tbl.addTimeWorkday( new JDTime(20,37) );
    tbl.addTimeWorkday( new JDTime(20,55) );
    tbl.addTimeWorkday( new JDTime(20,59) );
    tbl.addTimeWorkday( new JDTime(21,22) );
    tbl.addTimeWorkday( new JDTime(21,26) );
    tbl.addTimeWorkday( new JDTime(21,47) );
    tbl.addTimeWorkday( new JDTime(22,17) );
    terminal.addTables( tbl );
    packing.addTerminal( terminal );
    
    
    zSetPack( KEY_PACKING_DATA, packing );
    super.zFirstboot();
  }
  
  public JDPacking zGetPacking()
  {
    return (JDPacking)zGetPack( KEY_PACKING_DATA );
  }
  
  
}
