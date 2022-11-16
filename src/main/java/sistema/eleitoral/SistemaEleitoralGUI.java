package sistema.eleitoral;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;


public class SistemaEleitoralGUI extends JFrame{

    private SistemaEleitoralInterface sistema;
    JLabel colum1, colum2;
    JButton btnDadosCand,btnVotar,btnContVotos,btnCadCand,cadastrarEleitor,btnExit;
    ImageIcon justicaEleitoralImg = new ImageIcon("src"+File.separator+"main"+File.separator+"resources"+File.separator+"img.png");



    public SistemaEleitoralGUI(SistemaEleitoralInterface sistema){
        this.sistema = sistema;
        setTitle("Sistema Eleitoral");
        setSize(1280,720);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.LIGHT_GRAY);





        btnVotar = new JButton("Votar");
        btnVotar.addActionListener(this::votarInterface);
        add(btnVotar);

        btnDadosCand = new JButton("Obter Dados \n Candidatos");
        btnDadosCand.addActionListener(this::dadosCandidatosInterface);
        add(btnDadosCand);

        btnContVotos = new JButton("Votos dos candidatos");
        btnContVotos.addActionListener(this::contVotosInterface);
        add(btnContVotos);

        btnCadCand = new JButton("Cadastrar Candidato");
        btnCadCand.addActionListener(this:: cadCandInterface);
        add(btnCadCand);

        cadastrarEleitor = new JButton("Cadastrar Eleitor");
        cadastrarEleitor.addActionListener(this::cadEleitorInterface);
        add(cadastrarEleitor);

        btnExit = new JButton("Sair");
        btnExit.addActionListener(this :: sairPrograma);
        add(btnExit);

        colum2 = new JLabel("teste",JLabel.CENTER);
        colum2.setForeground(Color.blue);
        colum2.setFont(new Font("Serif",Font.BOLD,24));


        colum1 = new JLabel(justicaEleitoralImg,SwingConstants.CENTER);


        getContentPane().setLayout(new GridLayout(6,2));



    }


    public void votarInterface(ActionEvent btnVotar){
        String numTitulo = null;
        Integer numVotado = null;
        int prosseguir;

        do{
            numTitulo = JOptionPane.showInputDialog("Qual o numero do seu Titulo?");
            numVotado = Integer.parseInt(JOptionPane.showInputDialog("Qual o numero do seu candidato"));
            prosseguir = JOptionPane.showConfirmDialog(null, "Deseja votar no candidato com numero "+numVotado+"?","Atenção",JOptionPane.YES_NO_OPTION);
        }while(prosseguir != JOptionPane.YES_OPTION);
        try{
            sistema.votar(numTitulo,numVotado);
        }catch (TituloInexistenteException e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"ERRO",JOptionPane.WARNING_MESSAGE);
        }

    }

    public void dadosCandidatosInterface(ActionEvent btnDadosCand){

        try{
        JOptionPane.showMessageDialog(null,sistema.obterDadosDoCandidato(JOptionPane.showInputDialog(null,"qual o nome do candidato a ser consultado?")));
        }catch(CandidatoInexistenteException e){
            JOptionPane.showMessageDialog(null,e.getMessage(),"ERRO",JOptionPane.WARNING_MESSAGE);
        }


    }
    public void contVotosInterface(ActionEvent btnContVotos){
        int numCand = Integer.parseInt(JOptionPane.showInputDialog(null,"qual o numero do candidato que deseja contabilizar?"));
        int votos = sistema.contarVotosParaCandidato(numCand);

        if(votos == 1){
            JOptionPane.showMessageDialog(null,"Este candidato tem 1 voto.");
        }else{
            JOptionPane.showMessageDialog(null,"Este candidato tem "+votos+" votos.");
        }

    }
    public void cadCandInterface(ActionEvent btnCadCand ){

        String nomeCand;
        int numCand;
        Partido partido = null;
        boolean confirmacaoCad;


        nomeCand = JOptionPane.showInputDialog(null,"qual o nome do seu candidato?");
        numCand = Integer.parseInt(JOptionPane.showInputDialog(null,"qual o numero do seu candidato?"));

        Partido[] options = {Partido.PARTIDO1, Partido.PARTIDO2};// podemos adicionar novos partidos aqui

        Object partidoEscolha  = JOptionPane.showInputDialog(null, null, "Choose a sort type ",
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        for (Partido escolha:options){
            if(escolha.equals(partidoEscolha)){
               partido = escolha;
            }
        }

        confirmacaoCad = sistema.cadastraCandidato(nomeCand,numCand,partido);
        if(confirmacaoCad){
            JOptionPane.showMessageDialog(null,"Cadastro realizado com sucesso");
        }else{
            JOptionPane.showMessageDialog(null,"Cadastro não realizado, Candidatro já cadastrado no sistema");
        }

    }
    public void cadEleitorInterface(ActionEvent btnCadEleitor){
        String nomeEleitor;
        String numTitulo;
        boolean confirmCad;
        nomeEleitor = JOptionPane.showInputDialog(null,"qual o nome do Eleitor?");
        numTitulo = JOptionPane.showInputDialog(null,"qual o numero do titulo do Eleitor?");

        confirmCad = sistema.cadastraEleitor(nomeEleitor,numTitulo);

        if(confirmCad){
            JOptionPane.showMessageDialog(null,"cadastro realizado com sucesso!");
        }else{
            JOptionPane.showMessageDialog(null,"cadastro não realizado, este eleitor já foi cadastrado");
        }
    }

    public void sairPrograma(ActionEvent btnExit) {
        int escolha = JOptionPane.showConfirmDialog(null,"tem certeza que quer sair?","Sair do Programa",JOptionPane.YES_NO_OPTION);
        if(escolha == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }


}
