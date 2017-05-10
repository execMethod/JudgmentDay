package com.neighborcell.judgmentday.Data;

import android.view.*;
import android.widget.*;
import com.neighborcell.judgmentday.*;
import com.neighborcell.testament.Data.*;

public class JDRowStopHolder extends TSHolder
{
  private JDRowStop rowdata = null;

  private ImageView icon;
  private TextView late;
  private TextView type;
  private TextView line;
  private TextView stop;
  private TextView prog;

  @Override
  public void xFindView(View view)
  {
    icon = (ImageView)view.findViewById(R.id.rowstop_icon);
    late = (TextView)view.findViewById(R.id.rowstop_late);
    type = (TextView)view.findViewById(R.id.rowstop_type);
    line = (TextView)view.findViewById(R.id.rowstop_line);
    stop = (TextView)view.findViewById(R.id.rowstop_stop);
    prog = (TextView)view.findViewById(R.id.rowstop_prog);
  }

  @Override
  public void xSetRow(TSRow row)
  {
    rowdata = (JDRowStop) row;

    switch (rowdata.getStatus())
    {
      case JDRowStop.JDROWSTOP_STATUS_JAM:
        icon.setImageResource(R.drawable.traffic_blue_src);
        break;
      case JDRowStop.JDROWSTOP_STATUS_WEATHER:
        icon.setImageResource(R.drawable.weather_blue_src);
        break;
      default:
        icon.setImageResource(R.drawable.bus_blue_src);
        break;
    }

    if( 0 < rowdata.getLate() )
    {
      late.setText("約" + rowdata.getLate() + "分の遅れ");
    }
    else
    {
      late.setText("定刻通り");
    }

    switch (rowdata.getType())
    {
      case JDRowStop.JDROWSTOP_TYPE_FAVORITE:
        type.setText("お気に入り");
        break;
      case JDRowStop.JDROWSTOP_TYPE_NEIGHBOR:
        type.setText("最寄り");
        break;
      default:
        type.setText(" - ");
    }

    line.setText(rowdata.getLine());

    stop.setText(rowdata.getStop());
    
    JDTime time = rowdata.getNext();
    //time.addMinute( this.row.getLate() );
    String pr = String.format("次のバスは %02d:%02d です。", time.getHour(), time.getMinute() );
    prog.setText(pr);
    
  }

  @Override
  public TSRow xGetRow()
  {
    return rowdata;
  }
}
