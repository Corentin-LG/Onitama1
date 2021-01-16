package onitama_dehais_legoff_graph;

public class Coordonnees {
    private int x;
    private int y;

    public Coordonnees(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public getDeplacements(Coordonnees pointDeDepart){
        // ici this est le point d'arrivée
        int x = this.x-pointDeDepart.x
        int y = this.y-pointDeDepart.y
        return new Coordonnees(x, y);
    }

    @Override
    public boolean equals (Object o){
        if (o == null){
            return false;
        }
        if (o instanceof Coordonnees){
            Coordonnees autreCo = (Coordonnees)o;
            return this.x == autreCo.x && this.y == autreCo.y;
        }
        else{
            return false;
        }
    }
}
