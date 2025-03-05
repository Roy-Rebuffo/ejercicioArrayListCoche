/*
Tenemos una Clase Vehículo que contiene: 

Matrícula(4 núm 3 Dígitos) 
Marca 
Modelo
Año matriculación
Número reparación (cuántas veces ha entrado a reparación)

Estamos en un taller y lo que queremos saber es las reparaciones que tienen los coches.

Meter CUANDO ENTRA UN COCHE A REPARAR => La matrícula, modelo, marca. El NÚMERO DE REPARACIÓN es automática me tiene que decir cual es. (¿Contador?)

=====> Usamos ArrayList !!!

Si Matricula/marca/modelo/año matriculación son iguales => Numero de reparación ++

Significa que el coche ha venido otra vez entonces sumamos +1 al número de reparacion.
 */
package ejercicioarrayscoche;

import java.util.Objects;

public class Vehiculo {

    private String matricula;
    private String marca;
    private String modelo;
    private String matriculacion;
    private int numeroReparacion;

    // Constructor
    public Vehiculo(String matricula, String marca, String modelo,
            String matriculacion, int numeroReparacion) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.matriculacion = matriculacion;
        this.numeroReparacion = numeroReparacion;
    }

    // Getters y Setters
    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMatriculacion() {
        return matriculacion;
    }

    public int getNumeroReparacion() {
        return numeroReparacion;
    }

    // Método para incrementar el número de reparaciones
    public void incrementarReparacion() {
        this.numeroReparacion++;
    }

    @Override
    public String toString() {
        return "\nMatricula: " + matricula + "\nMarca: " + marca
                + "\nModelo: " + modelo + "\nFecha de matriculacion: " + matriculacion
                + "\nNumero de reparaciones: " + numeroReparacion;
    }

    //HashCode y equals
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.matricula);
        hash = 97 * hash + Objects.hashCode(this.marca);
        hash = 97 * hash + Objects.hashCode(this.modelo);
        hash = 97 * hash + Objects.hashCode(this.matriculacion);
        hash = 97 * hash + this.numeroReparacion;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Vehiculo vehiculo = (Vehiculo) obj;
        return matriculacion == vehiculo.matriculacion
                && Objects.equals(matricula, vehiculo.matricula)
                && Objects.equals(marca, vehiculo.marca)
                && Objects.equals(modelo, vehiculo.modelo);
    }

}
