import java.util.*;
public class BFS_Graph_2{

    static HashMap<Integer,ArrayList<Integer>> adj = new HashMap<>();

    public static void addEdge(int u, int v){
        if(!adj.containsKey(u)){
            adj.put(u,new ArrayList<>());
        }
        if(!adj.containsKey(v)){
            adj.put(v,new ArrayList<>());
        }
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    public static void bfsTraversal(int sourceVertex,int v){
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[v];

        queue.add(sourceVertex);
        visited[sourceVertex] = true;

        while(!queue.isEmpty()){
            int vertex = queue.poll();
            System.out.print(vertex + " ");
            for(int adjVertex : adj.get(vertex)){
                if(!visited[adjVertex]){
                    queue.add(adjVertex);
                    visited[adjVertex] = true;
                }
            }
        }

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        
        for(int i = 0;i<e;i++){
            addEdge(sc.nextInt(), sc.nextInt());
        }
        int sourceVertex = sc.nextInt();
        bfsTraversal(sourceVertex,v);
        sc.close();
        
    }
}