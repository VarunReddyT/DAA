
public class labels {
    public static void main(String[] args) {
        o1 : for(int i = 0; i<10;i++){
            for(int j = 0;j<10;j++){
                for(int k = 0;k<10;k++){
                    for(int p = 0;p<10;p++){
                        System.out.println(k+p);
                        if(k+p == 11){
                            break o1;
                        }
                    }
                }
            }
        }
    }
}
