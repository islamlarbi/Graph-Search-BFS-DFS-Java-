package com.company;

import java.util.ArrayList;
import java.util.Objects;

//in this class we are looking at "u"

public class Vertex {

    public int id; //
    public boolean color;     //GRAY -> TRUE , WHITE - > FALSE
    public Vertex pi;
    public ArrayList<Vertex> adj = new ArrayList<Vertex>();


    public Vertex(int id) {

        this.color = false;
        this.id = id;

        //this.pi = pi;

       // this.adj = adj;

    }

 //   public Vertex(int id, boolean color, Vertex pi, ArrayList<Vertex> adj) {
  //      this.id = id;
    //    this.color = color;
//        this.pi = pi;
     //   this.adj = adj;
  //  }

    public Boolean isRoot()
    {
        if(pi!=null)
            return false;
        else return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public Vertex getPi() {
        return pi;
    }


    public void setPi(Vertex pi) {
        this.pi = pi;
    }

    public ArrayList<Vertex> getAdj() {
        return adj;
    }

    public void setAdj(ArrayList<Vertex> adj) {
        this.adj = adj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vertex)) return false;
        Vertex vertex = (Vertex) o;
        return getId() == vertex.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {

        if(pi!=null) {
            return "Vertex{" +
                    "id=" + id +
                    ", color=" + color +
                    ", pi=" + pi.getId() +
                    '}';
        }
        else
        {
            return "Vertex{" +
                    "id=" + id +
                    ", color=" + color +
                    ", pi= NULL" +
                    '}';
        }
        }
}
