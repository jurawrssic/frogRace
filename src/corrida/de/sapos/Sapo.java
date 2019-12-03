/**
 * @author Julia
 * @version 1.1
 */

package corrida.de.sapos;
import java.util.Random;

/**
 * Essa classe representa um sapo, cadastrando seu nome e iniciando uma thread sempre que um objeto seu é criado.
 */
public class Sapo implements Runnable{
    private String nome;
    Thread thrd;
    Random rand = new Random();
    
    /**
     * Este construtor define o mesmo nome para o objeto sapo e sua thread também a iniciando
     * @param nome do sapo participante
     */
    public Sapo(String nome){
        this.nome = nome;
        thrd = new Thread(this, nome);
        thrd.start();
    }
    
    /**
     * Este método retorna o nome do sapo correspondente
     * @return nome do sapo
     */
    public String getNome(){
        return nome;
    }
    
    /**
     * Método run que é executado quando uma thread é inciada, synchronized para que apenas uma thread tenha acesso por vez
     * Nesse caso assim que um sapo está criado ele está na corrida onde seu pulo em metros é de 0 a 50 e a soneca logo apos o pulo é de 0 a 500,
     * cada tem seu tempo de execução que é monitorada por tempo de execução e qual sapo pular 400 metros primeiro tem seu tempo e nome cadastrados.
     */
    @Override
    public synchronized void run(){
        int pulo, soneca, distancia = 0, chegada = 400;
        long tempoInicial = System.currentTimeMillis();
        
        while (distancia < chegada){            
            pulo = rand.nextInt(50);
            soneca = rand.nextInt(500);
            distancia += pulo;
            System.out.println("O sapo " + thrd.getName() + " pulou " + pulo + " metros.");
            try{
                thrd.sleep(soneca);
            }catch(InterruptedException exc){
                System.out.println(thrd.getName() + " interrompida.");
            }
        }
        
        long tempoFinal = System.currentTimeMillis();
        long totalTempo = tempoFinal - tempoInicial;        
        Ranking.calculaRank(thrd.getName(), totalTempo);
        
        notifyAll();
    }
}