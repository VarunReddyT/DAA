import java.util.*;

public class pow{
    static public float power(int x, int y){
        if(y == 0){
            return 1;
        }
        float temp, res;
        temp = power(x,y/2);
        if(y%2 == 0){
            res = temp*temp;
        }
        else{
            if(y>0){
                res = x*temp*temp;
            }
            else{
                res = (temp*temp)/x;
            }
        }
        return res;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        System.out.println(power(n,p));
        sc.close();
    }
}

//Another Approach Using divide and conquer

class Alternate{
static public float power(int x, int y){
    if(y==0) return 1;
    else if(y==1) return x;
    else if(y==-1) return (float)1/x;
    float  res;
    int mid=(y/2);
    float left = power(x,mid);
    float right=power(x,y-mid);
    if(y>0) res = left*right;
    else res=left*right;//if y is -ve
    return res;
}
}