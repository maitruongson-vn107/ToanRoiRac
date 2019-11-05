package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static int indexInArray(int x, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (x == arr[i])
                return i;
        }
        return -1;
    }

    public static void printArray(int[] color) {
        for (int value : color) {
            System.out.print(value + " ");
        }
    }

    public static boolean checkEdge(int x, int y, int[][] link) {
        for (int[] ints : link) {
            if ((ints[0] == x && ints[1] == y) || (ints[1] == x && ints[0] == y)) {
                return true;
            }
        }
        return false;
    }

    public static void coloring(int x, int nodes, int[][] link, int[] deg, int[] color) {
        color[x] = 1;                                                     //mau cua dinh x, gan bang 1
        int[] colorEdge = new int[nodes];
        for (int i = 0; i < nodes; i++) {
            if (checkEdge(x, i, link)) {
                colorEdge[i] = color[i];
            }
        }
        while (indexInArray(color[x], colorEdge) > -1) {
            color[x]++;
        }
    }

    public static void greedyAlgorithm(int nodes, int[][] link, int[] deg, int[] color) {
        for (int i = 0; i < nodes; i++) {
            coloring(i, nodes, link, deg, color);
        }
    }

    public static void main(String[] args) throws IOException {
        //Doc file
        File file = new File("dothi.txt");
        if(!file.exists()) file.createNewFile();
        ArrayList dataInput = new ArrayList();
        try (Scanner sc = new Scanner(file)) {
            int data;
            while (sc.hasNextInt()) {
                data = sc.nextInt();
                dataInput.add(data);
            }
        }
        if ((int) dataInput.get(1) == (dataInput.size() / 2) - 1) {
            int nodes = (int) dataInput.get(0);
            dataInput.remove(0);
            int[] color = new int[nodes];
            int[] deg = new int[nodes];
            int edges = (int) dataInput.get(0);
            dataInput.remove(0);
            int[][] link = new int[edges][2];
            for (int i = 0; i < edges; i++) {
                link[i][0] = (int) dataInput.get(0);
                deg[link[i][0]]++;
                dataInput.remove(0);
                link[i][1] = (int) dataInput.get(0);
                deg[link[i][1]]++;
                dataInput.remove(0);
            }
            greedyAlgorithm(nodes, link, deg, color);
            printArray(color);
            //Ghi file
            File file1 = new File("dothitomau.dot");
            if(!file1.exists()) file1.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file1);
            String str;
            str = "graph test {\n";
            fileOutputStream.write(str.getBytes());
            for (int i = 0; i < edges; i++) {
                str = link[i][0] + "--" + link[i][1] + "\n";
                fileOutputStream.write(str.getBytes());
            }
            for (int i = 0; i < nodes; i++) {
                switch (color[i]) {
                    case 1:
                        str = i + " [fillcolor = red , style = filled] \n";
                        fileOutputStream.write(str.getBytes());
                        break;
                    case 2:
                        str = i + " [fillcolor = green , style = filled] \n";
                        fileOutputStream.write(str.getBytes());
                        break;
                    case 3:
                        str = i + " [fillcolor = blue, style = filled] \n";
                        fileOutputStream.write(str.getBytes());
                        break;
                    case 4:
                        str = i + " [fillcolor = yellow , style = filled] \n";
                        fileOutputStream.write(str.getBytes());
                        break;
                    case 5:
                        str = i + " [fillcolor = white , style = filled] \n";
                        fileOutputStream.write(str.getBytes());
                        break;
                    case 6:
                        str = i + " [fillcolor = purple , style = filled] \n";
                        fileOutputStream.write(str.getBytes());
                        break;
                    case 7:
                        str = i + " [fillcolor = crimson , style = filled] \n";
                        fileOutputStream.write(str.getBytes());
                        break;
                    case 8:
                        str = i + " [fillcolor = limegreen , style = filled] \n";
                        fileOutputStream.write(str.getBytes());
                        break;
                    case 9:
                        str = i + " [fillcolor = blueviolet , style = filled] \n";
                        fileOutputStream.write(str.getBytes());
                        break;
                    case 10:
                        str = i + " [fillcolor = salmon , style = filled] \n";
                        fileOutputStream.write(str.getBytes());
                        break;
                    case 11:
                        str = i + " [fillcolor = gold1 , style = filled] \n";
                        fileOutputStream.write(str.getBytes());
                        break;
                    case 12:
                        str = i + " [fillcolor = orangered , style = filled] \n";
                        fileOutputStream.write(str.getBytes());
                        break;
                    case 13:
                        str = i + " [fillcolor = rosybrown , style = filled] \n";
                        fileOutputStream.write(str.getBytes());
                        break;
                    case 14:
                        str = i + " [fillcolor = aquamarine , style = filled] \n";
                        fileOutputStream.write(str.getBytes());
                        break;
                    case 15:
                        str = i + " [fillcolor = brown1 , style = filled] \n";
                        fileOutputStream.write(str.getBytes());
                        break;
                    case 16:
                        str = i + " [fillcolor = burlywood1 , style = filled] \n";
                        fileOutputStream.write(str.getBytes());
                        break;
                    case 17:
                        str = i + " [fillcolor = darkorchid , style = filled] \n";
                        fileOutputStream.write(str.getBytes());
                        break;
                    case 18:
                        str = i + " [fillcolor = greenyellow , style = filled] \n";
                        fileOutputStream.write(str.getBytes());
                        break;
                    case 19:
                        str = i + " [fillcolor = slateblue , style = filled] \n";
                        fileOutputStream.write(str.getBytes());
                        break;
                    case 20:
                        str = i + " [fillcolor = navy , style = filled] \n";
                        fileOutputStream.write(str.getBytes());
                        break;
                }
            }
            fileOutputStream.write("}".getBytes());
            fileOutputStream.close();
        } else System.out.println("Incorrect input data from dothi.txt");
    }
}



