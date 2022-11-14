package Programa;

import java.util.ArrayList;

public class Participante {
    private static int idParticipante = 1;
    private String nome;
    private String cpf;
    private String senha;
    private String dataNascimento;
    private String titulacaoAcademica;
    private String instituicaoVinculo;
    private String tipoConta;
    private boolean validacao;
    private boolean certificado = false;

    ArrayList<Integer> listaIdArtigosAvaliados;

    public ArrayList<Integer> getListaIdArtigosAvaliados() {
        return listaIdArtigosAvaliados;
    }

    public void setListaIdArtigosAvaliados(ArrayList<Integer> listaIdArtigosAvaliados) {
        this.listaIdArtigosAvaliados = listaIdArtigosAvaliados;
    }

    public Participante(String nome, String cpf, String senha, String dataNascimento,
                        String titulacaoAcademica, String instituicaoVinculo, String tipoConta, boolean validacao) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.titulacaoAcademica = titulacaoAcademica;
        this.instituicaoVinculo = instituicaoVinculo;
        this.tipoConta = tipoConta;
        this.validacao = validacao;
        idParticipante += 1;
    }

    public boolean isCertificado() {
        return certificado;
    }

    public void setCertificado(boolean certificado) {
        this.certificado = certificado;
    }

    public static int getIdParticipante() {
        return idParticipante;
    }

    public boolean isValidacao() {
        return validacao;
    }

    public void setValidacao(boolean validacao) {
        this.validacao = validacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTitulacaoAcademica() {
        return titulacaoAcademica;
    }

    public void setTitulacaoAcademica(String titulacaoAcademica) {
        this.titulacaoAcademica = titulacaoAcademica;
    }

    public String getInstituicaoVinculo() {
        return instituicaoVinculo;
    }

    public void setInstituicaoVinculo(String instituicaoVinculo) {
        this.instituicaoVinculo = instituicaoVinculo;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String toString() {
        return "\nNome: " + this.getNome() +
                "\nCPF: " + this.getCpf() +
                "\nData de Nascimento: " + this.getDataNascimento() +
                "\nTitulação Acadêmica: " + this.getTitulacaoAcademica() +
                "\nInstituição de Vínculo: " + this.getInstituicaoVinculo() +
                "\nSenha: " + this.getSenha() +
                "\nTipo da Conta: " + this.getTipoConta() +
                "\nValidação: " + this.isValidacao() +
                "\nCertificado: " + this.isCertificado();
    }
}
