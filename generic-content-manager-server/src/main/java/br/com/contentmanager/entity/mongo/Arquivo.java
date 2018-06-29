package br.com.contentmanager.entity.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "arquivo")
public class Arquivo {

	@Id
    private String id;
    private String data;
    private String nome;
    private String conteudo;
 
    public Arquivo(String nome, String conteudo) {
        this.nome = nome;
        this.conteudo = conteudo;
    }
}
