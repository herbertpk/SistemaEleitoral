import javax.swing.*;
import java.awt.event.ActionEvent;


public class SistemaEleitoralInterfaceTeste extends JFrame{

    public SistemaEleitoralInterfaceTeste(){
        setTitle("Sistema Eleitoral");
        setSize(800,600);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //Irineu
        setLayout(null);
        //OK
        JButton btn_votar = new JButton("Votar");
        btn_votar.setBounds(100,200,120,90);
        btn_votar.addActionListener(this::votarInterface);
        add(btn_votar);
        //OK
        JButton btn_dadosCand = new JButton("Obter Dados \n Candidatos");
        btn_dadosCand.setBounds(230,200,120,90);
        btn_dadosCand.addActionListener(this::dadosCandidatosInterface);
        add(btn_dadosCand);
        //OK
        JButton btn_contVotos = new JButton("Votos dos candidatos");
        btn_contVotos.setBounds(360,200,120,90);
        btn_contVotos.addActionListener(this::contVotosInterface);
        add(btn_contVotos);
        //OK
        JButton btn_cadCand = new JButton("Cadastrar Candidato");
        btn_cadCand.setBounds(100,330,120,90);
        btn_cadCand.addActionListener(this:: cadCandInterface);
        add(btn_cadCand);
        //ok
        JButton btn_cadEleitor = new JButton("Cadastrar Eleitor");
        btn_cadEleitor.setBounds(230,330,120,90);
        btn_cadEleitor.addActionListener(this::cadEleitorInterface);
        add(btn_cadEleitor);
        //ok
        JButton btn_exit = new JButton("Sair");
        btn_exit.setBounds(360,330,120,90);
        //btn_exit.addActionListener();
        add(btn_exit);


    }
    public void SistemaTexto(){
        JTextField texto = new JTextField("Clique Aqui");
        texto.setBounds(100,100,100,100);
        add(texto);
    }
    public String[] votarInterface(ActionEvent btn_votar){
        String numTitulo = null;
        Integer numVotado = null;
        numTitulo = JOptionPane.showInputDialog("Qual o numero do seu Titulo?");
        numVotado = Integer.parseInt(JOptionPane.showInputDialog("Qual o numero do seu candidato"));
        JOptionPane.showConfirmDialog(null, "O numero do candidato votado é: "+numVotado);

String array[] = {numTitulo,numVotado};

        return array;
    }

    public void dadosCandidatosInterface(ActionEvent btn_dadosCand){
        JDialog janelaDados = new JDialog();
        janelaDados.setModal(true);
        janelaDados.setTitle("Dados dos Candidatos");
        janelaDados.setSize(800,600);
        janelaDados.setLocationRelativeTo(null);
        janelaDados.setVisible(true);
        janelaDados.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        setVisible(true);
    }
    public void contVotosInterface(ActionEvent btn_contVotos){
        setVisible(false);
        JDialog ContVotosjanela = new JDialog();
        ContVotosjanela.setModal(true);
        ContVotosjanela.setTitle("Contar Votos");
        ContVotosjanela.setSize(800,600);
        ContVotosjanela.setLocationRelativeTo(null);
        ContVotosjanela.setVisible(true);
        ContVotosjanela.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        setVisible(true);
    }
    public void cadCandInterface(ActionEvent btn_cadCand ){
        setVisible(false);
        JDialog cadCandjanela = new JDialog();
        cadCandjanela.setModal(true);
        cadCandjanela.setTitle("Cadastrar Candidato");
        cadCandjanela.setSize(800,600);
        cadCandjanela.setLocationRelativeTo(null);
        cadCandjanela.setVisible(true);
        cadCandjanela.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        setVisible(true);
    }
    public void cadEleitorInterface(ActionEvent btn_cadEleitor){
        setVisible(false);
        JDialog cadEleitorjanela = new JDialog();
        cadEleitorjanela.setModal(true);
        cadEleitorjanela.setTitle("Cadastrar Eleitor");
        cadEleitorjanela.setSize(800,600);
        cadEleitorjanela.setLocationRelativeTo(null);
        cadEleitorjanela.setVisible(true);
        cadEleitorjanela.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        setVisible(true);
    }
}
