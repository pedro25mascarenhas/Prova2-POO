package Programa;

import java.util.ArrayList;

public class ArtigoAceito {
    int idArtigo = 0;
    String titulo;
    String resumoAbstract;
    String palavrasChave;
    int quantidadePaginas;
    String dataEmissao;
    boolean aceito = false;

    public boolean isAceito() {
        return aceito;
    }

    public void setAceito(boolean aceito) {
        this.aceito = aceito;
    }

    ArrayList<Double> listaNotas;
    ArrayList<Participante> listaAutores;
    ArrayList<Participante> listaRevisores = new ArrayList<>();

    public int getIdArtigo() {
        return idArtigo;
    }

    public ArtigoAceito(String titulo, String resumoAbstract, String palavrasChave,
                        int quantidadePaginas, String dataEmissao, ArrayList<Double> listaNotas, ArrayList<Participante> listaAutores) {
        this.titulo = titulo;
        this.resumoAbstract = resumoAbstract;
        this.palavrasChave = palavrasChave;
        this.quantidadePaginas = quantidadePaginas;
        this.dataEmissao = dataEmissao;
        this.listaNotas = listaNotas;
        this.listaAutores = listaAutores;
        idArtigo++;

    }

    public void setIdArtigo(int idArtigo) {
        this.idArtigo = idArtigo;
    }

    public ArrayList<Double> getListaNotas() {
        return listaNotas;
    }

    public void setListaNotas(ArrayList<Double> listaNotas) {
        this.listaNotas = listaNotas;
    }

    public void setListaAutores(ArrayList<Participante> listaAutores) {
        this.listaAutores = listaAutores;
    }

    public ArrayList<Participante> getListaRevisores() {
        return listaRevisores;
    }

    public void setListaRevisores(ArrayList<Participante> listaRevisores) {
        this.listaRevisores = listaRevisores;
    }

    public ArrayList<Participante> getListaAutores() {
        return listaAutores;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumoAbstract() {
        return resumoAbstract;
    }

    public void setResumoAbstract(String resumoAbstract) {
        this.resumoAbstract = resumoAbstract;
    }

    public String getPalavrasChave() {
        return palavrasChave;
    }

    public void setPalavrasChave(String palavrasChave) {
        this.palavrasChave = palavrasChave;
    }

    public int getQuantidadePaginas() {
        return quantidadePaginas;
    }

    public void setQuantidadePaginas(int quantidadePaginas) {
        this.quantidadePaginas = quantidadePaginas;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(String dataEmissao) {
        this.dataEmissao = dataEmissao;
    }




    public String toString() {

        return "\nTitulo: " + this.getTitulo() +
                "\nAbstract: " + this.getResumoAbstract() +
                "\nPalavras-chave: " + this.getPalavrasChave() +
                "\nData de emissão: " + this.getDataEmissao() +
                "\nAvaliações: "  + this.getListaNotas() +
                "\nQuantidade de páginas: " + this.getQuantidadePaginas() +
                "\nAutores: " + this.getListaAutores()+
                "\nAceito: " + this.isAceito();
    }
}
