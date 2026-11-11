package com.fiap.mecatronica.estacaoapi.model;

public class PrevisaoDTO {
    private Double previsao_consumo_proxima_hora;
    private Integer cluster_atual;
    private String descricao_cluster_atual;

    // Getters e Setters
    public Double getPrevisao_consumo_proxima_hora() { return previsao_consumo_proxima_hora; }
    public void setPrevisao_consumo_proxima_hora(Double previsao_consumo_proxima_hora) { this.previsao_consumo_proxima_hora = previsao_consumo_proxima_hora; }
    public Integer getCluster_atual() { return cluster_atual; }
    public void setCluster_atual(Integer cluster_atual) { this.cluster_atual = cluster_atual; }
    public String getDescricao_cluster_atual() { return descricao_cluster_atual; }
    public void setDescricao_cluster_atual(String descricao_cluster_atual) { this.descricao_cluster_atual = descricao_cluster_atual; }
}