import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame{

    private JButton botao_jogar;
    private JButton botao_classificacao;
    private JPanel painel;
    private JogoVelha metodos;


    public Menu(JogoVelha jogo) {
        this.metodos = jogo;

        setVisible(true);
        setSize(1280,720);
        setContentPane(painel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        botao_jogar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Tela_Jogadores telaJogadores = new Tela_Jogadores(metodos);
            }
        });
        botao_classificacao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Classificacao classificacao = new Classificacao(metodos);
            }
        });
    }










}


