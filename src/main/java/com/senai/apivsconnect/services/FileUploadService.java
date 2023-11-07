package com.senai.apivsconnect.services;

import jakarta.validation.constraints.Null;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class FileUploadService {
    private final Path diretorioImg = Paths.get(System.getProperty("user.dir") + "\\src\\main\\resources\\img");

    public String FazerUpload(MultipartFile imagem) throws IOException {

        if (imagem.isEmpty()){
            System.out.println("Imagem vazia");
            return null;
        }

        String nomeOriginal = imagem.getOriginalFilename();
        String[] nomeArquivoArray = nomeOriginal.split("\\.");
        String extensaoArquivo = nomeArquivoArray[nomeArquivoArray.length - 1]; //JPG

        String prefixoArquivo = LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyyyHHmmss")); //27102023203055

        String novoNomeImagem = prefixoArquivo + "." + extensaoArquivo;

        File imagemCriada = new File(diretorioImg + "\\" + novoNomeImagem); //Cria o arquivo

        var stream = new BufferedOutputStream(new FileOutputStream(imagemCriada));

        stream.write(imagem.getBytes());
        stream.close();
        return novoNomeImagem;
    }
}
