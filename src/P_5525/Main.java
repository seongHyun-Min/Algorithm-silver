import java.util.*;
import java.io.*;


public class Main
{
    static int N;
    static ArrayList<ArrayList<Node>> arr;
    static int[] dist;
    static Queue<Node> q;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new ArrayList();
        for(int i=0; i<=N; i++){
            arr.add(new ArrayList());
        }
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            arr.get(start).add(new Node(end ,weight));
            arr.get(end).add(new Node(start ,weight));
        }




    }
    static class Node{
        int edge;
        int weight;

        public Node(int edge, int weight){
            this.edge =edge;
            this.weight =weight;
        }
    }
}