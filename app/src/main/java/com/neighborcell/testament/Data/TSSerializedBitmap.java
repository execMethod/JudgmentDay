package com.neighborcell.testament.Data;
import android.graphics.*;
import android.util.*;
import java.io.*;

public class TSSerializedBitmap implements Serializable
{
  private String src = "";
  
  public TSSerializedBitmap( Bitmap bitmap )
  {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
    src = Base64.encodeToString(baos.toByteArray(), Base64.DEFAULT);
  }
  
  public Bitmap zDecode()
  {
    //BitmapFactory.Options options = new BitmapFactory.Options();
    byte[] bytes = Base64.decode(src, Base64.DEFAULT);
    return BitmapFactory.decodeByteArray(bytes, 0, bytes.length).copy(Bitmap.Config.ARGB_8888, true);
  }
}

