public class Guerrero extends Tripulante{

    private Integer poderDePelea;
    private Integer vitalidad;

    @Override
    public Integer  poderDeMando() {
        return this.poderDePelea * this.vitalidad;
    }

    @Override
    public String serRobado() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void serHerido() {
        this.poderDePelea /= 2;
        this.vitalidad /= 2;
    }
}
