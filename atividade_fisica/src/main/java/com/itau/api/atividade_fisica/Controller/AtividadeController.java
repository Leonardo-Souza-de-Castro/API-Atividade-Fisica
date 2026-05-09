package com.itau.api.atividade_fisica.Controller;

import com.itau.api.atividade_fisica.DTO.CadastroDTO;
import com.itau.api.atividade_fisica.DTO.ListarDTO;
import com.itau.api.atividade_fisica.DTO.RespostaCadastroDTO;
import com.itau.api.atividade_fisica.Entity.Atividade;
import com.itau.api.atividade_fisica.Service.AtividadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/atividades")
@RequiredArgsConstructor
public class AtividadeController {
    private final AtividadeService service;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody CadastroDTO novaAtividade){
        try {
            RespostaCadastroDTO atividadeCriada = service.cadastrar(novaAtividade);
            URI uri = URI.create("/atividades/" + atividadeCriada.getIdAtividade());
            return ResponseEntity.created(uri).body(atividadeCriada);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> listarTodas(){
        try {
            return ResponseEntity.ok().body(service.listarTodas());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{funcional}")
    public ResponseEntity<?> listarPorFuncional(@PathVariable String funcional){
        try {
            return ResponseEntity.ok(service.listarPorFuncional(funcional));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
