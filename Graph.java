package com.company;

//container class.

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Graph {

protected ArrayList<Vertex> graphVertexes;

    public Graph(ArrayList<Vertex> graphVertexes) {
        this.graphVertexes = graphVertexes;
    }

    public ArrayList<Vertex> getGraphVertexes() {
        return graphVertexes;
    }



    public void setGraphVertexes(ArrayList<Vertex> graphVertexes) {
        this.graphVertexes = graphVertexes;
    }


    @Override
    public String toString() {
        return "Graph{" +
                "graphVertexes=" + graphVertexes +
                '}';
    }

    //METHODS WILL BE HERE!!

    //DFS

    public void DFS(Graph g)
    {
        System.out.println("------initiating DFS------");
        g.getGraphVertexes().forEach((n) -> {n.setColor(false);
                                        n.setPi(null);
                                        if(!n.isColor())
                                        {
                                            DFS(n,g);
                                        }} );

        g.getGraphVertexes().forEach((n) -> {
            if(!n.isColor())
            {
                DFS(n,g);
            }} );



    }

    public void DFS(Vertex u, Graph g)
    {
        u.setColor(true);
        System.out.println("We are at " + u.getId());

        u.getAdj().forEach((n) -> {
                            if(!n.isColor())
                            {
                             n.setPi(u);
                             DFS(n,g);
                             System.out.println("We are at " + n.getId());
                             System.out.println("EDGE OF TREE: " + (u.getId() + 1 )+ ":" + (n.getId() + 1));
                            }
                            });

    }

    //BFS

    public void BFS(Graph g)
    {
        System.out.println("------initiating BFS------");
        g.getGraphVertexes().forEach((n)->
                                    {
                                        n.setColor(false);
                                        n.setPi(null);
                                    }
                                    );
        g.getGraphVertexes().forEach((n)->
                                    {
                                        System.out.println("We are at " + n.getId());
                                        BFS(n,g);
                                    });
    }

    public void BFS(Vertex u, Graph g)
    {
     u.setColor(true);
     Queue<Vertex> z = new LinkedList<>();

     z.add(u);
    while(!z.isEmpty())
    {
        u=z.remove();

        Vertex vv = u;

        //vv is temp for lambda

        u.getAdj().forEach((n)->
                            {

                                if(!n.isColor()) {
                                    n.setColor(true);
                                    n.setPi(vv);
                                    ((LinkedList<Vertex>) z).add(n);
                                    System.out.println("We are at " + n.getId());
                                    System.out.println("EDGE OF TREE: " + ( vv.getId() + 1) + ":" + (n.getId() + 1));
                                }

                            });
    }

    }

}

