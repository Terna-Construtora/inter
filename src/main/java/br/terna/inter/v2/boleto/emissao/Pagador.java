package br.terna.inter.v2.boleto.emissao;

import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang.StringUtils;

@Data
@Builder
public class Pagador {
    private String cnpjCpf;

    private String nome;

    @Builder.Default
    private String email = "";

    @Builder.Default
    private String telefone = "";

    private String cep;

    private String numero;

    @Builder.Default
    private String complemento = "";

    private String bairro;

    private String cidade;

    private String uf;

    private String endereco;

    @Builder.Default
    private String ddd = "";

    @Builder.Default
    private TipoPessoa tipoPessoa = TipoPessoa.FISICA;

    public String isValid() {
        if (tipoPessoa == null)
            return "Tipo pessoa é necessário";
        if (StringUtils.isEmpty(nome))
            return "Nome é necessário";
        if (StringUtils.isEmpty(endereco))
            return "Endereço é necessário";
        if (StringUtils.isEmpty(numero))
            return "Numero é necessário";
        if (StringUtils.isEmpty(bairro))
            return "Bairro é necessário";
        if (StringUtils.isEmpty(cidade))
            return "Cidade é necessário";
        if (StringUtils.isEmpty(uf))
            return "UF é necessário";
        if (StringUtils.isEmpty(cep))
            return "CEP é necessário";
        if (StringUtils.isEmpty(cnpjCpf))
            return "Cpf é necessário";
        return null;
    }

    public String getCnpjCpf() {
        String s = cnpjCpf.replaceAll("[^a-zA-Z0-9]", "").trim();
        if (tipoPessoa == TipoPessoa.FISICA) {
            return StringUtils.leftPad(s, 11, '0');
        } else {
            return StringUtils.leftPad(s, 14, '0');
        }
    }

    public String getNome() {
        return StringUtils.substring(nome, 0, 100);
    }

    public String getEndereco() {
        return StringUtils.substring(endereco, 0, 90);
    }

    public String getNumero() {
        return StringUtils.substring(numero, 0, 10);
    }

    public String getComplemento() {
        return StringUtils.substring(complemento, 0, 30);
    }

    public String getBairro() {
        return StringUtils.substring(bairro, 0, 60);
    }

    public String getCidade() {
        return StringUtils.substring(cidade, 0, 60);
    }

    public String getUF() {
        return StringUtils.substring(uf, 0, 2);
    }

    public String getCep() {
        String s = cep.replaceAll("[^a-zA-Z0-9]", "").trim();
        return StringUtils.substring(s, 0, 8);
    }

    public String getEmail() {
        return StringUtils.substring(email.trim(), 0, 50);
    }

    public String getTelefone() {
        String s = telefone.replaceAll("[^a-zA-Z0-9]", "").trim();
        return StringUtils.right(s, 9);
    }
}
