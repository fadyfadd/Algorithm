package algo;

public class MultiplyMatrix {

    public static long[][] multiplyMatrix(long[][] m1 , long[][] m2) throws Exception {
        
        long[][] res = new long[m1.length][m2[0].length];

        long nbrOfRowsMatrixM1 = m1.length; 
        long nbrOfColumnMatrixM1 = m1[0].length; 
        long nbrOfRowsMatrixM2 = m2.length;
        long nbrOfColumnsMatrixM2 = m2[0].length;

        if (nbrOfColumnMatrixM1 != nbrOfRowsMatrixM2)
            throw new Exception("not of columns / rows not matching");

        for (int y = 0 ; y <=  nbrOfRowsMatrixM1- 1; y++) {
            for (  int x = 0 ; x <= nbrOfColumnsMatrixM2 - 1; x++) {
                for ( int c = 0 ; c <= nbrOfColumnMatrixM1 - 1 ; c++) {
                    res[y][x] = res[y][x] + m1[y][c] * m2[c][x];
                }
            }
        }

        return res; 
    }

    public static void main(String... args) throws Exception {
        
        long[][] m1 = {{1,2,3} , {4,5,8}};
        long[][] m2 = {{2 , 1} , {2,8} , {2,7}};

         System.out.println("matrix 1:");
         Utilities.printMatrix(m1);
         System.out.println("matrix 2:");
         Utilities.printMatrix(m2);
         System.out.println("result:");
         Utilities.printMatrix(multiplyMatrix(m1 , m2));
    }

}
