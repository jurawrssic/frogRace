/**
 * @author Julia
 * @version 1.1
 */

package corrida.de.sapos;

/**
 * Esta classe ao ser chamada no final da corrida faz o cálculo do Ranking e o imprime logo depois automaticamente.
 */
public class Ranking {
    private static Ranking[] rank = new Ranking[5];
    private static Ranking[] aux;
    private static int ind = 0;
    private long tmp;
    private String nome;
    
    /**
     * Este construtor inicializa as variáveis de perfomance que associadas a um jogador constroem um ranking de menor tempo pra maior;
     * @param nome é uma string que recebe o nome do sapo
     * @param tmp é um long com o tempo que ele levou para terminar a corrida.
     */
    public Ranking(String nome, long tmp){
      this.nome = nome;
      this.tmp = tmp;
    }
    
    /**
     * Este método o retorna um número long correspondente ao tempo de corrida de um Sapo
     * @return tmp variável com o tempo de corrida
     */
    public long getTmp(){
        return tmp;
    }
    
    /**
     * Este método retorna o nome do sapo correspondente
     * @return nome do sapo em String
     */
    public String getNome(){
        return nome;
    }
   
    /**
     * Este método utiliza um vetor static de tipo Ranking para guardar nome do sapo participante e seu tempo de corrida, 
     * quando o vetor possuir 5 sapos cadastrados, o mesmo é e ordenado utilizando o método de ordenação bubble sort de maneira crescente 
     * para que assim cada indice do vetor i+1 corresponda à colocação do sapo.
     * @param nome nome do sapo em String
     * @param tempoEx tempo de corrida do sapo correspondente
     */
    public static void calculaRank(String nome, long tempoEx){
        Ranking r1 = new Ranking(nome, tempoEx);
        rank[ind] = r1;
        if (ind == 4){
            bubbleSort(rank);
            System.out.println(' ');
            for(int i=0; i<rank.length; i++){
                System.out.println("O sapo " + rank[i].getNome() + " ficou em " + (i+1) + "ª colocao com " + rank[i].getTmp() + " segundos.");
            }
        }
        ind++;       
    }
    
    /**
     * Método de ordenação bubbleSort recebe o vetor de Rank e o ordena de maneira crescente
     * @param rank vetor com informações dos sapos participantes
     */       
    public static void bubbleSort(Ranking[] rank) { 
        for(int i=0; i<5; i++){
            for(int j = 0; j<4; j++){
                long tempo = (long) rank[j].getTmp();
                long tempo2 = (long) rank[j+1].getTmp();            
                if(tempo > tempo2){
                    aux[0] = rank[j];
                    rank[j] = rank[j+1];
                    rank[j+1] = aux[0];
                }
            }
        }
    }
}

