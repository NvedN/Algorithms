//package ru.nvn.sprint_2;
//
//
//import java.io.IOException;
//import java.util.Scanner;
//
//public class SolutionB {
//
//  public static void solution(Node<String> head) {
//    while (head!= null){
//
//      System.out.println(head.value);
//      head = head.next;
//    }
//    // Your code
//    // ヽ(´▽`)/
//  }
//
//
//  public static void main(String[] args) throws IOException {
//
//    Node<String> node3 = new Node<>("Сходить в магазин", null);
//    Node<String> node2 = new Node<>("Сделать домашнее задание по математике", node3);
//    Node<String> node1 = new Node<>("Пообедать", node2);
//    Node<String> node0 = new Node<>("Сделать домашнее задание по литературе", node1);
//    solution(node0);
//
//  }
//
//}
