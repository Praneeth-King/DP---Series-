package Graphs;
// create a method that will return List<Integer>
// create a list, queue, boolean visted[], 
// add root in queue and make visted[root] = true;
// while(!q.isEmpty()){
//     Integer node = q.poll();
//     ans.add(node);
//     for(Integer ele : adj){
//         if(visted[node] != true){
//         q.add(ele);
//         visted[ele] = true;
//}
//     }
// }
// return ans;
import  java.util.*;

class bfs {
    public static void main(String[] args) {
       List < List < Integer >> adj = new ArrayList <>();
       Scanner sc = new Scanner(System.in);
       String input = sc.nextLine();
        // Step 1: Remove the outer brackets and split the inner arrays
        input = input.substring(1, input.length() - 1); // remove first and last brackets
        String[] parts = input.split("\\],\\s*\\["); // split by "],[" with optional space

       // List<List<Integer>> adj = new ArrayList<>();

        for (String part : parts) {
            part = part.replace("[", "").replace("]", ""); // clean up brackets
            List<Integer> neighbors = new ArrayList<>();

            if (!part.isEmpty()) {
                for (String numStr : part.split(",")) {
                    neighbors.add(Integer.parseInt(numStr.trim()));
                }
            }
            adj.add(neighbors);
        }

        List < Integer > ans = bfs(adj);
//         for (int i = 0; i < adj.size(); i++) {
//     System.out.print(i + "-> ");
//     for (int neighbor : adj.get(i)) {
//         System.out.print(neighbor + " ");
//     }
//     System.out.println();
// }

        System.out.println(adj);
        System.out.print(ans);
    }
    
    static List<Integer> bfs(List<List<Integer>> adj ){
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[adj.size()+1];
        q.add(0);
        vis[0] = true;
        while(!q.isEmpty()){
            Integer node = q.poll();
            ans.add(node);
            for(Integer ele : adj.get(node)){
                if(vis[ele] != true){
                    q.add(ele);
                    vis[ele] = true;
                }
            }
        }
        return ans;
        
    }
}