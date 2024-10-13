package ru.nvn.leetcode.BigTech.stack;

import java.util.Arrays;
import java.util.Stack;

public class P_735 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(asteroidCollision(new int[]{8, -8})));

    }

    //
    //  5,10,-5
    //

    // 5, 10 , -5 , 11, -12
    // 1. p1
    public static int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null) {
            return null;
        }

        Stack<Integer> stack = new Stack<>();

        for (int a : asteroids) {
            if (!stack.isEmpty() && stack.peek() > Math.abs(a)) {
                continue;
            } else if (!stack.isEmpty() && stack.peek() <= Math.abs(a) && a < 0) {
                while (!stack.isEmpty() && stack.peek() <= Math.abs(a)) {
                    stack.pop();
                }
            }
            stack.push(a);
        }

        for (int a : asteroids) {
            // Handle collisions only if a is negative and stack.peek() is positive
            boolean hasCollided = false;

            while (!stack.isEmpty() && stack.peek() > 0 && a < 0) {
                if (stack.peek() == Math.abs(a)) {
                    // If they are the same size, both explode
                    stack.pop();
                    hasCollided = true;
                    break;
                } else if (stack.peek() > Math.abs(a)) {
                    // If stack's asteroid is larger, incoming asteroid explodes
                    hasCollided = true;
                    break;
                } else {
                    // If incoming asteroid is larger, stack's top asteroid explodes
                    stack.pop();
                }
            }

            // Push the asteroid to stack if no collision or it survives the collision
            if (!hasCollided) {
                stack.push(a);
            }
        }

// Create an array to store the elements of the stack
        int[] result = new int[stack.size()];

        // Fill the array by popping elements from the stack (top to bottom)
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
