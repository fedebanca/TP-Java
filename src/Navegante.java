public class Navegante  extends Tripulante{
    private Integer inteligencia;

    @Override
    public Integer poderDeMando() {
        return this.inteligencia * this.inteligencia;
    }

    @Override
    public String serRobado() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void serHerido() {
        this.inteligencia /= 2;
    }
}
