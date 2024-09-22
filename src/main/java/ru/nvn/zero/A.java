package ru.nvn.zero;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Predicate;

public class A {
  public static void main(String[] args) throws IOException {
    Predicate<Object> p = Predicate.isEqual(2).and(Predicate.isEqual(null));
    System.out.println(p.test(2));

    Spice sp1  = Spice.A;
    Object ob1 = (Object) sp1;


    Object obj3 = new Object();
    Spice sp3 = (Spice) obj3;


  }

  public void checkName(String name){
//    ConcurrentSkipListMap
//    SoncurrentSkipListMapd
    if( name.equals("Jhon")){
      System.out.println("Correct me");
    }else{
      throw new RuntimeException();
    }
  }
}
