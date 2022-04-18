package br.terna.inter.v1.boleto.download;

public class DownloadResponse {
    private byte[] pdf;

    public byte[] getPdf() {
        return pdf;
    }

    public void setPdf(byte[] pdf) {
        this.pdf = pdf;
    }
}
