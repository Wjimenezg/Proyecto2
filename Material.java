
package fabrica_de_sillas;

import java.util.*;
public class Material {
    private int madera;
    private int plastico;
    private int metal;
    private int clavos;
    private int tornillos;
    private int pegamento;
    private int pintura;
    private int tela;

    public Material(int madera, int plastico, int metal, int clavos, int tornillos, int pegamento, int pintura, int tela) {
        this.madera = madera;
        this.plastico = plastico;
        this.metal = metal;
        this.clavos = clavos;
        this.tornillos = tornillos;
        this.pegamento = pegamento;
        this.pintura = pintura;
        this.tela = tela;
    }

    public int getMadera() {
        return madera;
    }

    public void setMadera(int madera) {
        this.madera = madera;
    }

    public int getPlastico() {
        return plastico;
    }

    public void setPlastico(int plastico) {
        this.plastico = plastico;
    }

    public int getMetal() {
        return metal;
    }

    public void setMetal(int metal) {
        this.metal = metal;
    }

    public int getClavos() {
        return clavos;
    }

    public void setClavos(int clavos) {
        this.clavos = clavos;
    }

    public int getTornillos() {
        return tornillos;
    }

    public void setTornillos(int tornillos) {
        this.tornillos = tornillos;
    }

    public int getPegamento() {
        return pegamento;
    }

    public void setPegamento(int pegamento) {
        this.pegamento = pegamento;
    }

    public int getPintura() {
        return pintura;
    }

    public void setPintura(int pintura) {
        this.pintura = pintura;
    }

    public int getTela() {
        return tela;
    }

    public void setTela(int tela) {
        this.tela = tela;
    }
    
    
    public int calcularMaterialesNecesarios(String tipoSilla) {
    int cantidadMaterialesNecesarios = 0;

    // Define los requerimientos de materiales para cada tipo de silla (ajusta estos valores según tus necesidades).
    Map<String, Integer> requerimientos = new HashMap<>();
    requerimientos.put("Gamer", 3);    // Ejemplo: 5 unidades de madera para una silla Gamer
    requerimientos.put("Comedor", 5);  // Ejemplo: 6 unidades de madera para una silla de comedor
    requerimientos.put("Oficina", 2);
    requerimientos.put("Patio", 2);
    requerimientos.put("Sencillo", 2);
    // Agrega otros tipos de sillas y sus requerimientos aquí.

    // Verifica si el tipo de silla es válido y tiene requerimientos definidos.
    if (requerimientos.containsKey(tipoSilla)) {
        int cantidadRequerida = requerimientos.get(tipoSilla);

        // Ahora, puedes calcular la cantidad de cada tipo de material necesario.
        cantidadMaterialesNecesarios = cantidadRequerida * getMadera(); // Ejemplo: Madera requerida para una silla Gamer
        // Realiza los cálculos para los otros tipos de materiales.
        cantidadMaterialesNecesarios += cantidadRequerida * getPlastico();
        cantidadMaterialesNecesarios += cantidadRequerida * getMetal();
        cantidadMaterialesNecesarios += cantidadRequerida * getClavos();
        cantidadMaterialesNecesarios += cantidadRequerida * getTornillos();
        cantidadMaterialesNecesarios += cantidadRequerida * getPegamento();
        cantidadMaterialesNecesarios += cantidadRequerida * getPintura();
        cantidadMaterialesNecesarios += cantidadRequerida * getTela();

        return cantidadMaterialesNecesarios;
    } else {
        // El tipo de silla no tiene requerimientos definidos.
        return -1; // Puedes elegir un valor especial para indicar que no hay requerimientos definidos.
    }
}
    
    /*public int calcularMaterialesNecesarios(String tipoSilla) {
    int cantidadMaterialesNecesarios = 0;

    // Define los requerimientos de materiales para cada tipo de silla (ajusta estos valores según tus necesidades).
    Map<String, Integer> requerimientos = new HashMap<>();
    requerimientos.put("Gamer", 5); // Ejemplo: 5 unidades de madera para una silla Gamer

    // Verifica si el tipo de silla es válido y tiene requerimientos definidos.
    if (requerimientos.containsKey(tipoSilla)) {
        int cantidadRequerida = requerimientos.get(tipoSilla);

        // Ahora, puedes calcular la cantidad de cada tipo de material necesario.
        cantidadMaterialesNecesarios = cantidadRequerida * getMadera(); // Ejemplo: Madera requerida para una silla Gamer

        // Realiza los cálculos para los otros tipos de materiales.

        return cantidadMaterialesNecesarios;
    } else {
        // El tipo de silla no tiene requerimientos definidos.
        return -1; // Puedes elegir un valor especial para indicar que no hay requerimientos definidos.
    }
}*/
      
}
