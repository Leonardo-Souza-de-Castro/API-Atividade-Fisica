package com.itau.api.atividade_fisica.Controller;

import com.itau.api.atividade_fisica.DTO.CadastroDTO;
import com.itau.api.atividade_fisica.DTO.ListarDTO;
import com.itau.api.atividade_fisica.DTO.RespostaCadastroDTO;
import com.itau.api.atividade_fisica.Entity.Atividade;
import com.itau.api.atividade_fisica.Service.AtividadeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/atividades")
@RequiredArgsConstructor
public class AtividadeController {
    private final AtividadeService service;

    @PostMapping
    public ResponseEntity<RespostaCadastroDTO> cadastrar(@RequestBody @Valid CadastroDTO novaAtividade){
        RespostaCadastroDTO atividadeCriada = service.cadastrar(novaAtividade);
        URI uri = URI.create("/atividades/" + atividadeCriada.getIdAtividade());
        return ResponseEntity.created(uri).body(atividadeCriada);
    }

    @GetMapping
    public ResponseEntity<List<ListarDTO>> listarTodas(){
        return ResponseEntity.ok(service.listarTodas());
    }

    @GetMapping("/{funcional}")
    public ResponseEntity<List<ListarDTO>> listarPorFuncional(@PathVariable String funcional){
        return ResponseEntity.ok(service.listarPorFuncional(funcional));
    }
}