package com.fiap.mecatronica.estacaoapi.controller;

import com.fiap.mecatronica.estacaoapi.model.Estacao;
import com.fiap.mecatronica.estacaoapi.model.PrevisaoDTO; // Import necessário
import com.fiap.mecatronica.estacaoapi.service.EstacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estacao")
@CrossOrigin(origins = "*")
public class EstacaoController {

    @Autowired
    private EstacaoService estacaoService;

    // GET /api/estacao/leituras
    @GetMapping("/leituras")
    public ResponseEntity<List<Estacao>> listarTodas() {
        List<Estacao> leituras = estacaoService.listarTodas();
        return ResponseEntity.ok(leituras);
    }

    // GET /api/estacao/atual
    @GetMapping("/atual")
    public ResponseEntity<Estacao> ultimaLeitura() {
        Estacao ultima = estacaoService.ultimaLeitura();
        if (ultima == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ultima);
    }

    // POST /api/estacao/simular
    @PostMapping("/simular")
    public ResponseEntity<Estacao> simularLeitura() {
        Estacao novaLeitura = estacaoService.simularLeitura();
        return ResponseEntity.status(201).body(novaLeitura);
    }

    // GET /api/estacao/previsao -> NOVO ENDPOINT (Agora dentro da classe)
    @GetMapping("/previsao")
    public ResponseEntity<PrevisaoDTO> obterPrevisao() {
        PrevisaoDTO previsao = estacaoService.obterPrevisao();
        if (previsao == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(previsao);
    }
}