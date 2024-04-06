/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gerenciabanco;

// importa java util para utilizar o scanner

import java.util.Scanner;

/**
 *
 * @author Marcio
 */



//inicia a classe GerenciaBanco
public class GerenciaBanco {
     //inicia o programa
    public static void main(String[] args) {        
      
       ClassePrograma cp = new ClassePrograma(); //cria um novo objeto instanciando a classe ClassePrograma
       cp.dadosPessoais(); // chama a classe interna dadospessoais
       cp.movimentaConta(); //chama a classe interna movimenta conta

    }
}
        
       
class ClassePrograma {

    //determina que o objeto scan receberá os atributos de scanner
    Scanner scan = new Scanner(System.in);
    // declara variáveis
    private double deposito, saque, saldo; //falta ajustar para 2 casas decimais
    private String nome, sobrenome, cpf;
    
    public void movimentaConta(){
    
       //menu onde o usuário decide com opção de sair
       System.out.println(nome + "escolha UMA das seguintes opções");
       System.out.println("Digite 1 para DEPÓSITO, 2 para SAQUE, 3 para SALDO e 9 para SAIR");
       System.out.print("=> ");
       int respostaUsuario = scan.nextInt();
        
        /*decisao com switch case chamando função externa para cálculo e guardar valor nas variáveis
          pois o switch case não pode exercer esses comandos*/
        switch(respostaUsuario){
          case 1:
              deposito(); //chama deposito
              movimentaConta(); //retorna ao inicio
              break;
          case 2:
               saque(); // chama saque
               movimentaConta(); //retorna ao inicio
               break;
          case 3:
               saldo(); //chama saldo
               movimentaConta(); //retorna ao inicio
               break;
          case 9:
              System.out.println("\nTodos os procedimentos realizados com sucesso");
              System.out.println(nome + ", obrigado por utilizar nosso sistema\n");
               System.exit(0); //encerra sistema
               break;
          default: //se utilizar qualquer outro tipo de tecla e não as do menu informa e retorna ** não foi tratado erro
               System.out.println("ATENÇÃO!!");
               System.out.println("Opção errada");
               System.out.println("Você deve escolher entre as opções 1 / 2 / 3 ou 9");
               movimentaConta();
                
        }
    }
    
    public void dadosPessoais() {        
              
        System.out.print("Digite seu nome: "); //pega nome
        this.nome = scan.nextLine();
        System.out.print("Digite seu sobrenome: "); //pega sobrenome
        this.sobrenome = scan.nextLine();
        System.out.print("Digite seu CPF para identificação: "); //pega cpf
        this.cpf = scan.next();
        System.out.println("\nSeja bem vindo " + nome + " " + sobrenome + "\n" ); //mensagem de boas vindas **não foi tratado erro
        
    }    
       
    public void deposito() { //pega o valor de deposito informado soma ao saldo e da informações
        
    System.out.print("Qual valor será depositado: ");
    double deposito = scan.nextDouble();
    saldo = saldo + deposito;
        System.out.println("\nValor depositado " + deposito + " seu saldo atual é: " + saldo + "\n");
    }
    
    public void saque() { //pega o valor de saque informado diminiu do saldo e da informações
        
        System.out.print("Qual valor será sacado: ");
        double saque = scan.nextDouble();
        saldo = saldo - saque;
        System.out.println("\nValor sacado " + saque + " seu saldo atual é: " + saldo +"\n");
    }
    
    public void saldo() { //mensagem ao usuário e mostra saldo **fazar array para mostrar toda a movimentação numa lista
        
        System.out.println("\nPrezado: " + nome + " " + sobrenome);
        System.out.println("CPF de identificação: " + cpf);
        System.out.println("Seu Saldo é: " + saldo + "\n"); // + nome + "seu saldo atual é: " + saldo);
        
    }
    
}