package com.itau.api.atividade_fisica.Service;

import com.itau.api.atividade_fisica.DTO.CadastroDTO;
import com.itau.api.atividade_fisica.DTO.ListarDTO;
import com.itau.api.atividade_fisica.DTO.RespostaCadastroDTO;
import com.itau.api.atividade_fisica.Entity.Atividade;
import com.itau.api.atividade_fisica.Repository.AtividadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AtividadeService {
    private final AtividadeRepository atividadeRepository;

    public AtividadeService(AtividadeRepository repository){
        atividadeRepository = repository;
    }

    public RespostaCadastroDTO cadastrar(CadastroDTO atividade){
        Atividade novaAtividade = new Atividade();
        novaAtividade.setFuncional(atividade.getFuncional());
        novaAtividade.setCodigoAtividade(atividade.getCodigoAtividade());
        novaAtividade.setDescricaoAtividade(atividade.getDescricaoAtividade());

        if(atividade.getDataHora() != null){
          novaAtividade.setDataCriacao(atividade.getDataHora());
        }

        atividadeRepository.save(novaAtividade);

        return new RespostaCadastroDTO(
                novaAtividade.getIdAtividade(),
                novaAtividade.getFuncional(),
                novaAtividade.getCodigoAtividade(),
                novaAtividade.getDescricaoAtividade(),
                novaAtividade.getDataCriacao()
        );
    }

    public List<ListarDTO> listarTodas(){
        List<Atividade> atividades = atividadeRepository.findAll();

        return atividades.stream().map(e -> new ListarDTO(
                        e.getFuncional(),
                        e.getCodigoAtividade(),
                        e.getDescricaoAtividade(),
                        e.getDataCriacao()
                ))
                .collect(Collectors.toList());
    }

    public List<ListarDTO> listarPorFuncional(String Funcional){
        List<Atividade> atividades = atividadeRepository.findByFuncional(Funcional);

        return atividades.stream().map(e -> new ListarDTO(
                        e.getFuncional(),
                        e.getCodigoAtividade(),
                        e.getDescricaoAtividade(),
                        e.getDataCriacao()
                ))
                .collect(Collectors.toList());
    }

}
