public class newSorting {
/*Recursively sorts an array in ascending order. If the size of the array is less than or equal to the size parameter, the array is sorted by the quicksort algorithm.
Otherwise, the array is divided into 2 halves and newSorting() method called again with the halved arrays as parameters*/

    public void newSorting(int[] A, int size) {
        if (A.length <= size) {
            quickSortHelper(A);
        }
        else {
            int mid = A.length / 2;
            int[] leftSide = new int[mid];
            int[] rightSide = new int[A.length - mid];
            for (int i = 0; i < leftSide.length; i++) {
                leftSide[i] = A[i];
            }

            for (int i = 0; i < rightSide.length; i++) {
                rightSide[i] = A[i + (A.length - mid)];
            }
            newSorting(leftSide, size);
            newSorting(rightSide, size);
            mergeSortedHalves(leftSide, rightSide, A); //merges sorted halves
        }
    }

    /*This method takes in the sorted left sides and right sides of an array and merges them in alphanumerically order in the original undivided array, A*/

    private void mergeSortedHalves(int[] leftSide, int[] rightSide, int[] A) {
        int i = 0; int j = 0;
        int k = 0; //initial index of merged array

    /*while perusing the left side array and right side array one-by-one, if the value of the number in the left array is less than that of the right array, that left side number comes
    first in the merged array. Otherwise, the right side number comes first in the merged array*/

        while (i < leftSide.length && j < rightSide.length) {
            if (leftSide[i] <= rightSide[j]) {
                A[k] = leftSide[i];
                i++;
            }

            else {
                A[k] = rightSide[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of left side array if any */
        while (i < leftSide.length)
        {
            A[k] = leftSide[i];
            i++;
            k++;
        }

        /* Copy remaining elements of right side array if any */
        while (j < rightSide.length)
        {
            A[k] = rightSide[j];
            j++;
            k++;
        }
    }

    private void quickSortHelper (int[] A){
        quickSort(A, 0, A.length-1);
    }

    /*Recursively sorts an array by partitioning the contents of the array about a "pivot", then sorting the elements below and above the pivot by calling the method again. The process repeats
     * until the pivot can't be swapped anymore (ie start is no longer < end)*/
    private void quickSort(int[] A, int start, int end) {
        if (start < end) {

            int partIndex = partition(A, start, end);//contains index position of pivot

            quickSort(A, start, partIndex-1);//sorts array from index 0 to the position just before the pivot
            quickSort(A, partIndex+1, end);//sorts array from index just above the pivot to the last element of the array
        }
    }

    /*Partitions array by placing elements less than the pivot below it and elements greater than the pivot above it.
     * Takes in the array, index start of the array and index of the last element (end) of the array as parameters
     * Got help from geekforgeeks.org*/

    private int partition(int[] A, int start, int end) {
        int pivot = A[end]; //pivot is the last element in array
        int i = (start - 1);

        /*while going through the array from index 1 to the end of the array, if the current element is less than the pivot, increment index i and swap the current element with the element
         * after it*/
        for (int j = start; j < end; j++) {
            if (A[j] < pivot) {
                i++;

                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }

        /*Once the current element is not less than the pivot, its position is swapped with that of the pivot*/
        int temp = A[i + 1];
        A[i + 1] = A[end];
        A[end] = temp;

        /*The index of the new position of the pivot is returned*/
        return i + 1;
    }
}

