public class testPrograma {
    
    public static void main(String[] args) {
        
        System.out.println("-- vehiculo1 --");
        Vehiculo vehiculo1 = new Vehiculo(150, 100, 250);        
        System.out.println("Alto: " + vehiculo1.getAlto() + "cm");
        System.out.println("Ancho: " + vehiculo1.getAncho() + "cm");
        System.out.println("Largo: " + vehiculo1.getLargo() + "cm");
        
        System.out.println("-- persona1 --");
        Persona persona1 = new Persona("Santiago", "Teves", "39593729");
        System.out.println("Nombre: " + persona1.getNombre());
        System.out.println("Apellido: " + persona1.getApellido());
        System.out.println("DNI: " + persona1.getNumeroDocumento());
        
    }
    
}
