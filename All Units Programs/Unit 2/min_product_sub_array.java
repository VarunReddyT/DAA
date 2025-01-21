import java.util.*;
public class min_product_sub_array{
    public static int minProd(int n, Scanner sc){
        int product = 1;
        int countZero = 0;
        int countNeg = 0;
        int minPos = Integer.MAX_VALUE;
        int maxNeg = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            int num = sc.nextInt();
            if(num == 0){
                countZero++;
                continue;
            }
            else if(num > 0){   
                minPos = Math.min(minPos,num);
            }
            else{
                countNeg++;
                maxNeg = Math.max(maxNeg, num);
            }
            product *= num;
        }
        if (countZero == n || (countNeg == 0 && countZero > 0)){
            return 0;
        }
        else if (countNeg == 0){
            return minPos;
        }
        else if (countNeg % 2 == 0){
            product = product / maxNeg;
        }
        return product;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(minProd(n,sc));
        sc.close();
    }
}
