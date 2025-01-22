import java.util.*; 

public class HappyNumber {
    static public boolean isHappy(int n,ArrayList<Integer> arr){
        if(n==1){
            return true;
        }
        int sum = 0;
        while(n>0){
            sum += (n%10)*(n%10);
            n = n/10;
        }
        if(arr.contains(sum)){
            return false;
        }
        arr.add(sum);
        return isHappy(sum, arr);
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        System.out.println(isHappy(n,arr));
        sc.close();
    }
}
