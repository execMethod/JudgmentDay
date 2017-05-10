package com.neighborcell.testament.Task;

public interface TSTaskCallback<DATA>
{
  public static final int CALLBACK_STATUS_ERROR = -1;
  public static final int CALLBACK_STATUS_NOTIFY = 0;
  public static final int CALLBACK_STATUS_DONE = 1;
  //public static final int CALLBACK_STATUS_FINISH = 2;
  
  public void xCallback( int status, DATA data );
}

