package br.terna.inter.v1.boleto.emissao;

import org.apache.commons.lang.StringUtils;


public class Mensagem {
    private String linha1;

    private String linha2;

    private String linha3;

    private String linha4;

    private String linha5;

    public Mensagem addLinha(String linha) {
        if (this.linha1 == null) {
            this.linha1 = linha;
            return this;
        }
        if (this.linha2 == null) {
            this.linha2 = linha;
            return this;
        }
        if (this.linha3 == null) {
            this.linha3 = linha;
            return this;
        }
        if (this.linha4 == null) {
            this.linha4 = linha;
            return this;
        }
        if (this.linha5 == null) {
            this.linha5 = linha;
            return this;
        }
        return this;
    }

    public Mensagem() {
    }

    public String getLinha1() {
        return StringUtils.substring(linha1, 0, 78);
    }

    public String getLinha2() {
        return StringUtils.substring(linha2, 0, 78);
    }

    public String getLinha3() {
        return StringUtils.substring(linha3, 0, 78);
    }

    public String getLinha4() {
        return StringUtils.substring(linha4, 0, 78);
    }

    public String getLinha5() {
        return StringUtils.substring(linha5, 0, 78);
    }

    public void setLinha1(String linha1) {
        this.linha1 = linha1;
    }

    public void setLinha2(String linha2) {
        this.linha2 = linha2;
    }

    public void setLinha3(String linha3) {
        this.linha3 = linha3;
    }

    public void setLinha4(String linha4) {
        this.linha4 = linha4;
    }

    public void setLinha5(String linha5) {
        this.linha5 = linha5;
    }
}
