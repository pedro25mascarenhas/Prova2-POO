package Programa;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.*;
import java.io.*;

public class Congresso {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Participante> listaParticipantes;
    static ArrayList<Solicitantes> listaSolicitantes;
    static ArrayList<ArtigoSolicitado> listaArtigoSolicitado;
    static ArrayList<ArtigoAceito> listaArtigoAceitos;
    static ArrayList<Double> listaNotas;
    static ArrayList<Participante> listaAutores;
    static ArrayList<Integer> listaIdArtigosAvaliados;



    public static void main(String[] args) {
        listaParticipantes = new ArrayList<Participante>();
        listaSolicitantes = new ArrayList<Solicitantes>();
        listaArtigoSolicitado = new ArrayList<ArtigoSolicitado>();
        listaArtigoAceitos = new ArrayList<ArtigoAceito>();
        listaAutores = new ArrayList<Participante>();
        Participante participante = new Participante("Pedro", "085", "123",
                "10/10/2010", "Doutor", "UFBA", "General Chair", true);
        listaParticipantes.add(participante);
        Participante participante1 = new Participante("Samuel", "100", "123",
                "10/10/2002", "Pos Doutor", "UFBA", "Revisor", true);
        Participante participante2 = new Participante("Samuel", "1000", "123",
                "10/10/2002", "Pos Doutor", "UFBA", "Program Chair", true);

        listaParticipantes.add(participante1);
        listaParticipantes.add(participante2);
        Solicitantes solicitante = new Solicitantes("Joao", "001","123","10/10/12",
                "Doutor", "USP", "Normal", false);
        listaSolicitantes.add(solicitante);


        listaNotas = new ArrayList<Double>();
        listaNotas.add(4.0);
        listaAutores.add(participante);
        ArtigoSolicitado artigoSolicitado = new ArtigoSolicitado("A","A","A",1,"0",
                listaNotas, listaAutores);
        System.out.println(artigoSolicitado.getIdArtigo());

        listaArtigoSolicitado.add(artigoSolicitado);

        ArtigoAceito artigoAceito = new ArtigoAceito("B","A","A",1,"0",
                listaNotas, listaAutores);
        ArtigoAceito artigoAceito2 = new ArtigoAceito("A","A","A",1,"0",
                listaNotas, listaAutores);
        listaArtigoAceitos.add(artigoAceito);
        listaArtigoAceitos.add(artigoAceito2);

        listaIdArtigosAvaliados = new ArrayList<Integer>();
        listaIdArtigosAvaliados.add(1);
        participante1.setListaIdArtigosAvaliados(listaIdArtigosAvaliados);

        ArrayList<String> listaArtigosOrdemAlfabetica = new ArrayList<String>();

        login();
    }

    public static void login(){
        System.out.println("\n------ Sistema de Login ------");
        System.out.println("Digite seu CPF: ");
        String cpf = input.next();
        Participante participante = encontrarParticipante(cpf);

        if(participante == null){
            System.out.println("Participante não encontrado, tente novamente: ");
            login();
        }else{
            System.out.println("Digite sua senha: ");
            String senha = input.next();
            if(Objects.equals(participante.getSenha(), senha)){
                System.out.println("Você logou com sucesso " + participante.getNome());
                menu(cpf);
            }else{
                System.out.println("Aconteceu um erro, tente novamente:");
                login();
            }
        }


    }
    public static void menu(String cpf) {
        System.out.println(("-------------------------------------------------------"));
        System.out.println("--------------- Sistema congresso CBPOO ----------------");
        System.out.println(("-------------------------------------------------------"));
        System.out.println(" ");
        System.out.println(("***** Menu de Operações ******"));
        System.out.println("|     Opção 1 - Cadastrar Participante");
        System.out.println("|     Opção 2 - Submeter artigo");
        System.out.println("|     Opção 3 - Opções de General Chair");
        System.out.println("|     Opção 4 - Opções de Revisor");
        System.out.println("|     Opção 5 - Opções de Program Chair");
        System.out.println("|     Opção 6 - Listar artigos aceitos em ordem alfabética");
        System.out.println("|     Opção 7 - Listar artigos negados em ordem alfabética");
        System.out.println("|     Opção 8 - Ver dados de um artigo");
        System.out.println("|     Opção 9 - Listar participantes do evento em ordem alfabética");
        System.out.println("|     Opção 10 - Sair");

        int operacao = input.nextInt();
        Participante participante = encontrarParticipante(cpf);
        String tipoConta = participante.getTipoConta();
        switch (operacao) {
            case 1 -> cadastrarParticipante(cpf);

            case 2 -> {
                submeterArtigo(cpf);
            }

            case 3 -> {

                if (Objects.equals(tipoConta, "General Chair")) {
                    System.out.println("Validar conta: Digite 1");
                    System.out.println("Invalidar conta: Digite 2");
                    System.out.println("Emitir certificado: Digite 3");
                    int escolha = input.nextInt();
                    if(escolha == 1){
                        validarParticipante(cpf);
                    }else if(escolha == 2){
                        invalidarParticipante(cpf);
                    }else if(escolha==3){
                        emitirCertificado(cpf);
                    }

                } else {
                    System.out.println("Para selecionar essa opção é preciso ter uma conta General Chair\n" +
                            "Retornando ao menu inicial");
                    menu(cpf);
                }
            }

            case 4 -> {
                if (Objects.equals(tipoConta, "Revisor")) {
                    System.out.println("Avaliar artigo: Digite 1");
                    System.out.println("Minhas avaliações: Digite 2");
                    int escolha = input.nextInt();
                    if(escolha == 1){
                        avaliarArtigo(participante);
                    }else if(escolha == 2){
                        avaliacoesArtigos(tipoConta, participante);
                    }

                } else {
                    System.out.println("Para selecionar essa opção é preciso ter uma conta Revisor\n" +
                            "Retornando ao menu inicial");
                    menu(cpf);
                }
            }

            case 5 -> {
                if (Objects.equals(tipoConta, "Program Chair")) {
                    System.out.println("Aceitar artigo: Digite 1");
                    System.out.println("Excluir artigo: Digite 2");
                    System.out.println("Rejeitar artigo: Digite 3");
                    System.out.println("Ver todas as avaliações de artigos: Digite 4");
                    int escolha = input.nextInt();
                    if(escolha == 1){
                        aceitarArtigo(cpf);
                    }else if(escolha == 2){
                        excluirArtigo(cpf);
                    }else if(escolha == 3){
                        System.out.println("No momento da solicitação, o artigo já é automaticamente negado\n" +
                                "Se quiser excluir um arquivo já aceito, tente a opção 3");
                    }else if(escolha == 4){
                        avaliacoesArtigos(tipoConta, participante);
                    }

                } else {
                    System.out.println("Para selecionar essa opção é preciso ter uma conta Program Chair\n" +
                            "Retornando ao menu inicial");
                    menu(cpf);
                }
            }

            case 6 -> {
                ArrayList<String> listaTitulos = new ArrayList<>();
                for(ArtigoAceito artigoAceito : listaArtigoAceitos){
                    listaTitulos.add(artigoAceito.getTitulo());
                }
                Collections.sort(listaTitulos);
                System.out.println("Lista de artigos aceitos em ordem alfabética: ");
                System.out.println(listaTitulos);
            }

            case 7 -> {
                ArrayList<String> listaTitulos = new ArrayList<>();
                for(ArtigoSolicitado artigoSolicitado : listaArtigoSolicitado){
                    listaTitulos.add(artigoSolicitado.getTitulo());
                }
                Collections.sort(listaTitulos);
                System.out.println("Lista de artigos solicitados em ordem alfabética: ");
                System.out.println(listaTitulos);
            }

            case 8 -> {
                System.out.println("Lista de Artigos aceitos: ");
                System.out.println(listaArtigoAceitos);
                System.out.println("");
                System.out.println("Digite o Id do artigo para ver suas informações: ");
                int idArtigo = input.nextInt();
                System.out.println(encontrarArtigo(idArtigo));
            }

            case 9 -> {
                ArrayList<String> lista = new ArrayList<>();
                for(Participante p : listaParticipantes){
                    lista.add(p.getNome());
                }
                Collections.sort(lista);
                System.out.println("Lista de participantes em ordem alfabética: ");
                System.out.println(lista);
            }
            case 10 -> {
                System.out.println("Voce saiu");
                System.exit(0);

            }
            default -> {
                System.out.println("Opcao invalida, tente novamente: ");
                menu(cpf);
            }
        }
    }

    public static void avaliacoesArtigos(String tipoConta, Participante participante){
        if(Objects.equals(tipoConta, "Program Chair")){
            if (listaArtigoAceitos.size() > 0) {
                for (ArtigoAceito c : listaArtigoAceitos) {
                    System.out.println("");
                    System.out.println("Titulo: " + c.getTitulo());
                    System.out.println("Avaliações: " + c.getListaNotas());
                    System.out.println("");
                }
            }else if(Objects.equals(tipoConta, "Revisor")){
                for(int c : participante.listaIdArtigosAvaliados){
                    System.out.println(encontrarArtigo(c));

                }

                }
            }
        menu(participante.getCpf());
        }

    public static void avaliarArtigo(Participante participante){
        System.out.println("Lista de Artigos: ");
        System.out.println(listaArtigoAceitos);
        System.out.println("Selecione o ID do artigo que quer avaliar: ");
        int idArtigo = input.nextInt();
        ArtigoAceito artigo = encontrarArtigo(idArtigo);
        String tituloArtigoAvaliado = null;
        ArrayList<Double> listaNotas = new ArrayList<>();
        System.out.println(artigo);
        while(true){
            System.out.println("Dê uma nota de 0.0 - 10.0: ");
            double nota = input.nextDouble();
            if(nota >= 0.0 && nota <= 10.0){

                artigo.listaNotas.add(nota);
                participante.getListaIdArtigosAvaliados().add(idArtigo);
                break;
            }else{
                System.out.println("Você digitou um numero fora da escala, tente novamente: ");
            }
        }
        System.out.println(listaArtigoAceitos);
        menu(participante.getCpf());
    }
    public static ArtigoSolicitado encontrarSolicitacaoArtigo(int id) {
        ArtigoSolicitado artigo = null;
        if (listaArtigoSolicitado.size() > 0) {
            for (ArtigoSolicitado c : listaArtigoSolicitado) {
                if (c.getIdArtigo() == id) {
                    artigo = c;
                }
            }
        }
        return artigo;
    }

    public static ArtigoAceito encontrarArtigo(int id) {
        ArtigoAceito artigo = null;
        if (listaArtigoAceitos.size() > 0) {
            for (ArtigoAceito c : listaArtigoAceitos) {
                if (c.getIdArtigo() == id) {
                    artigo = c;
                }
            }
        }
        return artigo;
    }
    public static void emitirCertificado(String cpf){
        System.out.println("Lista de participantes: ");
        System.out.println(listaParticipantes);
        System.out.println("Digite o cpf do participante para o certificado: ");
        String cpfParticipante = input.next();
        Participante participante = encontrarParticipante(cpfParticipante);
        participante.setCertificado(true);
        System.out.println("Certificado emitido com sucesso!");
        System.out.println(participante);
        menu(cpf);
    }

    public static void excluirArtigo(String cpf){
        System.out.println("Lista de artigos aceitos: ");
        System.out.println("");
        System.out.println(listaArtigoAceitos);
        System.out.println("");
        System.out.println("Digite o id do artigo que pretende rejeitar (O artigo será removido): ");
        int id = input.nextInt();
        ArtigoAceito artigo = encontrarArtigo(id);
        artigo.setAceito(false);

        listaArtigoAceitos.remove(artigo);
        System.out.println("Artigo removido com sucesso");
        System.out.println("");
        System.out.println("Lista artigos atualizada: ");
        System.out.println("");
        System.out.println(listaArtigoAceitos);
        menu(cpf);
    }

    public static void aceitarArtigo(String cpf){
        System.out.println("Lista de artigos que foram solicitados: ");
        System.out.println("");
        System.out.println(listaArtigoSolicitado);
        System.out.println("");
        System.out.println("Digite o id do artigo que pretende aceitar: ");
        int id = input.nextInt();
        ArtigoSolicitado artigo = encontrarSolicitacaoArtigo(id);
        artigo.setAceito(true);

        listaArtigoAceitos.add(artigo);
        listaArtigoSolicitado.remove(artigo);

        System.out.println("Artigo aceito com sucesso");
        System.out.println("");
        System.out.println("Lista artigos aceitos atualizada: ");
        System.out.println("");
        System.out.println(listaArtigoAceitos);
        System.out.println("");
        System.out.println("Lista artigos solicitados(não aceitos): ");
        System.out.println("");
        System.out.println(listaArtigoSolicitado);
    menu(cpf);
    }
    public static void validarParticipante(String cpf){
        System.out.println("Lista de usuários solicitantes: ");
        System.out.println("");
        System.out.println(listaSolicitantes);
        System.out.println("");
        System.out.println("Digite o cpf do participante que pretende validar: ");
        String cpfParticipante = input.next();
        Solicitantes solicitante = encontrarSolicitante(cpfParticipante);
        solicitante.setValidacao(true);

        listaParticipantes.add(solicitante);
        listaSolicitantes.remove(solicitante);

        System.out.println("Lista solicitantes atualizada");
        System.out.println("");
        System.out.println(listaSolicitantes);

        System.out.println("Lista  participantes atualizada");
        System.out.println(listaParticipantes);

        menu(cpf);
    }

    public static void invalidarParticipante(String cpf){
        System.out.println("Lista de usuários participantes: ");
        System.out.println("");
        System.out.println(listaParticipantes);
        System.out.println("");
        System.out.println("Digite o cpf do participante que pretende invalidar (a conta será excluída): ");
        String cpfParticipante = input.next();
        Participante participante = encontrarParticipante(cpfParticipante);
        participante.setValidacao(false);

        listaParticipantes.remove(participante);

        System.out.println("Lista  participantes atualizada");
        System.out.println(listaParticipantes);

        menu(cpf);
    }

    public static Participante encontrarParticipante(String cpf) {
        Participante participante = null;
        if(listaParticipantes.size() > 0){
            for(Participante c: listaParticipantes) {
                if(Objects.equals(c.getCpf(), cpf)) {
                    participante = c;
                }
            }
        }
    return participante;
    }

    public static Solicitantes encontrarSolicitante(String cpf) {
        Solicitantes solicitantes = null;
        if(listaSolicitantes.size() > 0){
            for(Solicitantes c: listaSolicitantes) {
                if(Objects.equals(c.getCpf(), cpf)) {
                    solicitantes = c;
                }
            }
        }
        return solicitantes;
    }

    public static void submeterArtigo(String cpf){
        System.out.println("----- Ficha de Submissão de Artigos ------");
        System.out.println("\nTítulo: ");
        String titulo = input.next();

        System.out.println("\nAbstract: ");
        String resumoAbstract = input.next();

        System.out.println("\nPalavras-Chave: ");
        String palavrasChave = input.next();

        System.out.println("\nQuantidade de páginas: ");
        int quantidadePaginas = input.nextInt();

        System.out.println("\nData de emissão: ");
        String dataEmissao = input.next();

        System.out.println("\nAlem de você, quantos autores quer adicionar? 0-4");
        int qntAutores = input.nextInt();
        ArrayList<Participante> listaAutores = new ArrayList<>();
        Participante participanteOriginal = encontrarParticipante(cpf);
        listaAutores.add(participanteOriginal);
        ArrayList<Double> listaNotas = new ArrayList<>();

        for(int autores = 1; autores<=qntAutores;autores++){
            System.out.println("Para adicionar um participante que ja esta inscrito no congresso, digite 1:\n" +
                    "Para adicionar um participante não inscrito, digite 2:");
            int escolha = input.nextInt();
            if(escolha == 1){
                System.out.println("Digite o cpf do Autor que deseja adicionar: ");
                String cpfAutor = input.next();
                Participante participante = encontrarParticipante(cpfAutor);
                listaAutores.add(participante);
            }else if(escolha == 2){
                System.out.println("\nNome: ");
                String nome = input.next();

                System.out.println("\nCPF: ");
                String cpfAutor = input.next();
                String senha = null;
                String tipoConta = "Autor";
                boolean validacao = false;
                System.out.println("\nData de Nascimento: ");
                String dataNascimento = input.next();

                System.out.println("\nTitulação Academica: ");
                String titulacaoAcademica = input.next();

                System.out.println("\nInstituição de Vínculo: ");
                String instituicaoVinculo = input.next();

                Participante participante = new Participante(nome, cpfAutor, senha, dataNascimento,titulacaoAcademica,
                        instituicaoVinculo, tipoConta, validacao);
                listaAutores.add(participante);

            }else{
                System.out.println("Você digitou algo errado, tente novamente.");
                autores--;
            }
        }

        System.out.println("Solicitação de artigo efetuada com sucesso!");

        ArtigoAceito artigoAceito = new ArtigoAceito(titulo,resumoAbstract,palavrasChave,quantidadePaginas, dataEmissao,
                listaNotas, listaAutores);
        listaArtigoAceitos.add(artigoAceito);
        System.out.println(artigoAceito);


        menu(cpf);
           }
    public static void cadastrarParticipante(String cpf) {
        System.out.println("------ Ficha de Cadastramento -------");
        System.out.println("\nNome: ");
        String nome = input.next();

        System.out.println("\nCPF: ");
        String cpfCadastrado = input.next();

        System.out.println("\nSenha: ");
        String senha = input.next();

        System.out.println("\nData de Nascimento: ");
        String dataNascimento = input.next();

        System.out.println("\nTitulação Academica: ");
        String titulacaoAcademica = input.next();

        System.out.println("\nInstituição de Vínculo: ");
        String instituicaoVinculo = input.next();

        System.out.println("\nTipo da Conta: ");
        System.out.println("\n1 - Normal");
        System.out.println("\n2 - General Chair");
        System.out.println("\n3 - Revisor");
        System.out.println("\n4 - Program Chair");

        int tipoInt = 0;
        String tipoConta = null;
        while(true){
            tipoInt = input.nextInt();
            if(tipoInt == 1){
                tipoConta = "Normal";
                break;
            }else if(tipoInt == 2){
                tipoConta = "General Chair";
                break;
            }else if(tipoInt == 3){
                tipoConta = "Revisor";
                break;
            }else if(tipoInt == 4){
                tipoConta = "Program Chair";
                break;
            }else{
                System.out.println("Voce digitou um valor errado, tente novamente: ");
            }
        }
        boolean validacao = false;

        Solicitantes solicitantes = new Solicitantes(nome, cpfCadastrado, senha, dataNascimento,titulacaoAcademica,
                instituicaoVinculo, tipoConta, validacao);
        listaSolicitantes.add(solicitantes);
        System.out.println(listaSolicitantes);
        System.out.println("****************************************");
        System.out.println("Solicitação efetuada, aguarde a resposta");
        System.out.println("****************************************");
        menu(cpf);
    }

}
