package binarySearch;

public class SearchInSortedAndRotatedArray {
    public static void main(String[] args) {
        int[] a = { 2,3,4,5,6,7,8,9,1 };

        System.out.println(search(a, 9));
        System.out.println(searchInSorted(a, 9, 0, a.length-1));
    }

    private static int searchInSorted(int[] a, int key, int left, int right) {

        if (left > right) {
            return -1;
        }

        if (a[left] == key) {
            return left;
        }

        if (a[right] == key) {
            return right;
        }

        int mid = left + ((right - left) / 2);

        if (a[mid] == key) {
            return mid;
        }

        /**
         * if (arr.get(mid) >= arr.get(low)) {
         * if (key >= arr.get(low) && key < arr.get(mid))
         * high = mid - 1;
         * else
         * low = mid + 1;
         * }
         * 
         * // Case 3: Right half is sorted
         * else {
         * if (key > arr.get(mid) && key <= arr.get(high))
         * low = mid + 1;
         * else
         * high = mid - 1;
         * }
         */
        if (a[mid] > a[right]) {
            if (key < a[right]) {
                return searchInSorted(a, key, mid + 1, right);
            }
            return searchInSorted(a, key, left, mid - 1);
        } else if (a[mid] < a[right]) {
            if (key > a[left]) {
                return searchInSorted(a, key, left, mid - 1);
            }
            return searchInSorted(a, key, mid + 1, right);
        }
        return -1;

    }

    private static int findPivot(int[] a, int low, int hi) {

        if (low > hi) {
            return -1;
        }

        if (a[low] <= a[hi]) {
            return low;
        }

        int mid = low + ((hi - low) / 2);
        if (a[mid] < a[hi]) {
            return findPivot(a, low, mid);
        }
        return findPivot(a, mid + 1, hi);
    }

    private static int findElement(int[] a, int low, int hi, int k) {
        if (low > hi) {
            return -1;
        }

        if (a[low] == k) {
            return low;
        }

        if (a[hi] == k) {
            return hi;
        }

        int mid = low + ((hi - low) / 2);
        if (a[mid] == k) {
            return mid;
        }

        if (k > a[mid]) {
            return findElement(a, mid + 1, hi, k);
        }
        return findElement(a, low, mid - 1, k);
    }

    private static int search(int[] a, int k) {
        int x = findPivot(a, 0, a.length - 1);
        if (x >= 0 && a[x] == k) {
            return x;
        }

        if (a[x] < k && k > a[a.length - 1]) {
            return findElement(a, 0, x - 1, k);
        }
        return findElement(a, x, a.length - 1, k);
    }

}
