package Programa;

import java.util.ArrayList;

public class ArtigoSolicitado extends ArtigoAceito {

    public ArtigoSolicitado(String titulo, String resumoAbstract, String palavrasChave, int quantidadePaginas, String dataEmissao, ArrayList<Double> listaNotas, ArrayList<Participante> listaAutores) {
        super(titulo, resumoAbstract, palavrasChave, quantidadePaginas, dataEmissao, listaNotas, listaAutores);
    }
}

