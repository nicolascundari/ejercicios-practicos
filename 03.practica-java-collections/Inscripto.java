public class Inscripto {
    int numero;
    Persona persona;
    Circuito circuito;
    public Inscripto(int numero, Persona persona, Circuito circuito){
        this.numero = numero;
        this.persona = persona;
        this.circuito = circuito;
    }

    public int precioApagar(){
        if(persona.edad > circuito.edadMinima()){
            return circuito.precioMayor();
        }
        else{
            return circuito.precioMenor();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inscripto inscripto = (Inscripto) o;
        return numero == inscripto.numero;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(numero);
    }
}
