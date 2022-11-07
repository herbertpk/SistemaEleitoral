import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
package sistemaEleitoral;


public class SistemaEleitoralInterfaceTeste extends JFrame{
    public SistemaEleitoralInterfaceTeste(){
        setTitle("Sistema Eleitoral");
        setSize(800,600);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(null);

        JButton btn_votar = new JButton("Votar");
        btn_votar.setBounds(100,200,120,90);
        btn_votar.addActionListener(this::votarInterface);
        add(btn_votar);

    }

    public void votarInterface(ActionEvent btn_votar){
        setVisible(false);
        JDialog janela = new JDialog();
        janela.setModal(true);
        janela.setTitle("Votar");
        janela.setSize(800,600);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
        janela.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        setVisible(true);
    }
}
