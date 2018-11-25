import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Cocinero extends Tripulante {

    private Integer moral;

    private List<String> ingredientes = new ArrayList<String>();

    public Cocinero(Integer moral, List<String> ingredientes) {
        this.moral = moral;
        this.ingredientes = ingredientes;
    }

    @Override
    public Integer poderDeMando() {
        return this.moral * this.cantidadDeIngredientes();
    }

    @Override
    public String serRobado() {
        if(ingredientes.isEmpty()){
            throw new UnsupportedOperationException();
        }
       String unObjeto = elementoAlAzar(ingredientes);
       ingredientes.remove(unObjeto);
       return unObjeto;
    }

    @Override
    public void serHerido() {
        moral /= 2;
    }

    public static String elementoAlAzar(List<String> unosIngredientes) {
       Integer rnd = new Random().nextInt(unosIngredientes.size());
       return unosIngredientes.get(rnd);

    }

    public Integer cantidadDeIngredientes() {
        return this.ingredientes.size();
    }

}
