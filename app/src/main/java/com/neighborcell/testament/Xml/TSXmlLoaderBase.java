package com.neighborcell.testament.Xml;

import android.content.*;
import com.neighborcell.testament.Util.*;
import java.io.*;
import java.util.*;
import org.xmlpull.v1.*;

public abstract class TSXmlLoaderBase<NODE>
{
  private List<NODE> nodes = new ArrayList<NODE>();

  public List<NODE> zGetNodes()
  {
    return nodes;
  }
  
  protected void zAddNode(NODE node)
  {
    nodes.add(node);
  }

  //protected abstract int abGetXml();
  protected abstract void xStartTag(XmlPullParser xpp, String name);
  protected abstract void xEndTag(XmlPullParser xpp, String name);
  protected abstract void xTextTag(XmlPullParser xpp, String text);
  
  public void zParse(String xml)
  {
    zParse( new StringReader(xml) );
  }
  
  public void zParse(Reader xml)
  {
    //XmlResourceParser xpp = null;
    XmlPullParserFactory factory = null;
    XmlPullParser xpp = null;
    
    try
    {
      factory = XmlPullParserFactory.newInstance();
      factory.setNamespaceAware(true);
      
      xpp = factory.newPullParser();
      xpp.setInput( xml );
      
      //int xml = getXml();
      int event;

      //xpp = res.getXml(xml);
      event = xpp.getEventType();
      while (event != XmlPullParser.END_DOCUMENT)
      {
        switch (event)
        {
          case XmlPullParser.START_DOCUMENT:
            break;

          case XmlPullParser.START_TAG:
            xStartTag(xpp, xpp.getName() );
            break;

          case XmlPullParser.END_TAG:
            xEndTag(xpp, xpp.getName() );
            break;
          
          case XmlPullParser.TEXT:
            String tmp = xpp.getText();
            if( null == tmp )
            {
              break;
            }
            tmp = tmp.trim();
            if ( tmp.length() > 0 )
            {
              xTextTag(xpp, tmp );
            }
            break;

          default:
            break;
        }
        event = xpp.next();
      }
    }
    catch (XmlPullParserException e)
    {
      TSLog.zErr(e);
    }
    catch (IOException e)
    {
      TSLog.zErr(e);
    }
    catch (Exception e)
    {
      TSLog.zErr(e);
    }
    //finally
    //{
    //  xpp.close();
    //}
  }
}
