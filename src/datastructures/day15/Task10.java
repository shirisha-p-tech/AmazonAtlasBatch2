// Graph and Edges
package datastructures.day15;

class Graph {
   class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    int vertex;
    int edge;
    Edge[] ed;

    Graph(int vertex, int edge) {
        this.vertex = vertex;
        this.edge = edge;
        ed = new Edge[edge];
    }

    void displayEdges() {
        System.out.println("Number of vertices: " + vertex);
        System.out.println("Number of edges: " + edge);
        System.out.println("Edges:");
        for (int i = 0; i < edge; i++) {
            System.out.println(ed[i].src + " - " + ed[i].dest);
        }
    }
}

public class Task10{
    public static void main(String[] args) {
        int vertex = 5;
        int edge = 8;

        Graph gr = new Graph(vertex, edge);

        gr.ed[0] = gr.new Edge(1, 2);
        gr.ed[1] = gr.new Edge(1, 3);
        gr.ed[2] = gr.new Edge(1, 4);
        gr.ed[3] = gr.new Edge(2, 4);
        gr.ed[4] = gr.new Edge(2, 5);
        gr.ed[5] = gr.new Edge(3, 4);
        gr.ed[6] = gr.new Edge(3, 5);
        gr.ed[7] = gr.new Edge(4, 5);

        gr.displayEdges();
    }
}



