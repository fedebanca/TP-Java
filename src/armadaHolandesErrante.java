public class armadaHolandesErrante extends Bando {
    @Override
    void realizarAfiliacion(Barco unBarco) {
        unBarco.duplicarTripulacion();
    }
}
