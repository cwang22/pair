package me.seewang.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import me.seewang.util.Pair;

import org.junit.Before;
import org.junit.Test;

public class TestPair {
  
  
  @Before
  public void setUp(){
    
  }
  
  @Test
  public void testEuqalsAndHashCode() {
    Pair<String, Integer> p1 = Pair.of("Harry Potter",
        1);
    Pair<String, Integer> p2 = Pair.of("Harry Potter",
        1);
    Pair<String, Integer> p3 = Pair.of("Ron Wesley",
        3);
    Pair<String, Integer> p4 = Pair.of("Harry Potter",
        4);

    // equal but not same
    assertEquals(p1, p2);
    assertNotSame(p1, p2);
    // have equal hash code to be used as HashMap key
    assertEquals(p1.hashCode(), p2.hashCode());
    assertFalse(p1.equals(p3));
    assertFalse(p1.equals(p4));
  }
  
  @Test
  public void testComparble(){
    Pair<Integer, String> p1 = Pair.of(1, "Harry");
    Pair<Integer, String> p2 = Pair.of(3, "Harry");
    Pair<Integer, String> p3 = Pair.of(3, "Harry");
    assertEquals(1,p1.compareTo(p2));
    assertEquals(-1,p2.compareTo(p1));
    assertEquals(0,p2.compareTo(p3));
    
    List<Pair<Integer, String>> l1 = new ArrayList<Pair<Integer, String>>();
    List<Pair<Integer, String>> l2 = new ArrayList<Pair<Integer, String>>();
    
    l1.add(p1);
    l1.add(p2);
    l1.add(p3);
    
    l2.add(p3);
    l2.add(p2);
    l2.add(p1);
    
    Collections.sort(l1);
    assertEquals(l1,l2);
  }
}
