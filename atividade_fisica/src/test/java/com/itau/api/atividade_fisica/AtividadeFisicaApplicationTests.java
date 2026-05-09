package com.itau.api.atividade_fisica;

import com.itau.api.atividade_fisica.DTO.CadastroDTO;
import com.itau.api.atividade_fisica.DTO.ListarDTO;
import com.itau.api.atividade_fisica.DTO.RespostaCadastroDTO;
import com.itau.api.atividade_fisica.Entity.Atividade;
import com.itau.api.atividade_fisica.Repository.AtividadeRepository;
import com.itau.api.atividade_fisica.Service.AtividadeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AtividadeFisicaApplicationTests {

	@Mock
    AtividadeRepository atividadeRepository;

	@InjectMocks
    AtividadeService service;

	@Test
	void deveCadastrarAtividadeComSucesso() {
		CadastroDTO dto = new CadastroDTO(
				"123456789",
				"RUN",
				"Corrida de 5km",
				LocalDateTime.now()
		);

		Atividade atividadeSalva = new Atividade();
		atividadeSalva.setFuncional(dto.getFuncional());
		atividadeSalva.setCodigoAtividade(dto.getCodigoAtividade());
		atividadeSalva.setDescricaoAtividade(dto.getDescricaoAtividade());

		when(atividadeRepository.save(any(Atividade.class))).thenReturn(atividadeSalva);

		RespostaCadastroDTO resposta = service.cadastrar(dto);

		assertNotNull(resposta);
		assertEquals("123456789", resposta.getFuncional());
		assertEquals("RUN", resposta.getCodigoAtividade());
	}

	@Test
	void deveRetornarListaDeAtividades() {
		Atividade atividade = new Atividade();
		atividade.setFuncional("123456789");
		atividade.setCodigoAtividade("RUN");
		atividade.setDescricaoAtividade("Corrida de 5km");

		when(atividadeRepository.findAll()).thenReturn(List.of(atividade));

		List<ListarDTO> resposta = service.listarTodas();

		assertNotNull(resposta);
		assertEquals(1, resposta.size());
		assertEquals("123456789", resposta.get(0).getFuncional());
	}

	@Test
	void deveRetornarListaDeAtividadesPorFuncional() {
		Atividade atividade = new Atividade();
		atividade.setFuncional("123456789");
		atividade.setCodigoAtividade("RUN");
		atividade.setDescricaoAtividade("Corrida de 5km");

		when(atividadeRepository.findByFuncional("123456789")).thenReturn(List.of(atividade));

		List<ListarDTO> resposta = service.listarPorFuncional("123456789");

		assertNotNull(resposta);
		assertEquals(1, resposta.size());
		assertEquals("123456789", resposta.get(0).getFuncional());
	}



}
