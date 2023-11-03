
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class Classificacao extends JFrame{
    private JPanel painel;
    private JTable table1;
    private JButton fecharClassificaçãoButton;
    private JogoVelha metodos;
    private ArrayList<String> jogadores;

    public Classificacao(JogoVelha metodos){
        setVisible(true);
        setSize(600,400);
        setContentPane(painel);

        this.metodos = metodos;
        this.jogadores = metodos.getJogadores();

        DefaultTableModel tabela = new DefaultTableModel();
        table1.setModel(tabela);
        tabela.addColumn("JOGADORES");
        tabela.addColumn("VITÓRIAS");

        for(int i=0; i<jogadores.size(); i++){
            tabela.addRow(new Object[]{jogadores.get(i), metodos.getVitorias(jogadores.get(i))});
        }


        fecharClassificaçãoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
