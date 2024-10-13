package ru.nvn.leetcode.BigTech.BinarySearch;

public class P_74 {

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 23));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rowIdx = searchPotentialRow(matrix, target);
        if (rowIdx != -1) {
            return binarySearchOverRow(rowIdx, matrix, target);
        }
        return false;
    }

    private static int searchPotentialRow(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (matrix[mid][0] <= target && target <= matrix[mid][matrix[0].length - 1]) {
                return mid;
            } else if (matrix[mid][0] < target) {
                low = mid + 1;
            } else if (matrix[mid][0] > target) {
                high = mid - 1;
            }
        }
        return -1;
    }

    private static boolean binarySearchOverRow(int rowIdx, int[][] matrix, int target) {
        int low = 0;
        int high = matrix[rowIdx].length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (matrix[rowIdx][mid] == target) {
                return true;
            } else if (matrix[rowIdx][mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
