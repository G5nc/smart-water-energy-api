package com.fiap.mecatronica.estacaoapi.service;

import com.fiap.mecatronica.estacaoapi.model.Estacao;
import com.fiap.mecatronica.estacaoapi.repository.EstacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

import com.fiap.mecatronica.estacaoapi.model.PrevisaoDTO;
import tools.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import java.io.IOException;

@Service
public class EstacaoService {

    @Autowired
    private EstacaoRepository estacaoRepository;

    private final Random random = new Random();

    // Simula uma nova leitura com dados aleatórios (mas coerentes)
    public Estacao simularLeitura() {
        Estacao estacao = new Estacao();

        // Simula um nível de água entre 0 e 100%
        double nivel = random.nextDouble() * 100;
        estacao.setNivelAgua(Math.round(nivel * 10.0) / 10.0);

        // Simula uma vazão entre 5 e 25 L/min
        double vazao = 5 + (random.nextDouble() * 20);
        estacao.setVazao(Math.round(vazao * 10.0) / 10.0);

        // Simula um consumo entre 0.5 e 5.0 kWh
        double consumo = 0.5 + (random.nextDouble() * 4.5);
        estacao.setConsumoEnergia(Math.round(consumo * 100.0) / 100.0);

        // Regra de negócio para definir o status
        if (estacao.getNivelAgua() < 20) {
            estacao.setStatus("CRITICO");
        } else if (estacao.getNivelAgua() < 50 || estacao.getVazao() > 22) {
            estacao.setStatus("ALERTA");
        } else {
            estacao.setStatus("NORMAL");
        }

        return estacaoRepository.save(estacao);
    }

    // Lista todas as leituras salvas no banco
    public List<Estacao> listarTodas() {
        return estacaoRepository.findAll();
    }

    // Lista a última leitura (para o app mostrar o status atual)
    public Estacao ultimaLeitura() {
        List<Estacao> todas = estacaoRepository.findAll();
        if (todas.isEmpty()) {
            return null;
        }
        return todas.get(todas.size() - 1);
    }

    public PrevisaoDTO obterPrevisao() {
        try {
            // Lê o arquivo JSON que está na pasta resources
            ClassPathResource resource = new ClassPathResource("previsao_estacao.json");
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(resource.getInputStream(), PrevisaoDTO.class);
        } catch (IOException e) {
            System.out.println("Erro ao ler o JSON de previsão: " + e.getMessage());
            return null;
        }
    }
}