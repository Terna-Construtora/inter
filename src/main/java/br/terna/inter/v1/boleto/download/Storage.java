package br.terna.inter.v1.boleto.download;


import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Slf4j
public class Storage {
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static      Storage           instance            = new Storage();
    private             File              rootPath;

    public static Storage get() {
        return instance;
    }

    @SneakyThrows
    public byte[] getNossoNumero(String nossoNumero) {
        this.checkRootPath();
        File arquivo = getArquivo(nossoNumero);
        if (arquivo != null) return IOUtils.toByteArray(new FileInputStream(arquivo));
        return null;
    }

    private File getArquivo(String nossoNumero) {
        this.checkRootPath();
        File[] files = rootPath.listFiles((file, name) -> name.startsWith(nossoNumero + "-") || name.equals(nossoNumero + ".pdf"));
        if (files.length > 0) return files[0];
        return null;
    }

    public void setLido(String nossoNumero) {
        File arquivo = getArquivo(nossoNumero);
        if (arquivo == null) return;
        File novoNome = new File(arquivo.getParent(), nossoNumero + "-" + DATE_TIME_FORMATTER.format(LocalDate.now()) + ".pdf");
        arquivo.renameTo(novoNome);
    }

    public void checkRootPath() {
        if (rootPath == null) {
            throw new RuntimeException("RootPath do Storage deve ser configurado antes de usa-lo");
        }
    }

    public void setRootPath(File rootPath) {
        if (!rootPath.exists()) rootPath.mkdirs();
        this.rootPath = rootPath;
    }

    public void gravar(String nossoNumero, byte[] content) {
        this.checkRootPath();
        File file = getArquivo(nossoNumero);
        if (file == null)
            file = new File(rootPath, nossoNumero + ".pdf");
        log.info("Gravando no storage boleto " + file.getAbsoluteFile().getName());
        try {
            IOUtils.write(content, new FileOutputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
