import java.util.ArrayList;

class Graph {
    
    //Add Edge
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        //Undirected Graph
        adj.get(u).add(v);
        adj.get(v).add(u);
        //in case of directed graph only one statement needed.
    }
    
    //Print Graph
    static void printGraph(ArrayList<ArrayList<Integer>> adj) {
        for(int i = 0; i < adj.size(); i++) {
            System.out.print("Vertex " + i + ": ");
            for(int j = 0; j < adj.get(i).size(); j++){
                System.out.print(" -> " + adj.get(i).get(j));
            }
            System.out.println();
        }
    }
    
    public static void main (String[] args) {
        //nuber of Vertex
        int V = 5;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(V);
        
        //Store Vertex
        for(int i = 0; i < V; i++)
            graph.add(new ArrayList<Integer>());
            
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 1, 2);
        addEdge(graph, 3, 4);
        
        printGraph(graph);
    }
}
