package ais.mobile.iseven.teste_retrofit;

import java.io.Serializable;

/**
 * Created by Rodrigo on 30/08/2016.
 */
public class CandidatosModel implements Serializable{

    private int idCandidato;
    private String nome;
    private int numero;
    private int votos;



    public CandidatosModel(){

    }


    public CandidatosModel(int idCandidato, String nome, int numero, int votos) {
        this.idCandidato = idCandidato;
        this.nome = nome;
        this.numero = numero;
        this.votos = votos;
    }



    public int getIdCandidato() {
        return idCandidato;
    }

    public void setIdCandidato(int idCandidato) {
        this.idCandidato = idCandidato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }


}
