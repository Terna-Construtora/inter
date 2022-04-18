package br.terna.inter.v2;

import br.terna.inter.v2.boleto.Boleto;
import br.terna.inter.v2.extrato.Extrato;
import br.terna.inter.v2.webhook.WebHook;

import java.io.InputStream;

public class InterV2 {
    HttpInterConnectionV2 con;

    public final Boleto boleto;
    public final WebHook webHook;
    public final Extrato extrato;

    public InterV2(String p12Password, InputStream p12Is) throws Exception {
        con = new HttpInterConnectionV2(p12Password, p12Is);
        boleto = new Boleto(con);
        webHook = new WebHook(con);
        extrato = new Extrato(con);
    }


}
