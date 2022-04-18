package br.terna.inter.v2.boleto.emissao;

import org.apache.commons.lang.StringUtils;

public class Pagador {
    private String cnpjCpf;
    private String nome;
    private String email = "";
    private String telefone = "";
    private String cep;
    private String numero;
    private String complemento = "";
    private String bairro;
    private String cidade;
    private String uf;
    private String endereco;
    private String ddd = "";
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

    public void setCnpjCpf(String cnpjCpf) {
        this.cnpjCpf = cnpjCpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }
}
