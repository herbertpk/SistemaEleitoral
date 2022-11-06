package sistemaEleitoral;
import java.util.*;


public class SistemaEleitoralMap implements SistemaEleitoralInterface {

    private Map<String, Eleitor> eleitores;
    private Map<String, Candidato> candidatos;
    private List<Voto> votos;

    public SistemaEleitoralMap() {
        this.eleitores = new HashMap<>();
        this.candidatos = new HashMap<>();
        this.votos = new ArrayList<>();
    }

    @Override
    public Candidato obterDadosDoCandidato(String nome) throws CandidatoInexistenteException {
        Candidato candidato = this.candidatos.get(nome);
        if (candidatos.containsKey(nome)) {
            return candidato;
        } else {
            throw new CandidatoInexistenteException("Não existe candidato com o nome " + nome);
        }
    }
    public void votar(String numTitulo, int numeroVotado) throws TituloInexistenteException{
        if(eleitores.containsKey(numTitulo)){
            Voto temp = new Voto(numeroVotado);
            votos.add(temp);
        }else{
            throw new TituloInexistenteException("Não existe nenhum titulo com o numero "+ numTitulo);
        }
    }
    public int contarVotosParaCandidato(int numero){
        int numVotados = 0;
        for (Voto voto: votos){
            if(numero == voto.getNumeroVotado()){
               numVotados++;
            }
        }
        return numVotados;
    }
    public boolean cadastraCandidato(String nome, int numero, Partido partido){
        if(candidatos.containsKey(nome)){
            return false;
        }else {
            Candidato temp = new Candidato(nome, numero, partido);
            candidatos.put(nome, temp);
            return true;
        }
    }
    public boolean cadastraEleitor(String nome, String titulo) {
        if (eleitores.containsKey(titulo)) {
            return false;
        } else {
            Eleitor temp = new Eleitor(nome, titulo);
            eleitores.put(titulo, temp);
            return true;
        }
    }
}

