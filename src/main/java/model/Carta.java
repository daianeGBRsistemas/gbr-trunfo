package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "carta", schema = "gbr_trunfo")
public class Carta implements Serializable {

	private static final long serialVersionUID = 6017409735094474621L;

	@Id
	@SequenceGenerator(name = "seq_carta", sequenceName = "gbr_trunfo.seq_carta", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_carta")
	private int id;

	private String nome;

	private int forca;

	private int velocidade;

	private int inteligencia;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_cadastro")
	private LocalDateTime dataCadastro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_atualizacao")
	private LocalDateTime dataAtualizacao;
	
	@PrePersist
	private void prePersist() {
		this.dataCadastro = LocalDateTime.now();
		this.dataAtualizacao = LocalDateTime.now();
	}
	
	@PreUpdate
	private void preUpdate() {
		this.dataAtualizacao = LocalDateTime.now();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getForca() {
		return forca;
	}

	public void setForca(int forca) {
		this.forca = forca;
	}

	public int getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataAtualizacao, dataCadastro, forca, id, inteligencia, nome, velocidade);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carta other = (Carta) obj;
		return Objects.equals(dataAtualizacao, other.dataAtualizacao)
				&& Objects.equals(dataCadastro, other.dataCadastro) && forca == other.forca && id == other.id
				&& inteligencia == other.inteligencia && Objects.equals(nome, other.nome)
				&& velocidade == other.velocidade;
	}

}
