// Karthik is embarking on a world tour, and he prefers to travel by airplane. 
// He is given a list of available flight routes, where each route is represented as plane[i] = [src-i, dest-i], indicating an airplane flying from the source city src-i to the destination city dest-i.

// Your task is to determine the final city in Karthik's world tour, i.e., the city where Karthik will end up and from which he cannot travel further.

// Note: It is guaranteed that there are no loops in the routes, meaning Karthik will eventually reach a city with no outgoing flights.

// Input Format:
// -------------
// Line-1: The first line contains an integer N, representing the number of flight routes.
// Line-2 to N: The next N lines each contain two comma-separated strings, representing a flight route from a source city to a destination city.

// Output Format:
// --------------
// Line-1: Print the name of the city where Karthik's world tour will end.

// Constraints:
// -------------
// There are no loops in the given flight routes, ensuring that Karthik will always end up in a city with no further flight options.

// Sample Input-1:
// ---------------
// 3
// London,New York
// New York,Sydney
// Sydney,New Delhi

// Sample Output-1:
// ---------------
// New Delhi

// Explanation:
// ------------
// Karthik starts in London, flies to New York, then to Sydney, and finally to New Delhi. 
// Since there are no more outgoing flights from New Delhi, this is where his tour ends.

// Sample Input-2:
// ---------------
// 4
// Tokyo,Beijing
// Beijing,Delhi
// Delhi,Moscow
// Moscow,Berlin

// Sample Output-2:
// ----------------
// Berlin

// Explanation:
// -------------
// Karthik starts in Tokyo and flies through various cities, ending up in Berlin, where there are no further flights.
import java.util.*;

public class world_tour{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        HashMap<String,String> freq = new HashMap<>();
        String start = "";
        for(int i = 0;i<n;i++){
            String[] temp = sc.nextLine().split(",");
            freq.put(temp[0],temp[1]);
            if(i==0){
                start = temp[0];
            }
        }
        while(freq.containsKey(start)){
            start = freq.get(start);
        }
        System.out.println(start);
        sc.close();        
    }
}