package com.fiap.mecatronica.estacaoapi.controller;

import com.fiap.mecatronica.estacaoapi.model.Estacao;
import com.fiap.mecatronica.estacaoapi.service.EstacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estacao")
@CrossOrigin(origins = "*") // Permite que o app React Native acesse a API
public class EstacaoController {

    @Autowired
    private EstacaoService estacaoService;

    // GET /api/estacao/leituras -> Lista todas as leituras
    @GetMapping("/leituras")
    public ResponseEntity<List<Estacao>> listarTodas() {
        List<Estacao> leituras = estacaoService.listarTodas();
        return ResponseEntity.ok(leituras);
    }

    // GET /api/estacao/atual -> Retorna a última leitura
    @GetMapping("/atual")
    public ResponseEntity<Estacao> ultimaLeitura() {
        Estacao ultima = estacaoService.ultimaLeitura();
        if (ultima == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ultima);
    }

    // POST /api/estacao/simular -> Simula uma nova leitura e salva no banco
    @PostMapping("/simular")
    public ResponseEntity<Estacao> simularLeitura() {
        Estacao novaLeitura = estacaoService.simularLeitura();
        return ResponseEntity.status(201).body(novaLeitura);
    }
}
