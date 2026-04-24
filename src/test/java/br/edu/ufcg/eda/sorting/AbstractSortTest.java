package br.edu.ufcg.eda.sorting;

import br.edu.ufcg.eda.algorithms.Algorithm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class AbstractSortTest {

    protected Algorithm implementation;

    protected abstract Algorithm getImplementation();

    @BeforeEach
    void setup() {
        this.implementation = getImplementation();
    }

    @Test
    void shouldSortEmptyArray() {
        assertSortsToExpected(new int[] {});
    }

    @Test
    void shouldSortSingleElementArray() {
        assertSortsToExpected(new int[] { 42 });
    }

    @Test
    void shouldKeepTwoElementsSorted() {
        assertSortsToExpected(new int[] { 1, 2 });
    }

    @Test
    void shouldSortTwoElementsReversed() {
        assertSortsToExpected(new int[] { 2, 1 });
    }

    @Test
    void shouldSortThreeElementsMixed() {
        assertSortsToExpected(new int[] { 2, 3, 1 });
    }

    @Test
    void shouldSortAlreadySortedTenElements() {
        assertSortsToExpected(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
    }

    @Test
    void shouldSortReverseSortedTenElements() {
        assertSortsToExpected(new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 });
    }

    @Test
    void shouldSortAllEqualValues() {
        assertSortsToExpected(new int[] { 7, 7, 7, 7, 7, 7, 7, 7 });
    }

    @Test
    void shouldSortArrayWithSimpleDuplicates() {
        assertSortsToExpected(new int[] { 3, 1, 2, 3, 2, 1, 3 });
    }

    @Test
    void shouldSortArrayWithManyDuplicates() {
        assertSortsToExpected(new int[] { 5, 1, 5, 2, 5, 3, 5, 4, 5, 0, 5 });
    }

    @Test
    void shouldSortOnlyNegativeNumbers() {
        assertSortsToExpected(new int[] { -3, -1, -7, -4, -5, -2, -6 });
    }

    @Test
    void shouldSortMixedNegativeZeroAndPositive() {
        assertSortsToExpected(new int[] { -10, 0, 5, -3, 2, -1, 8, 0 });
    }

    @Test
    void shouldSortIncludingIntegerLimits() {
        assertSortsToExpected(new int[] { Integer.MAX_VALUE, 0, -1, Integer.MIN_VALUE, 1 });
    }

    @Test
    void shouldSortZerosAndNegatives() {
        assertSortsToExpected(new int[] { 0, -1, 0, -2, 0, -3, 0 });
    }

    @Test
    void shouldSortAlternatingHighLowPattern() {
        assertSortsToExpected(new int[] { 100, 1, 99, 2, 98, 3, 97, 4, 96, 5 });
    }

    @Test
    void shouldSortOddLengthArray() {
        assertSortsToExpected(new int[] { 9, 1, 8, 2, 7, 3, 6 });
    }

    @Test
    void shouldSortEvenLengthArray() {
        assertSortsToExpected(new int[] { 8, 1, 7, 2, 6, 3, 5, 4 });
    }

    @Test
    void shouldSortArrayWithLargeGaps() {
        assertSortsToExpected(new int[] { 10000, -10000, 5000, -5000, 0, 1234, -1234 });
    }

    @Test
    void shouldSortRepeatedBlocks() {
        assertSortsToExpected(new int[] { 4, 3, 2, 1, 4, 3, 2, 1, 4, 3, 2, 1 });
    }

    @Test
    void shouldSortNearlySortedArray() {
        assertSortsToExpected(new int[] { 1, 2, 3, 5, 4, 6, 7, 8, 9, 10 });
    }

    @Test
    void shouldSortNearlyReverseSortedArray() {
        assertSortsToExpected(new int[] { 10, 9, 8, 7, 6, 4, 5, 3, 2, 1 });
    }

    @Test
    void shouldSortArrayWithManyZeros() {
        assertSortsToExpected(new int[] { 0, 0, 0, 1, 0, -1, 0, 2, 0, -2, 0 });
    }

    @Test
    void shouldSortPalindromicValues() {
        assertSortsToExpected(new int[] { 5, 4, 3, 2, 1, 2, 3, 4, 5 });
    }

    @Test
    void shouldSortPowerOfTwoLengthArray() {
        assertSortsToExpected(new int[] { 16, 1, 15, 2, 14, 3, 13, 4, 12, 5, 11, 6, 10, 7, 9, 8 });
    }

    @Test
    void shouldSortPrimeLengthArray() {
        assertSortsToExpected(new int[] { 11, 3, 7, 2, 5, 1, 13, 8, 6, 4, 10 });
    }

    @Test
    void shouldSortDescendingWithDuplicates() {
        assertSortsToExpected(new int[] { 9, 9, 8, 8, 7, 7, 6, 6, 5, 5, 4, 4 });
    }

    @Test
    void shouldSortFixedRandomCaseSmall() {
        assertSortsToExpected(new int[] { 4, -2, 9, 0, 1, -5, 7, 3, -1, 8 });
    }

    @Test
    void shouldSortFixedRandomCaseMedium() {
        assertSortsToExpected(new int[] { 12, -7, 5, 0, 19, -3, 8, 2, 2, -8, 17, 11, -1, 4, 6, -6, 14, 9, 3, -2 });
    }

    @Test
    void shouldSortFixedRandomCaseLarge() {
        assertSortsToExpected(new int[] { 31, -12, 7, 45, 0, -1, 18, 18, 4, -9, 23, 11, -6, 8, 29, -15, 3, 16, -2, 5,
                40, -20, 14, 9, -4, 27, 1, 33, -8, 2 });
    }

    @Test
    void shouldBeIdempotentWhenSortedTwice() {
        int[] array = { 9, 4, 7, 1, 3, 2, 8, 6, 5 };
        int[] expected = sortedCopy(array);

        implementation.run(array);
        implementation.run(array);

        assertThat(array).isSorted();
        assertThat(array).containsExactly(expected);
    }

    @Test
    void shouldSortLargeReverseInput() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = 100 - i;
        }
        assertSortsToExpected(array);
    }

    private void assertSortsToExpected(int[] input) {
        int[] array = Arrays.copyOf(input, input.length);
        int[] expected = sortedCopy(input);

        implementation.run(array);

        assertThat(array).isSorted();
        assertThat(array).containsExactly(expected);
    }

    private int[] sortedCopy(int[] input) {
        int[] expected = Arrays.copyOf(input, input.length);
        Arrays.sort(expected);
        return expected;
    }
}
