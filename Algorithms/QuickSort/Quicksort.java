package Algorithms.QuickSort;

import java.util.Random;

public class Quicksort {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(100);
        }

        System.out.println("Before:");
        printArray(numbers);

        quicksort(numbers, 0, numbers.length - 1);

        System.out.println("\nAfter:");
        printArray(numbers);
    }

    private static void quicksort(int[] array, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) return;

        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, highIndex);

        int leftPointer = partition(array, lowIndex, highIndex, pivot);

        quicksort(array, lowIndex, leftPointer - 1);
        quicksort(array, leftPointer + 1, highIndex);
    }

    private static int partition(int[] array, int lowIndex, int highIndex, int pivot) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer < rightPointer) {

            while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }

            while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }

            swap(array, leftPointer, rightPointer);
        }

        swap(array, leftPointer, highIndex);
        return leftPointer;
    }

    private static void swap(int[] array, int indexOne, int indexTwo) {
        int temp = array[indexOne];

        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
    }

    private static void printArray(int[] numbers) {
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
