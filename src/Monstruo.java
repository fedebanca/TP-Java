public class Monstruo extends Tripulante {
    private Integer poderDePelea;

    public Integer poderDeMando() {
        return poderDePelea;
    }

    @Override
    public String serRobado() {
        throw new UnsupportedOperationException();

    }

    @Override
    public void serHerido() {
        poderDePelea /= 2;
    }
}
