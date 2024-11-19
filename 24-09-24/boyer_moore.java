// Boyer - Moore Voting Algorithm
public class boyer_moore {
    public static void main(String[] args) {
        int[] arr = {2,2,1,1,1};
        int count = 0;
        Integer candidate = null;
        for(int num : arr){
            System.out.println("Num is : " + num);
            if(count == 0){
                candidate = num;
                System.out.println("Candidate : " + candidate);
            }
            System.out.println("Before count : " + count);
            count += (num == candidate) ? 1 : -1;
            System.out.println("After count : " + count);
        }
        System.out.println(candidate);
    }
}
