package com.neighborcell.judgmentday.Data;

import com.neighborcell.testament.Util.*;
import java.io.*;
import java.util.*;

public class JDPacking implements Serializable
{
  private List<JDRowTerminal> terminals = new ArrayList<JDRowTerminal>();
  
  public void addTerminal( JDRowTerminal terminal )
  {
    terminals.add(terminal);
  }
  
  public List<JDRowTerminal> getTerminals()
  {
    return terminals;
  }
  
}

