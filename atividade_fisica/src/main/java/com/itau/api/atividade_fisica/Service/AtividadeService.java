package com.itau.api.atividade_fisica.Service;

import com.itau.api.atividade_fisica.DTO.CadastroDTO;
import com.itau.api.atividade_fisica.Entity.Atividade;
import com.itau.api.atividade_fisica.Repository.AtividadeRepository;
import org.springframework.stereotype.Service;

@Service
public class AtividadeService {
    private final AtividadeRepository atividadeRepository;

    public AtividadeService(AtividadeRepository repository){
        atividadeRepository = repository;
    }

    public Atividade cadastrar(CadastroDTO atividade){
        Atividade novaAtividade = new Atividade();
        novaAtividade.setFuncional(atividade.getFuncional());
        novaAtividade.setCodigoAtividade(atividade.getCodigoAtividade());
        novaAtividade.setDescricaoAtividade(atividade.getDescricaoAtividade());

        if(atividade.getDataHora() != null){
          novaAtividade.setDataCriacao(atividade.getDataHora());
        }

        atividadeRepository.save(novaAtividade);

        return novaAtividade;
    }
}
