import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class TelaGanhador  extends JFrame{
    private JButton sairButton;
    private JTextArea textArea1;
    private JPanel painel;
    private char ganhador;
    private String texto;
    private String textoVelha;
    private JogoVelha metodos;

public TelaGanhador(char ganhador, String nomeGanhador, JogoVelha metodos){
    setVisible(true);
    setSize(1280,720);
    setContentPane(painel);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    this.metodos = metodos;
    this.ganhador = ganhador;
    this.texto = "O vencedor é "+nomeGanhador+"\n Letra "+ganhador;
    this.textoVelha = "Deu velha! Não há vencedor!";

    textArea1.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
            super.componentResized(e);
            if(ganhador == 'X' || ganhador == 'O'){
                textArea1.setText(texto);
            }
            else{
                textArea1.setText(textoVelha);
            }
        }
    });
    sairButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            metodos.zerar();
            dispose();
            Menu menu = new Menu(metodos);
        }
    });
}
}
