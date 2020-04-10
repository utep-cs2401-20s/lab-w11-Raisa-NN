import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class newSortingTester {
    @Test
    /*This test is used to determine the overall general functionality of the quickSort() method. Since the size is 6, base case has been achieved so quickSort is called immediately.
     * This test passed implying that both the test case and code is correct.*/
    public void newSorting1() {
        newSorting ns = new newSorting();
        int[] A = {10, 7, 8, 9, 1, 5};
        int[] expected = {1, 5, 7, 8, 9, 10};
        ns.newSorting(A, 6);
        assertArrayEquals(expected, A);
    }

    @Test
    /*This test is used to determine the overall general functionality of the newSorting() method. Since the size is 5, array has be halved, sorted and merged again.
     * This test passed implying that both the test case and code is correct.*/
    public void newSorting2() {
        newSorting ns = new newSorting();
        int[] A = {10, 7, 8, 9, 1, 5};
        int[] expected = {1, 5, 7, 8, 9, 10};
        ns.newSorting(A, 5);
        assertArrayEquals(expected, A);
    }

    @Test
    /*This test is used to determine the functioning of the newSorting() method when challenged with a mix of positive and negative numbers.
     * This test passed implying that both the test case and code is correct.*/
    public void newSorting3() {
        newSorting ns = new newSorting();
        int[] A = {-10, 7, -8, 9, 1, 5};
        int[] expected = {-10, -8, 1, 5, 7, 9};
        ns.newSorting(A, 3);
        assertArrayEquals(expected, A);
    }

    @Test
    /*This test is used to determine the functioning of the newSorting() method when challenged with repeating numbers.
     * This test passed implying that both the test case and code is correct.*/
    public void newSorting4() {
        newSorting ns = new newSorting();
        int[] A = {10, 8, 8, 9, 1, 1};
        int[] expected = {1, 1, 8, 8, 9, 10};
        ns.newSorting(A, 6);
        assertArrayEquals(expected, A);
    }

    @Test
    /*This test is used to determine the behaviour of the newSorting method when the array is already sorted, but in descending order
     * This test passed implying that both the test case and code is correct.*/
    public void newSorting5() {
        newSorting ns = new newSorting();
        int[] A = {10, 9, 8, 7, 6, 5};
        int[] expected = {5, 6, 7, 8, 9, 10};
        ns.newSorting(A, 3);
        assertArrayEquals(expected, A);
    }
}
