package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

    Graph g = new Graph(readgraph());
  //  Vertex z = new Vertex(3);
   //z.adj.add(z);
    System.out.println(g);



    g.DFS(g);
    g.BFS(g);

    }

    public static ArrayList<Vertex> readgraph()
    {

        ArrayList<Vertex> temp = new ArrayList<Vertex>();
        Vertex arr[] = new Vertex[0];
        BufferedReader r;

        try{

            r = new BufferedReader(new FileReader("C:\\Users\\Domi\\Desktop\\prgrmng\\przeszukiwanie_grafow\\src\\com\\company\\graphsource.txt"));

            String z = r.readLine();
            int i = 0;
            int j = 0;


            while(z!=null)
            {
                if(i==0)
                {

                j = Integer.valueOf(z);

                for(int l = 0; l < j; l ++)
                {
                    temp.add(new Vertex(l));
                }

                }
                else
                {

                 //   temp.add(arr[j-1]);

                    for(int k = 0; k < j; k++)
                    {

                        int m = z.charAt(k) - 48;

                        if(m > 0){
                            for (int l = 1; l <= m; l++) {
                                temp.get(i - 1).adj.add(temp.get(k));
                                temp.get(k).setPi(temp.get(i - 1));
                            }
                        }
                    }

                }

                z = r.readLine();
                i++;
            }


         return temp;
        }
        catch (IOException e)
        {
            System.out.println("FILE ERROR");
        }

        return null;
    }

}
