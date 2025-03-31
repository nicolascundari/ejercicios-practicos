public class Main {
    public static void main(String[] args) {
        Inscripcion inscripciones = new Inscripcion();
        Persona personauno = new Persona("Juan", "Perez", 20, 2939238, "11288327", "737271", "positivo");
        Circuito circuito = new CircuitoChico();

        inscripciones.inscribir(personauno,circuito);


        inscripciones.desinscribir(2939238);
        inscripciones.inscriptos();
    }
}
