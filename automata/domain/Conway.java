package domain;


/**
 * Write a description of class Conway here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Conway extends Cell
{
    /**
     * Contructor de la cèlula Conway.
     */
    public Conway(CellularAutomata ac,int row, int column){
        super(ac,row,column);
    }
    
    /**
     * Función que calcula el numero de vecinas vivas de la célula Conway
     */
    
    public int vecinasVivas(){
        CellularAutomata au=this.getAutomata();
        int vecinasVivas = 0;
        for(int i = 0; i < 8;i++){
            try{
                if(au.getVecinos(getRow(), getColumn())[i].isAlive() && au.getVecinos(getRow(), getColumn())[i] instanceof Cell) vecinasVivas++;
            }catch(NullPointerException e){
                vecinasVivas = vecinasVivas;
            }
        }
        return vecinasVivas;
    }
    /**
     * Metodo en el cual la celula decide su proximo estado
     */
    public void decide(){
        CellularAutomata au=this.getAutomata();
        Item[] vecinos = au.getVecinos(getRow(),getColumn());
        int fila;
        int columna;
        //Una célula viva con 2 ó 3 células vecinas vivas sigue viva y,una célula muerta con exactamente 3 células vecinas vivas "revive" (
        if((this.isAlive() && vecinasVivas() == 2) || vecinasVivas() == 3) nextState = Agent.ALIVE;
        //Si la célula tiene menos de dos o más de tres vecinas vivas muere o permanece muerta por "soledad" o superpoblación".
        if(vecinasVivas() < 2 || vecinasVivas() >3) nextState = Agent.DEAD;
    }
}
