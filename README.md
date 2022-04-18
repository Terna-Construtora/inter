# inter

Api em Java para Acessar o Banco Inter

A Api V1 já está em produção e funciona todos os metódos.

A Api V2 está quase toda feita, mas o limite de requisições pelo Banco Inter no momento é somente 10 por minuto, o que inviabiliza o uso para emissão de muitos boletos.

Em produção iremos continuar a usar a V1 e usaremos os WebHooks da V2, até a solução do limite de requisições da V2.


## Getting Started

### 1 - Baixar e Converter Certificados

Inicialmente baixe o certificado para a aplicação no site do banco inter.

Precisamos converter os arquivos CRT e KEY baixados do banco em .p12

Para isso execute o comando:

    openssl pkcs12 -export -out terna-interV1.p12 -inkey NOME_DO_KEY_BAIXADO_DO_BANCO.key -in NOME_DO_CRT_BAIXADO_DO_BANCO.crt -name "NOME_ARQUIVO_SAIDA"

### 2 - Inicie o Storage

Os boletos baixados podem ser armazenados em um diretório. Fazendo assim um cache e evitando baixar novamente o mesmo
boleto.

O codigo abaixo deve ser executado apenas uma vez, antes da primeira chamada, normalmente colocado no main.

    Storage.get().setRootPath(new File("/Diretorio_de_boletos"));

### 3 - Iniciando uma Conexão

#### 3.1 - Versão 1 da Api do Inter


    InputStream isP12 = Teste.class.getResourceAsStream("/terna-inter.p12");

    String senha = "SENHA_UTILIZADA NO OPENSSL";

    InterV1 interV1 = new InterV1(NUMERO_DA_CONTA, isP12, senha);


### 4 - Emitindo boletos

    Pagador pagador = Pagador.builder().nome("Lucas Vilela de Souza Gonçalves")
    .endereco("Rua das cove")
    .numero("x")
    .bairro("Santo Agostinho")
    .cidade("Belo Horizonte")
    .cep("30180122")
    .email(EMNAIL)
    .uf("MG")
    .cnpjCpf(CPF_OU_CNPJ).build();
    
    LocalDate dataVencimento = LocalDate.now().plusDays(1);
    LocalDate outroDia = dataVencimento.plusDays(3);

        Multa multa = Multa.builder()
                .codigoMulta(CodigoMulta.PERCENTUAL)
                .taxa(BigDecimal.valueOf(2.0))
                .data(outroDia)
                .build();

        Mora mora = Mora.builder()
                .codigoMora(CodigoMora.TAXAMENSAL)
                .taxa(BigDecimal.valueOf(1.0))
                .data(outroDia)
                .build();

        Emissao emissao = Emissao.builder()
                .dataEmissao(LocalDate.now())
                .seuNumero("TESTE")
                .cnpjCPFBeneficiario(CNPJ_DA_EMPRESA)
                .valorNominal(BigDecimal.TEN)
                .dataVencimento(dataVencimento)
                .multa(multa)
                .mora(mora)
                .numDiasAgenda(NumDiasAgenda.TRINTA)
                .pagador(pagador).build();

    EmissaoResponse emissaoResponse1 = interV1.emitirBoleto(emissao)



### 5 - Download boletos

    interV1.download( nossoNumero, false)

### 6 - Dar Baixa no boleto
    interV1.baixar(nossoNumero, CodigoBaixa.ACERTOS)

### 7 - Consultar boletos
    List<Content> consultar = interV1.consultar(null, null, LocalDate.of(2000, 01, 01), LocalDate.now(), null, null);