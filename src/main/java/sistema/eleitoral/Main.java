package sistema.eleitoral;
import javax.swing.JFrame;

public class Main extends JFrame{

    public static void main(String[] args){

        SistemaEleitoralInterface sistemaInterface = new SistemaEleitoralMap();
        SistemaEleitoralGUI sistemaGUI = new SistemaEleitoralGUI(sistemaInterface);
        sistemaGUI.setVisible(true);


    }
}
