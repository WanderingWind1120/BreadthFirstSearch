package org.example;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphMatrix {
    ArrayList<Node> NodeList;
    int[][] EdgeMatrix;

    public GraphMatrix(int size){
        NodeList = new ArrayList<>();
        EdgeMatrix = new int[size][size];
    }
    public void addNode(Node node){
        NodeList.add(node);
    }
    public void addEdge(int src, int dst){
        EdgeMatrix[src][dst] = 1;
    }
    public boolean checkEdge(int src, int dst){
        if(EdgeMatrix[src][dst] == 1){
            return true;
        }
        return false;
    }
    public void print(){
        System.out.print("  ");
        for (Node node: NodeList){
            System.out.print(node.data + " ");
        }
        for (int i = 0; i <= EdgeMatrix.length - 1 ; i++){
            System.out.print(NodeList.get(i).data + " ");
            for (int j = 0; j<= EdgeMatrix[i].length -1; j++){
                System.out.print(EdgeMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void BreadthFirstSearch (int src){
        boolean [] visited = new boolean[EdgeMatrix.length];
        Queue<Integer> queue = new LinkedList<>();

        visited[src] = true;
        queue.add(src);
        /*
        Nguyên lí search của BreadthFirstSearch là với phần từ khởi điểm search xem nó có thể đi trực tiếp đến
        các phần tử Node nào xong mới từ các phần tử Node tiếp có thể đi trực tiếp từ điểm xuất phát lại search
        tương tự
        Search theo chiều ngang, cắt theo lát bánh mì giống vs cái tên của nó trong tiếng anh
         */

        /*
        Nguyên lí xoay vòng để loop hết các phần tử của Algorithm này là sử dụng xoay quanh 3 method của queue
        queue.size() != 0, queue.poll(), queue .offer()
        còn phần gán src vs method poll để có thể đổi điểm xuất phát cho forloop phía bên dưới
        vì method poll của queue trước khi xóa nó đã lưu và return trả lại chính cái phần tử nó xóa
        không thể call trực tiếp nó dưới for loop vì làm như vậy sẽ khiến cho nó lưu biến khác 
         */
        while(queue.size() != 0){
            src = queue.poll();
            System.out.println(NodeList.get(src).data + " = visited");

            for (int i = 0; i<= EdgeMatrix[src].length -1; i++)
                if(EdgeMatrix[src][i] == 1 && visited[i] !=true){
                    queue.offer(i);
                    visited[i] = true;
                }

        }

    }
}
