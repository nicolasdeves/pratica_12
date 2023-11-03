import comum.Arquivo;

import java.util.ArrayList;

public class Dados {
    Arquivo jogadores;
    Arquivo vitorias;

    public Dados(){
        jogadores = new Arquivo("jogadores.txt");
        vitorias = new Arquivo("vitorias.txt");
    }

    public boolean salvarCadastromeu(String jogador){
        //verifica se o jogador ja existe no cadastro e quantidade de linhas
        int quantLinhas = 0;
        boolean jaCadastrado = false;
        if(jogadores.abrirLeitura()){
            String linha = jogadores.lerLinha();
            while(linha!=null){
                quantLinhas++;
                if(linha.equals(jogador)){
                    jaCadastrado = true;
                }else{
                    linha = jogadores.lerLinha();
                }
            }
            jogadores.fecharArquivo();

            //salva os nomes
            //salvar os nomes numa arraylist para nao bugar se o nome estiver repetido!!!
            jogadores.abrirLeitura();
            ArrayList<String> backup = new ArrayList<>();
            while(true){
                String leitura = jogadores.lerLinha();
                if(leitura == null){
                    break;
                }
                backup.add(leitura);
            }
            jogadores.fecharArquivo();

            //registra os jogadores
            jogadores.abrirEscrita();
            for(int i=0; i<backup.size(); i++){
                jogadores.escreverLinha(backup.get(i));
            }
            jogadores.escreverLinha(jogador);
            jogadores.fecharArquivo();
        }
        return jaCadastrado;
    }

    //gpt
    public boolean salvarCadastro(String jogador) {
        // Verifica se o jogador já existe no cadastro
        boolean jaCadastrado = false;

        // Lista para armazenar temporariamente os nomes lidos
        ArrayList<String> backup = new ArrayList<>();

        if (jogadores.abrirLeitura()) {
            String linha = jogadores.lerLinha();
            while (linha != null) {
                if (linha.equals(jogador)) {
                    jaCadastrado = true;
                    break; // O jogador já está cadastrado, não é necessário continuar verificando.
                }
                backup.add(linha);
                linha = jogadores.lerLinha();
            }
            jogadores.fecharArquivo();

            // Se o jogador não está cadastrado, atualize o arquivo com o jogador e o backup
            if (!jaCadastrado) {
                backup.add(jogador);

                // Reabre o arquivo para escrita e escreve todas as linhas de volta
                if (jogadores.abrirEscrita()) {
                    for (String nome : backup) {
                        jogadores.escreverLinha(nome);
                    }
                    jogadores.fecharArquivo();
                }
            }
        }
        return jaCadastrado;
    }


    public void salvarVitoria(String jogador){
        // Lista para armazenar temporariamente os nomes lidos
        ArrayList<String> backupVitorias = new ArrayList<>();


        vitorias.abrirLeitura();
        String linhaVitoria = vitorias.lerLinha();

        while(linhaVitoria != null){
            backupVitorias.add(linhaVitoria);
            linhaVitoria = vitorias.lerLinha();
        }
        vitorias.fecharArquivo();


        if(vitorias.abrirEscrita()){
            for(int i=0; i<backupVitorias.size(); i++){
                vitorias.escreverLinha(backupVitorias.get(i));
            }
        }
        vitorias.escreverLinha(jogador);
        vitorias.fecharArquivo();
    }

    public ArrayList<String> getJogadoresCadastrados() {
        ArrayList<String> listaJogadores = new ArrayList<>();
        if (jogadores.abrirLeitura()) {
            String linha = jogadores.lerLinha();
            while (linha != null) {
                listaJogadores.add(linha);
                linha = jogadores.lerLinha();
            }
        }
        jogadores.fecharArquivo();
        return listaJogadores;
    }

    public int getQuantidadeVitorias(String jogador){
        int quantidade = 0;
        vitorias.abrirLeitura();
        String linha = vitorias.lerLinha();

        while(linha!=null){
            if(jogador.equals(linha)){
                quantidade++;
            }
            linha = vitorias.lerLinha();
        }

        vitorias.fecharArquivo();
        return quantidade;
    }


}


/*
    falta ajeitar o metodo de armazenamento das vitorias
    juntas cada nome com sua quabtidade de vitoruas

 */