package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};

        invert(arr);
        merge();
        BubbleSorter(arr);
        SelectionSorter(arr);
        InsertionSorter(arr);
        MatrixMul();
    }
//Лабораторная: proc.loop.matrix_mul
//    proc.loop.matrix_mul

    private static void MatrixMul() {
        int[][] matrix1 = new int[][]{
                {1, 0},
                {7, 8},
                {3, 4}};
        int[][] matrix2 = new int[][]{
                {3, 4, 5, 6},
                {9, 0, 1, 2}};
        int m = matrix1.length;
        int n = matrix2[0].length;
        int o = matrix2.length;
        int[][] result = new int[m][n];

        //1. Если один из аргументов равен null - throw new IllegalArgumentException().
        if ( matrix1 == null || matrix2 == null ) {
            throw new IllegalArgumentException();
        }
        //4. Если ширина первой матрицы не равна высоте второй матрицы - throw new IllegalArgumentException().
        if ( matrix1[0].length != matrix2.length ) {
            throw new IllegalArgumentException();
        }

        // 3. Если одна из матриц содержит null в качестве строки - throw new IllegalArgumentException().
        int count=0;
        for (int i = 0; i <matrix1.length ; i++) {
            if (matrix1[i]==null){
                count++;
            }
            if (count==matrix1.length){
                throw new IllegalArgumentException();
            }

        }
        int count2=0;
        for (int i = 0; i <matrix2.length ; i++) {
            if (matrix2[i]==null){
                count2++;
            }
            if (count2==matrix2.length){
                throw new IllegalArgumentException();
            }

        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < o; k++) {
                    result[i][j] += (matrix1[i][k] * matrix2[k][j]);
                }
            }
        }
        System.out.println("Multiply of matrix: ");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + "\t");
            }
            System.out.println();

        }

    }
//5. Лабораторная: proc.loop.insertion_sort_optimized
//    proc.loop.insertion_sort_optimized

    private static void InsertionSorter(int[] arr) {
        int k = 0;
        //for (int k = 1; k < arr.length-1; k++) {
        int newElement = arr[k];
        int location = k;
        Arrays.binarySearch(arr, k + 1, arr.length - 1, newElement);
        // while (location >= 0 && arr[location] > newElement) {
        System.arraycopy(arr, arr[location], arr, arr[location], 1);

        // arr[location + 1] = newElement;

        System.out.println("Insertion sorter: " + Arrays.toString(arr));
    }

//    Лабораторная: proc.loop.selection_sort_optimized
//    proc.loop.selection_sort_optimized

    private static void SelectionSorter(int[] arr) {

        for (int barrier = 0; barrier < arr.length - 1; barrier++) {
            int min = arr[barrier];
            int min_barrier = barrier;
            for (int index = barrier + 1; index < arr.length; index++) {

                if (arr[index] < min) {
                    min = arr[index];
                    min_barrier = index;
                }
            }
            if (barrier != min_barrier) {
                int tmp = arr[barrier];
                arr[barrier] = arr[min_barrier];
                arr[min_barrier] = tmp;
            }
        }
        System.out.println("Selection sort: " + Arrays.toString(arr));
    }

   // Лабораторная: proc.loop.bubble_sort_inverted
    //proc.loop.bubble_sort_inverted

    public static void BubbleSorter(int[] arr1) {
        arr1 = new int[]{4, 2, 6, 1, 5, 3};
        for (int barrier = 0; barrier < arr1.length - 1; barrier++) {
            for (int index = arr1.length - 1; index > barrier; index--) {
                if (arr1[index] < arr1[index - 1]) {
                    int tmp = arr1[index];
                    arr1[index] = arr1[index - 1];
                    arr1[index - 1] = tmp;
                }
            }
        }
        System.out.println("Bubble sort: " + Arrays.toString(arr1));
    }

//Лабораторная: proc.loop.array_merger_fixed
//    proc.loop.array_merger_fixed

    public static int[] merge() {
        int[] fst = {1, 2, 3, 4, 5, 6};
        int[] snd = {7, 8, 9, 10, 11, 12, 13};
        int[] result = new int[fst.length + snd.length];
        int fstIndex = 0;
        int sndIndex = 0;
        int index = 0;

        /*while (fstIndex + sndIndex != result.length) {
            if ((fst[fstIndex] < snd[sndIndex])&&(fstIndex == fst.length)&&(sndIndex!=snd.length)) {
                result[fstIndex + sndIndex] = fst[fstIndex++];

            } else {
                result[fstIndex + sndIndex] = snd[sndIndex++];

            }

            if ((fstIndex == fst.length)&&(sndIndex!=snd.length)) {*/
        System.arraycopy(fst, 0, result, 0, fst.length);
        System.arraycopy(snd, 0, result, fst.length, snd.length);
        //}
                /*while (fstIndex<fst.length){
                    result[index]=fst[fstIndex];
                    index++;
                    fstIndex++;
                }
                while (sndIndex<snd.length){
                    result[index]=snd[sndIndex];
                    index++;
                    sndIndex++;
                }*/
        System.out.println("Merged array: " + Arrays.toString(result));


        return result;
    }

//Лабораторная: proc.loop.array_inverter_optimized
 //   proc.loop.array_inverter_optimized

    private static void invert(int[] arr) {
        for (int k = arr.length / 2; k > 0; k--) {
            int tmp = arr[k - 1];
            arr[k - 1] = arr[arr.length - k];
            arr[arr.length - k] = tmp;
        }
        System.out.println("Inverted array: " + Arrays.toString(arr));
    }
}

