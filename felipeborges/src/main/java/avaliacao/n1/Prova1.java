/*
 * Copyright (C) 2024 Felipe Borges Carvalho<felipeborgesmelo80@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package avaliacao.n1;

import java.util.Scanner;

/**
 *
 * @author Felipe Borges Carvalho<felipeborgesmelo80@gmail.com>
 * @date 08/03/2024
 * @brief Class Prova1
 */
public class Prova1 {
    public static void main(String[] args) {
    // Aqui sao todas variaveis do tipo inteiro
    int opcao = 0, qde_cafes_vendidos=0, qde_prod = 3;
    // Aqui sao todas variaveis do tipo ponto flutuante
    double total=0,valor_cafes_vendidos = 0;
    boolean teste = true;
    String[] nome = new String[10];
    double[] valor = new double[10];
    int[] qde = new int[10];
    for(int i = 0; i < 10; i++){
        qde[i] = 0;
    }
    nome[0] = "café expresso";
    nome[1] = "café capuccino";
    nome[2] = "leite com café";
    valor[0] = 0.75;
    valor[1] = 1;
    valor[2] = 1.25;   
    //Metodo para o codigo poder ler o que o usuario escreve    
    Scanner sc = new Scanner(System.in);
    //inicio de um laço de repetição para perguntar o usuario qual a escolha de cafe
        do{
            System.out.println("Escolha qual operação deseja realizar: \n1 adicionar produto \n2 exclusao de produto\n3 compras");
            opcao = sc.nextInt();
            
            switch (opcao)
            {
                case 1 :
                    qde_prod++;
                    System.out.println("Adicionar produto \n Escreva o nome do produto");
                    nome[qde_prod-1] = sc.next();
                    System.out.println("Defina o valor para: "+nome[qde_prod-1]);
                    valor[qde_prod-1] = sc.nextDouble();
                    continue;
                case 2 :
                    System.out.println("escolha qual produto deseja escluir");
                    for(int i = 0; i < qde_prod ; i++){
                        System.out.println(i+" - "+nome[i]+"\n");
                    }
                    opcao = sc.nextInt();
                    if(opcao >= qde_prod){
                        System.out.println("Opcao invalida");
                    }else{
                        nome[opcao] = "excluido";
                        valor[opcao] = 0;
                    }
                continue;        
                case 3 :
                teste = false;
                break;
                default :
                    System.out.println("Opcao invalida");
            }}while(teste);
        teste = true;
        do {
        
            System.out.println("Forneça uma opção: \n1");
                for(int i = 0; i < qde_prod ; i++){
                    System.out.println(i+" - "+nome[i]+"\n");
                }
            System.out.println("11 - Para a soma ");
        opcao = sc.nextInt();
        
        if(opcao <= qde_prod){
            qde[opcao]++;
            
        }else if(opcao == 11){
            teste = false;
        }else{
            System.out.println("Opcao invalida");
        }
        
        } while (teste);
        //fim do laço
        
        //somas de todos os valores digitado pelo usuario
        for(int i = 0; i <= qde_prod; i++){
            total = 0;
            total = valor[i] * qde[i];
            //saida para o usuario
            System.out.println("Qde "+nome[i]+" valor "+total);
            //soma total de cafes vendidos e a quantidade
            valor_cafes_vendidos = valor_cafes_vendidos + total;
            qde_cafes_vendidos = qde_cafes_vendidos + qde[i];
        }
        //saida para o usuario
        System.out.println("Qde cafés vendidos: "+ qde_cafes_vendidos + " ­ valor cafés vendidos: "+valor_cafes_vendidos);
        System.out.println("Digite: \n1 para PAGAMENTO PARCIAL DA CONTA \n2 para PAGAMENTO TOTAL DA CONTA");
        opcao = sc.nextInt(); 
        
        if(opcao == 1){
            teste=true;
           do{
           System.out.println("digite o valor a ser pago");
           total = sc.nextDouble();
           valor_cafes_vendidos = valor_cafes_vendidos - total;
           if(valor_cafes_vendidos <= 0){
               teste = false;
                System.out.println("finalizando a compra"); 
           }else{
               System.out.println("valor a pagar esta maior que zero ");
           }
           } while(teste);
        }else if(opcao == 2){
           System.out.println("finalizando a compra"); 
        }else{
           System.out.println("Opcao invalida"); 
        }
        
    }
}


