package algo;
public class PrintFibonacciSeries {


    private static void printFibonacciSeries(Long n) throws Exception {       
       
       if (n<0)
        throw new Exception("should be positive"); 

        System.out.print(1 + " "); 

        if (n>=2)
            System.out.print(1 + " ");         

        var n1 = 1; 
        var n2 = 1;
        var sum = n1 + n2;       

        for (int i = 1 ; i <= n - 2 ; i++ ) {
            System.out.print(sum + " ");            
            n1 = n2; 
            n2 = sum;  
            sum = n1 + n2;                   
        }           
    }

    public static void main(String... args) throws Exception {
        printFibonacciSeries(10L); 
    }
}
