import java.util.ArrayList;

public class JogoVelha {
    private char tabuleiro [][];
    private boolean tabuleiroCheio [][];
    private char letra;
    private int jogadas;
    public char jogador;
    static Dados dadosJogadores;
    static Dados dadosVitorias;

    public JogoVelha(){
        this.tabuleiro = new char[3][3];
        this.jogadas = 0;
        this.jogador = 'X';
        dadosJogadores = new Dados();
        dadosVitorias = new Dados();

        this.tabuleiroCheio = new boolean[3][3];
        for(int l=0; l<3; l++){
            for(int c=0; c<3; c++){
                this.tabuleiroCheio[l][c] = false;
            }
        }

    }

    public void jogada(char jogador, int jogadaX, int jogadaY ){
        if(jogadaX >= 0 && jogadaX <=2 && jogadaY >= 0 && jogadaY <=2){

            if(!this.tabuleiroCheio[jogadaX][jogadaY]){
                letra = jogador;
                tabuleiro[jogadaX][jogadaY] = letra;
                tabuleiroCheio[jogadaX][jogadaY] = true;
                jogadas++;
            }
        }

    }

    public boolean deuVelha(){
        if(jogadas == 9){
            return true;
        }
        return false;
    }

    public boolean verificaGanhador(char l){
        //verificar horizontais
        for(int i=0; i<3; i++){
            if(tabuleiro[i][0] == l && tabuleiro[i][1] == l && tabuleiro[i][2] == l){
                return true;
            }
        }

        //verificar verticais
        for(int i=0; i<3; i++){
            if(tabuleiro[0][i] == l && tabuleiro[1][i] == l && tabuleiro[2][i] == l){
                return true;
            }
        }

        //verificar diagonal principal
            if(tabuleiro[0][0] == l && tabuleiro[1][1] == l && tabuleiro[2][2] == l){
                return true;
            }


        //verificar diagonal secundária
            if(tabuleiro[2][0] == l && tabuleiro[1][1] == l && tabuleiro[0][2] == l){
                return true;
            }

        //se não houver ganhador:
        return false;
    }

    public void alterarJogador(){
        if(this.jogador == 'X'){
            this.jogador = 'O';
        }else{
            this.jogador = 'X';
        }
    }

    public char getJogador(){
        return jogador;
    }

    public void zerar(){
        this.jogadas = 0;
        this.jogador = 'X';

        for(int l=0; l<3; l++){
            for(int c=0; c<3; c++){
                this.tabuleiro[l][c] = ' ';
                this.tabuleiroCheio[l][c] = false;
            }
        }
    }

    public void cadastrarJogador(String nome){
        dadosJogadores.salvarCadastro(nome);
    }

    //arraylist
    public static void adicionarVitoria(String nome){
        dadosVitorias.salvarVitoria(nome);
    }

    public static ArrayList<String> getJogadores(){
        return dadosJogadores.getJogadoresCadastrados();
    }

    public static int getVitorias(String jogador){
        return dadosVitorias.getQuantidadeVitorias(jogador);
    }
}
