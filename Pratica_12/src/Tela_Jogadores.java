import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tela_Jogadores extends JFrame {
    private JPanel painel;
    private JTextField jogador1_campo;
    private JTextField jogador2_campo;
    private JButton button1;
    private JogoVelha metodos;

    public Tela_Jogadores(JogoVelha jogo) {
        this.metodos = jogo;

        setVisible(true);
        setSize(1280,720);
        setContentPane(painel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        button1.setEnabled(false);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome_jogador1 = jogador1_campo.getText().toUpperCase();
                String nome_jogador2 = jogador2_campo.getText().toUpperCase();

                if (!nome_jogador1.isEmpty() && !nome_jogador2.isEmpty()) {
                    metodos.cadastrarJogador(nome_jogador1);
                    metodos.cadastrarJogador(nome_jogador2);

                    dispose();
                    TelaJogo telaJogo = new TelaJogo(metodos, nome_jogador1, nome_jogador2);
                }
            }
        });

        // Adicione um DocumentListener para verificar o preenchimento dos campos
        jogador1_campo.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                verificarCamposPreenchidos();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                verificarCamposPreenchidos();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                verificarCamposPreenchidos();
            }
        });

        jogador2_campo.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                verificarCamposPreenchidos();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                verificarCamposPreenchidos();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                verificarCamposPreenchidos();
            }
        });
    }

    private void verificarCamposPreenchidos() {
        String nome_jogador1 = jogador1_campo.getText();
        String nome_jogador2 = jogador2_campo.getText();
        button1.setEnabled(!nome_jogador1.isEmpty() && !nome_jogador2.isEmpty());
    }
}
