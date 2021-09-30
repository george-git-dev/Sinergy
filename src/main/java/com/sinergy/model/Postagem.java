package com.sinergy.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Criacao da tabela do SQL
 * 
 * @author Pablo
 * @sice 1.0
 * @date 29/09/2021
 */

@Entity
@Table(name = "postagem")
public class Postagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPostagem;
	
	@Size(min = 5, max = 100)
	private @NotBlank String titulo;

	
	@Size(min = 10, max = 100)
	private @NotBlank String texto;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataPostagem = LocalDate.now();

	@ManyToOne
	@JoinColumn(name = "idTema")
	@JsonIgnoreProperties({"postagem"})
	private Tema temaRelacionado;

	public Long getId() {
		return idPostagem;
	}

	public void setId(long id) {
		this.idPostagem = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDate getDate() {
		return dataPostagem;
	}

	public void setDate(LocalDate date) {
		this.dataPostagem = date;
	}

	public Tema getTemaRelacionado() {
		return temaRelacionado;
	}

	public void setTemaRelacionado(Tema tema) {
		this.temaRelacionado = tema;
	}
}
