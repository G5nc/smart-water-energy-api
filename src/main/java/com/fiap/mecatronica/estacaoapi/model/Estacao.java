package com.fiap.mecatronica.estacaoapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Estacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double nivelAgua; // em %
    private Double vazao; // em L/min
    private Double consumoEnergia; // em kWh
    private String status; // NORMAL, ALERTA, CRITICO
    private LocalDateTime dataHora;

    // Construtor padrão
    public Estacao() {
        this.dataHora = LocalDateTime.now();
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Double getNivelAgua() { return nivelAgua; }
    public void setNivelAgua(Double nivelAgua) { this.nivelAgua = nivelAgua; }
    public Double getVazao() { return vazao; }
    public void setVazao(Double vazao) { this.vazao = vazao; }
    public Double getConsumoEnergia() { return consumoEnergia; }
    public void setConsumoEnergia(Double consumoEnergia) { this.consumoEnergia = consumoEnergia; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }
}