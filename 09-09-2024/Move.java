// Move all 0s to the end. Maintain the order of non-zero elements
public class Move {
    public static void main(String[] args) {
        int[] arr = {1,0,3,0,0,2,0,0,9,0,4};
        int temp;
        for(int i = 0;i<arr.length;i++){
            for(int j = i+1;j<arr.length;j++){
                if(arr[i]==0){
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
    }
}

