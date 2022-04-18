package br.terna.inter.v1.boleto.download;

import lombok.Data;

@Data
public class DownloadResponse {
    private byte[] pdf;
}
