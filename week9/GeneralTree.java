public class GeneralTree {
    static final int MAX = 100;
    static String[] data = new String[MAX];
    static int[] fc = new int[MAX];     // First Child
    static int[] ns = new int[MAX];     // Next Sibling 
    static int[] parent = new int[MAX]; // Parent 
    static int n = 0;                   

    static int addNode(String val, int p) {
        int id = n++;
        data[id] = val;
        fc[id] = -1;
        ns[id] = -1;
        parent[id] = p;

        if (p != -1) {
            if (fc[p] == -1) {
                fc[p] = id;
            } else {
                int temp = fc[p];
                while (ns[temp] != -1) {
                    temp = ns[temp];
                }
                ns[temp] = id;
            }
        }
        return id;
    }

    static int getParent(int u) {
        return (u >= 0 && u < n) ? parent[u] : -1;
    }

    static int getFirstChild(int u) {
        return (u >= 0 && u < n) ? fc[u] : -1;
    }

    static int getNextSibling(int u) {
        return (u >= 0 && u < n) ? ns[u] : -1;
    }

    public static void main(String[] args) {
        // testing
        int root = addNode("A", -1); // 0
        int b = addNode("B", root);  // 1
        int c = addNode("C", root);  // 2
        int d = addNode("D", root);  // 3
        int e = addNode("E", b);     // 4
        int f = addNode("F", b);     // 5

        System.out.println("First child of A: " + data[getFirstChild(root)]); 
        System.out.println("Next sibling of B: " + data[getNextSibling(b)]);   
        System.out.println("Parent of F: " + data[getParent(f)]);            
    }
}