
class Matrix_Chain_Multiplication {

    
    static int minMultRec(int arr[], int i, int j) {

        if (i + 1 == j)
            return 0;

        int res = Integer.MAX_VALUE;

        for (int k = i + 1; k < j; k++) {
            int curr = minMultRec(arr, i, k)
                       + minMultRec(arr, k, j)
                       + arr[i] * arr[k] * arr[j];

            res = Math.min(curr, res);
        }

        return res;
    }

    static int matrixMultiplication(int arr[]) {
        
        int n = arr.length;
        return minMultRec(arr, 0, n - 1);
    }

    public static void main(String[] args) {
      
        int arr[] = {40, 20, 30, 10, 30};
        int res = matrixMultiplication(arr);
        System.out.println("The minimum count of scalar multiplication will be"+res);
    }
}