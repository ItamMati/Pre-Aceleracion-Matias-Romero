package com.preAceleracionAlkemy.preAceleracion.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "continente_id", insertable = false, updatable = false)
	private ContinenteEntity continente;

	@Column(name = "continente_id", nullable = false)
	private Long continenteId;

	@ManyToMany(

			cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "icon_pais", joinColumns = @JoinColumn(name = "icon_id"))
	private Set<IconEntity> icons = new HashSet<>();
}
