public abstract class Tripulante {

    private Integer energia = 500;

    public abstract Integer poderDeMando ();

    public abstract String serRobado();

    public abstract void serHerido();

    public void tomarRon() {
        disminuirEnergia(50);
    }

    public void disminuirEnergia(Integer energiaADisminuir) {
        this.energia -= energiaADisminuir;
    }

    public void aumentarEnergia(Integer energiaAAumentar) {
        this.energia += energiaAAumentar;
    }

    public Boolean esFuerte() {
        return this.poderDeMando() > 100;
    }

    public Boolean noEstaCansado() {
        return this.energia > 20;
    }
}
