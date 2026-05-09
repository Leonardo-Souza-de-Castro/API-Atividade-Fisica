CREATE TABLE atividades(
	idAtividade SERIAL PRIMARY KEY NOT NULL,
	funcional VARCHAR(9) NOT NULL,
	dataCriacao DATE DEFAULT CURRENT_DATE,
	codigoAtividade VARCHAR(150) NOT NULL,
	descricaoAtividade VARCHAR(300)
);