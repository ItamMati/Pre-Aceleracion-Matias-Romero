package com.preAceleracionAlkemy.preAceleracion.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "pais")
public class PaisEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imagen;

    private String denominacion;

    @Column(name = "cant_habitantes")
    private Long cantidadHabitantes;

    private Long superficie;

    @ManyToOne(cascade = CascadeType.ALL)//Muchos paises para un continente
    @JoinColumn(name = "continente_id", insertable = false, updatable = false)//Nombre de la columna que relaciona a pais con continente
    private ContinentEntity continente;// El atributo continente le indica a hibernate con que tabla debe relacion a pais.

    @Column(name = "continente_id", nullable = false)
    private Long continenteId;

    @ManyToMany(// Varios paises pueden tener varios iconos.Esto quiere decir que existen dos colecciones en esta relacion, por lo que debe crear una tercera tabla que las relaciones,
    cascade = {CascadeType.PERSIST, CascadeType.MERGE})// Apuntes en la clase continente
    @JoinTable(name = "icon_pais", joinColumns = @JoinColumn(name = "pais_id"))//Define el nombre de la tabla intermedia que sea crea y define el nombre de la columna que la relaciona.
    private Set<IconEntity> icons = new HashSet<>();//El atributo le dice a hibernate con que tabla lo va a relacion, y esta es una coleccion.
}

//Apuntes: Entiendo que el dueno deberia ser Continente, pero como la relacion many pertenece a pais, la FK queda en su tabla, luego es dueno.
//Esto es porque todos los continentes tiene varios paises, luego no puedo repetir continentes para agregar la FK de los paises que le pertenecen.
//Pero si puedo agregar la FK de cada continente al crear cada pais para saber a donde pertenece cada uno.
//////
//insertable = false: No se puede insertar un valor
//updatable = false: El valor no puede ser modificado.


//Consultar si el Type.LAZY Y EAGER trabajan de igual forma en una apirest, se intento obtener un objeto seteando las diferentes colecciones y se obtuvo la misma respuesta.



