import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.sun.glass.ui.Cursor.setVisible;

public class TelaJogo extends JFrame{
    private JButton button1;
    private JButton button3;
    private JButton button2;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JPanel painel;
    private JogoVelha metodos;
    private String jogadorX;
    private String jogadorO;


    public TelaJogo(JogoVelha metodos, String jogadorX, String jogadorO){
        setVisible(true);
        setSize(1280,720);
        setContentPane(painel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        this.metodos = metodos;

        this.jogadorX = jogadorX;
        this.jogadorO = jogadorO;

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char jogadorAtual = metodos.getJogador();
                metodos.jogada(jogadorAtual, 0, 0);
                button1.setText(String.valueOf(jogadorAtual));
                button1.setEnabled(false);
                verificaVelha();
                verificaGanhadorAlteraJogador(jogadorAtual, jogadorX, jogadorO);
            }
        });


        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char jogadorAtual = metodos.getJogador();
                metodos.jogada(jogadorAtual, 1, 0);
                button2.setText(String.valueOf(jogadorAtual));
                button2.setEnabled(false);
                verificaVelha();
                verificaGanhadorAlteraJogador(jogadorAtual, jogadorX, jogadorO);
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char jogadorAtual = metodos.getJogador();
                metodos.jogada(jogadorAtual, 2, 0);
                button3.setText(String.valueOf(jogadorAtual));
                button3.setEnabled(false);
                verificaVelha();
                verificaGanhadorAlteraJogador(jogadorAtual, jogadorX, jogadorO);
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char jogadorAtual = metodos.getJogador();
                metodos.jogada(jogadorAtual, 0, 1);
                button4.setText(String.valueOf(jogadorAtual));
                button4.setEnabled(false);
                verificaVelha();
                verificaGanhadorAlteraJogador(jogadorAtual, jogadorX, jogadorO);
            }
        });


        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char jogadorAtual = metodos.getJogador();
                metodos.jogada(jogadorAtual, 1, 1);
                button5.setText(String.valueOf(jogadorAtual));
                button5.setEnabled(false);
                verificaVelha();
                verificaGanhadorAlteraJogador(jogadorAtual, jogadorX, jogadorO);
            }
        });

        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char jogadorAtual = metodos.getJogador();
                metodos.jogada(jogadorAtual, 2, 1);
                button6.setText(String.valueOf(jogadorAtual));
                button6.setEnabled(false);
                verificaVelha();
                verificaGanhadorAlteraJogador(jogadorAtual, jogadorX, jogadorO);
            }
        });

        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char jogadorAtual = metodos.getJogador();
                metodos.jogada(jogadorAtual, 0, 2);
                button7.setText(String.valueOf(jogadorAtual));
                button7.setEnabled(false);
                verificaVelha();
                verificaGanhadorAlteraJogador(jogadorAtual, jogadorX, jogadorO);
            }
        });

        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char jogadorAtual = metodos.getJogador();
                metodos.jogada(jogadorAtual, 1, 2);
                button8.setText(String.valueOf(jogadorAtual));
                button8.setEnabled(false);
                verificaVelha();
                verificaGanhadorAlteraJogador(jogadorAtual, jogadorX, jogadorO);

            }
        });

        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char jogadorAtual = metodos.getJogador();
                metodos.jogada(jogadorAtual, 2, 2);
                button9.setText(String.valueOf(jogadorAtual));
                button9.setEnabled(false);
                verificaVelha();
                verificaGanhadorAlteraJogador(jogadorAtual, jogadorX, jogadorO);
            }
        });
    }

    public void verificaGanhadorAlteraJogador(char jogadorAtual, String jogadorX, String jogadorO){
        if(metodos.verificaGanhador(jogadorAtual) && jogadorAtual == 'X'){
            //abre uma nova tela
            TelaGanhador telaGanhador = new TelaGanhador(jogadorAtual, jogadorX, metodos);
            metodos.adicionarVitoria(jogadorX);
            metodos.zerar();
            dispose();
        }
        else if(metodos.verificaGanhador(jogadorAtual) && jogadorAtual == 'O'){
            TelaGanhador telaGanhador = new TelaGanhador(jogadorAtual, jogadorO, metodos);
            metodos.adicionarVitoria(jogadorO);
            dispose();
        }
        else {
            metodos.alterarJogador();
        }
    }

    public void verificaVelha(){
        if(metodos.deuVelha()){
            metodos.zerar();
            dispose();
            TelaGanhador telaGanhador = new TelaGanhador('A', "A", metodos);
        }
    }


}

