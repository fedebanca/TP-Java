import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class Barco {

    private Integer resistencia;
    private Integer poderDeFuego;
    private Integer municiones;
    private List<Tripulante> tripulacion = new ArrayList<Tripulante>();

    public Optional<Tripulante> capitan() { //ver que onda esto
        return tripulacion.stream().max(Comparator.comparing(Tripulante::poderDeMando));
    }

    public Integer poderDeMando() {
        return tripulacion.stream().map(Tripulante::poderDeMando).collect(Collectors.summingInt(i->i));
    }

    public void perderTripulantesDebiles() { //error de tipos
        this.tripulacion = this.tripulacion.stream().filter(tripulante -> tripulante.esFuerte()).collect(Collectors.toList());
    }

    public void pelearCon(Barco unBarco) {
        if(this.poderDeMando() > unBarco.poderDeMando()){
            unBarco.perderTripulantesDebiles();
            unBarco.herirTripulacion();
            this.robarTripulates(unBarco);
            unBarco.serDesolado();
        }
        else{
            this.perderTripulantesDebiles();
            this.herirTripulacion();
            unBarco.robarTripulates(unBarco);
            this.serDesolado();
        }
    }

    public void herirTripulacion() {
        this.tripulacion.forEach(tripulante -> tripulante.serHerido());
    }

    public void robarTripulates(Barco unBarco) {
        this.tripulacion.addAll(unBarco.tripulacion);
        unBarco.perderTodosLosTripulantes();
    }

    public void perderTodosLosTripulantes() {
        this.tripulacion.clear();
    }

    public void serDesolado() {
        this.resistencia = 0;
        this.poderDeFuego = 0;
        this. municiones = 0;
    }

    public void dispararA(Barco unBarco, Integer unasBalas) {
        if(unasBalas > this.municiones){
            unBarco.serDisparado(unasBalas);
        }
        else{
            throw new NoHayBalasSuficientes("No hay balas suficientes")
        }
    }

    public void serDisparado(Integer unasBalas) {
        this.resistencia -= unasBalas * 50;
        this.perderTripulantesCansados();
    }

    public void perderTripulantesCansados() {
        tripulacion = this.tripulacion.stream().filter(tripulante -> tripulante.noEstaCansado()).collect(Collectors.toList());
    }
}
