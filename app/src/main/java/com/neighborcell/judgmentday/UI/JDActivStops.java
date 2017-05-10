package com.neighborcell.judgmentday.UI;

import com.neighborcell.judgmentday.*;
import com.neighborcell.judgmentday.Data.*;
import com.neighborcell.testament.Data.*;
import com.neighborcell.testament.UI.*;
import com.neighborcell.testament.Util.*;
import java.util.*;

public class JDActivStops extends TSActivListBase
{
  private List<TSRow> busstops = new ArrayList<TSRow>();
  private List<JDRowTerminal> terminals = new ArrayList<JDRowTerminal>();

  @Override
  protected void xCreate()
  {
    JDApplication app = (JDApplication)getApplication();
    JDPacking pack = app.zGetPacking();
    terminals = pack.getTerminals();
  }

  @Override
  protected void xResume()
  {
    TSLog.zDebug();
    
    Calendar now = Calendar.getInstance();
    busstops.clear();
    for( JDRowTerminal terminal : terminals )
    {
      JDRowStop stop = terminal.getNextStop( now );
      if( null != stop )
      {
        busstops.add( stop );
      }
    }
    
    zReload();
  }

  @Override
  protected void xPause()
  {
    
  }

  @Override
  protected int xLayoutId()
  {
    return R.layout.activ_stops;
  }

  @Override
  protected int xRowLayoutId()
  {
    return R.layout.row_stops;
  }

  @Override
  protected TSHolder xNewHolder()
  {
    return new JDRowStopHolder();
  }

  @Override
  protected List<TSRow> xRows()
  {
    return busstops;
  }

  @Override
  protected void xRowScroll(int state, int pos)
  {
    // TODO: Implement this method
  }

  @Override
  protected void xRowClick(TSRow row)
  {
    // TODO: Implement this method
  }

  @Override
  protected void xRowLongClick(TSRow row)
  {
    // TODO: Implement this method
  }
}
