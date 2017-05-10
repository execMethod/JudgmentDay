package com.neighborcell.testament.UI;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.widget.AbsListView.*;
import android.widget.AdapterView.*;
import com.neighborcell.testament.Data.*;
import com.neighborcell.testament.Util.*;
import java.util.*;

import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;

public abstract class TSActivListBase extends ListActivity
{
  public void zReport(String msg)
  {
    Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT).show();
    TSLog.zInfo(msg);
  }

  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent intent)
  {
    super.onActivityResult(requestCode, resultCode, intent);

    if (0 < resultCode - 1)
    {
      zFinish(resultCode - 1, getIntent());
    }
    return;
  }

  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    TSLog.zDebug();
    try
    {
      xCreate();
      zContentView();
    }
    catch ( Exception e )
    {
      TSLog.zErr(e);
      zReport(e.getMessage());
    }
  }
  protected abstract void xCreate();

  @Override
  protected void onResume()
  {
    super.onResume();
    TSLog.zDebug();
    try
    {
      xResume();
    }
    catch ( Exception e )
    {
      TSLog.zErr(e);
      zReport(e.getMessage());
    }
  }
  protected abstract void xResume();

  @Override
  protected void onPause()
  {
    TSLog.zDebug();
    try
    {
      xPause();
    }
    catch ( Exception e )
    {
      TSLog.zErr(e);
      zReport(e.getMessage());
    }
    super.onPause();
  }
  protected abstract void xPause();

  public void zContentView()
  {
    setContentView(xLayoutId());
    setListAdapter(new ListViewAdapter(this, xRowLayoutId(), xRows()));

    ListView listView = getListView();
    listView.setOnItemClickListener(new ItemClickListener());
    listView.setOnItemLongClickListener(new ItemLongTouchListener());
    listView.setOnScrollListener(new ItemScrollListener() );
  }

  public void zFinish(int resultCode, Intent intent)
  {
    setResult(resultCode, intent);
    super.finish();
  }

  protected abstract int xLayoutId();

  protected abstract int xRowLayoutId();

  protected abstract List<TSRow> xRows();

  protected void zReload()
  {
    try
    {
      TSLog.zDebug();
      ListViewAdapter adpt = (ListViewAdapter)getListAdapter();
      adpt.notifyDataSetChanged();
    }
    catch (Exception e)
    {
      TSLog.zErr(e);
    }
  }
  
  protected abstract TSHolder xNewHolder();

  private class ListViewAdapter extends ArrayAdapter<TSRow>
  {
    private LayoutInflater inflater;
    private int layout;
    TSRow row;

    public ListViewAdapter(Context context, int layout,  List<TSRow> rows)
    {
      super(context, 0, rows);
      this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      this.layout = layout;
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
      try
      {
        TSHolder holder;
        if (convertView == null)
        {
          convertView = inflater.inflate(layout, parent, false);
          holder = xNewHolder();
          holder.xFindView(convertView);
          convertView.setTag(holder);
        }
        else
        {
          holder = (TSHolder) convertView.getTag();
        }

        row = getItem(position);
        holder.xSetRow(row);
      }
      catch (Exception e)
      {
        TSLog.zErr(e);
        zReport(e.getMessage());
      }
      return convertView;
    }
  }

  private class ItemClickListener implements OnItemClickListener
  {
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
      TSHolder holder = (TSHolder)view.getTag();
      try
      {
        xRowClick(holder.xGetRow());
      }
      catch ( Exception e )
      {
        TSLog.zErr(e);
        zReport(e.getMessage());
      }
    }
  }
  protected abstract void xRowClick(TSRow row);
  
  private class ItemLongTouchListener implements OnItemLongClickListener
  {
    @Override
    public boolean onItemLongClick(AdapterView<?> p1, View view, int p3, long p4)
    {
      TSHolder holder = (TSHolder)view.getTag();
      try
      {
        xRowLongClick(holder.xGetRow());
      }
      catch ( Exception e )
      {
        TSLog.zErr(e);
        zReport(e.getMessage());
      }
      return true;
    }
  }
  protected abstract void xRowLongClick(TSRow row);
  
  private class ItemScrollListener implements OnScrollListener
  {
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState)
    {
      int position = view.getFirstVisiblePosition();
      //zReport("onscrollChanged state;"+scrollState +" pos;"+position);
      xRowScroll(scrollState,position);
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount)
    {
    }
  }
  protected abstract void xRowScroll(int state, int pos );
  
}

