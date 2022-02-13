package com.preAceleracionAlkemy.preAceleracion.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "icon")
@Getter
@Setter
public class IconEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imagen;
    private String denominacion;

    @Column(name = "fecha_creacion")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate fechaCreacion;

    private Long altura;
    private String historia;
    private boolean deleted = Boolean.FALSE;

    @ManyToMany(mappedBy = "icons", cascade = CascadeType.ALL)//Varios iconos pueden estar en varios paises//Por default es Type.LAZY
    private List<PaisEntity> paises = new ArrayList<>();//Este atributo tipo coleccion es el que indica con que tabla debe relacionarse.
}

//Apuntes: mappedBy indica que la entidad está siendo mapeada a traves del atributo icons por otra entidad que pasa a ser duena, pues en ManyToMany no hay dueno de por si, 
//esto es para que no se creen dos tablas, ya que en hibernate existe solo la unidireccionalidad.
