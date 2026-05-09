package com.itau.api.atividade_fisica.Controller;

import com.itau.api.atividade_fisica.DTO.CadastroDTO;
import com.itau.api.atividade_fisica.Entity.Atividade;
import com.itau.api.atividade_fisica.Service.AtividadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/atividade")
@RequiredArgsConstructor
public class AtividadeController {
    private final AtividadeService service;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody CadastroDTO novaAtividade){
        try {
            Atividade atividadeCriada = service.cadastrar(novaAtividade);
            URI uri = URI.create("/atividades/" + atividadeCriada.getIdAtividade());
            return ResponseEntity.created(uri).body(atividadeCriada);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
