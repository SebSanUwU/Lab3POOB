package domain;


/**
 * Write a description of class Conway here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Conway extends Cell
{
    private boolean nacida;
    /**
     * Contructor de la cèlula Conway.
     */
    public Conway(CellularAutomata ac,int row, int column){
        super(ac,row,column);
        state=Agent.ALIVE;
    }
    
    /**
     * Metodo en el cual la celula decide su proximo estado
     */
    public void decide(){
        CellularAutomata au=this.getAutomata();
        Item[] vecinos = au.getVecinos(getRow(),getColumn());
        
        //Una célula muerta con exactamente 3 células vecinas vivas "revive" (al tiempo siguiente estará viva). 
        if(!this.isAlive() && contarTodosVecinos()==3) {
            System.out.println("revive");
            nextState = Agent.ALIVE;
        }
        //Una célula viva con 2 ó 3 células vecinas vivas sigue viva y,una célula muerta con exactamente 3 células vecinas vivas "revive" (
        if((this.isAlive() && contarTodosVecinos() == 2) || contarTodosVecinos() == 3){
           nextState = Agent.ALIVE; 
        }
        //Si la célula tiene menos de dos o más de tres vecinas vivas muere o permanece muerta por "soledad" o superpoblación".
        if(contarVecinos() < 2 || contarTodosVecinos() >=3){
           nextState = Agent.DEAD; 
        }
        
        
    }
}
