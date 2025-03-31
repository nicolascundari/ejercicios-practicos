import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Inscripcion {
    Set<Inscripto> inscriptos;

    public Inscripcion(){
        inscriptos = new HashSet<Inscripto>();
    }

    public void inscribir(Persona persona, Circuito circuito){
        Random randomizer = new Random();
        int numrandom = randomizer.nextInt(0, 20000);;
        Inscripto toAdd = new Inscripto(numrandom, persona, circuito);
        do {
            toAdd.numero = randomizer.nextInt(0, 20000);
        } while (inscriptos.contains(toAdd));
        if(this.esvalido(persona, circuito)) {
            inscriptos.add(toAdd);
        }
    }

    public void desinscribir(int dni) {
        inscriptos.remove(inscriptos.stream().filter(a -> a.persona.dni == dni).findFirst().get());
        System.out.println("Eliminado");
    }


    private boolean esvalido(Persona persona, Circuito circuito){
        return persona.edad > circuito.edadMinima() && !inscriptos.stream().anyMatch(p -> p.persona.dni == persona.dni);
    }

    public void inscriptosDeCircuito(String nombre){
        inscriptos.stream().filter(in -> in.circuito.nombre() == nombre).forEach(elem ->{
                System.out.println("Nombre: " +elem.persona.nombre + " " + elem.persona.apellido);
                System.out.println("Numero inscripcion: " + elem.numero);
        });
    }

    public void inscriptos(){
        inscriptos.stream().forEach(elem ->{
            System.out.println("Nombre: " +elem.persona.nombre + " " + elem.persona.apellido);
            System.out.println("Numero inscripcion: " + elem.numero);
        });
    }

    public int montoPorCategoria(String categoria){
        int finalResult = 0;
        ArrayList<Inscripto> result =
                (ArrayList<Inscripto>) inscriptos.stream().filter(x -> x.circuito.nombre() == categoria);



        for(int i = 0; i > result.size(); i++){
            if(result.get(i).persona.edad > result.get(i).circuito.edadMinima()) {
                finalResult = finalResult + result.get(i).circuito.precioMayor();
            }
            else{
                finalResult = finalResult + result.get(i).circuito.precioMenor();
            }
        }
        return finalResult;
    }

    public int montoCompleto(){
        int finalResult = 0;
        for(Inscripto ins : inscriptos ){
            if(ins.persona.edad > ins.circuito.edadMinima()){
                finalResult += ins.circuito.precioMayor();
            }
            else{
                finalResult += ins.circuito.precioMenor();
            }
        }
        return finalResult;

    }
}
