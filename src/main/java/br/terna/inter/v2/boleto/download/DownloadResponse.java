package br.terna.inter.v2.boleto.download;

import lombok.Data;

@Data
public class DownloadResponse {
    private byte[] pdf;
}
