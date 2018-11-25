import java.util.ArrayList;
import java.util.List;

public class JackSparrow extends Tripulante { //Como hacer singleton

    private Integer poderDePelea = 200;
    private Integer inteligencia = 300;
    private List<String> objetos = new ArrayList<String>();

    @Override
    public Integer poderDeMando() {
        return this.poderDePelea * this.inteligencia;
    }

    @Override
    public String serRobado() {
        return null;
    }
    @Override
    public void tomarRon() {
        aumentarEnergia(100);
    }

    @Override
    public void serHerido() {
        this.poderDePelea /= 2;
        this.inteligencia /= 2;
    }

    public void tomarRonCon(Tripulante unTripulante){
        this.tomarRon();
        unTripulante.tomarRon();
        this.robarIngrediente(unTripulante);
    }

    private void robarIngrediente(Tripulante unTripulante)  {
        try{
            String objeto = unTripulante.serRobado();
            objetos.add(objeto);
        }catch(Exception e){
            System.out.println( "No se puede robar un objeto");
        }

    }




}


