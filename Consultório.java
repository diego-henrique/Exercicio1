/***
 * IFPB - PROGRAMAÇÃO ORIENTADA A OBJETO
 * @author Diego
 */
package Teste;

import java.util.Scanner;

public class Consultório {
	/***
	 * Método principal
	 */
	public static void main(String[] args) {
	
		int cont=0,fim=100,num=0, terminar=0,escolha=0;
		String[] paciente = new String[100];
		String[] sexo = new String[100];
		int[] idade = new int[100];
		double[] valorconsulta = new double[100];
		Scanner in=new Scanner(System.in);
		Scanner input=new Scanner(System.in);
		Scanner ler=new Scanner(System.in);
		Scanner esc=new Scanner(System.in);

do{
	
	System.out.printf("\t \n ========== CONSULTÓRIO MÉDICO ========== ");
	paciente[cont]= Nomefunc(input);
	idade[cont] = IdadeFunc(input);
	sexo[cont] = SexoFunc(input, paciente[cont]);
	valorconsulta[cont] = Valordaconsulta(input, paciente[cont]);
	cont ++;
	
	
	System.out.printf("\t \n ========== DESEJA CONTINUAR CADASTRANDO PACIENTE ===> [ SIM 1 ] [NÃO 2] : ");
		while(!ler.hasNextInt()){		
			ler.nextLine();
			System.out.printf("\t \n INFORME DE FORMAR NÚMERICA =============>  SIM [ 1 ] NÃO [ 2 ] : ");
		}
		num = ler.nextInt();
}while(cont < fim &&  num != 2);

do{
	System.out.printf("\t \n ========== CONSULTÓRIO MÉDICO ========== \n "); 
	System.out.printf("\t 1 – Imprimir na tela os dados armazenados \n");
	System.out.printf("\t 2 – Imprimir a média do valor das consultas realizadas.\n");
	System.out.printf("\t 3 – Imprimir os dados das pessoas do sexo masculino\n");
	System.out.printf("\t 4 – Imprimir o maior valor de consulta realizado por uma pessoa do sexo feminino.\n");
	System.out.printf("\t 5 – FIM DO PROGRAMA \n");

	System.out.printf("\t \n ====== INFORME UMA DAS OPÇÕES ACIMA =======> : ");
	
	while(!esc.hasNextInt()){		
		esc.nextLine();
		System.out.printf("\t \n ====== INFORME UMA DAS OPÇÕES ACIMA =======> : ");
	}
	escolha = esc.nextInt();
	
		switch(escolha){
		case 1:
			Exibe(cont,paciente, sexo, idade, valorconsulta); 
			break;
		case 2:
			MediaFunc(cont,valorconsulta);
			break;
		case 3:
			FuncSexoMas(cont, paciente, sexo, idade, valorconsulta);
			break;
		case 4:
			FuncSexoFem(cont, paciente, sexo, valorconsulta);
			break;
		case 5:
			System.out.printf("\t \n TEM CERTEZA QUE QUER ENCERRAR O PROGRAMA  ===> [ SIM: 5 ] <=== : ");
			
			while(!in.hasNextInt()){		
				in.nextLine();
				System.out.printf("\t \n PARA ENCERRAR DIGITE NOVAMENTE ===>  SIM [ 5 ] <=== : ");
				System.out.printf("\t \n PARA VOLTAR AO MENU DIGITE QUALQUER NÚMERO ===> [ 6 ] [ 7 ]... <=== : ");
			}
			terminar = in.nextInt();			
			break;
			
			default:
				System.out.printf("\t \n ========== CONSULTÓRIO MÉDICO ========== \n "); 
				System.out.printf("\t 1 – Imprimir na tela os dados armazenados \n");
				System.out.printf("\t 2 – Imprimir a média do valor das consultas realizadas.\n");
				System.out.printf("\t 3 – Imprimir os dados das pessoas do sexo masculino\n");
				System.out.printf("\t 4 – Imprimir o maior valor de consulta realizado por uma pessoa do sexo feminino.\n");
				System.out.printf("\t 5 – FIM DO PROGRAMA \n");

				System.out.printf("\t \n ====== INFORME UMA DAS OPÇÕES ACIMA =======> : ");
		}

	}while(terminar != 5);

in.close(); //FECHANDO OS SCANNER
ler.close(); //FECHANDO OS SCANNER
esc.close(); //FECHANDO OS SCANNER

	}//final do main
	/**
	 *  *FUNÇÃO CADASTROS DOS NOMES DOS PACIENTES
	 * @param input
	 * @return 
	 */
private static String Nomefunc(Scanner input) {
	String nome;
do{
	System.out.printf("\n\t INFORME NOME DO PACIENTE: ");
	nome = input.nextLine();

	while(nome.length()<4){
	 System.out.printf("\t NOME MUITO PEQUENO [ %s ]  !!",nome);
	 System.out.printf("\t\n INFORME NOME DO PACIENTE: "); 
	 nome = input.nextLine();
	}
	
}while(nome.length()<4);
	return nome;	
}
	/***
	 * 	 * FUNÇÃO CADASTROS DAS IDADES DOS PACIENTES
	 * @param input
	 * @return
	 */
private static int IdadeFunc(Scanner input){
		int idade=0;
	  	 System.out.printf("\t INFORME A IDADE DO PACIENTE: ");
		 while(!input.hasNextInt()){
			 input.nextLine();
		  	  System.out.printf("\t INFORME A IDADE DE FORMA NUMÉRICA !!");
		  	  System.out.printf("\t\n INFORME A IDADE DO PACIENTE NOVAMENTE: ");
		 }
		 idade=input.nextInt();
		 input.nextLine();
		return idade;
	}
/***
 * 	 * FUNÇÃO CADASTROS SEXO DOS CLIENTES
 * @param input
 * @param paciente
 * @return
 */
private static String SexoFunc(Scanner input, String paciente){
String sexo;
	System.out.printf("\t INFORME O SEXO DO Sr(a) %s: ",paciente);	     

String m="MASCULINO";
String f="FEMININO";

   sexo = input.nextLine();
   String s=sexo.toUpperCase(); 
    
   		while(!s.equals(f) && !s.equals(m)){	        	 
 		  System.out.printf("\t\n Sexo Inválido ===> %s \n ",s);
 		  System.out.println("\t\n INFORME Sexo Novamente:  ");
          s=input.nextLine();
          s = s.toUpperCase();
   		}
   	sexo= s; 
   	return sexo;
	}
/***
 * 	 * FUNÇÃO CADASTROS VALORES DAS CONSULTAS DOS PACIENTES
 * @param input
 * @param paciente
 * @return
 */
private static double Valordaconsulta(Scanner input, String paciente){
	
	System.out.printf("\t INFORME O VALOR DA CONSULTA DO  Sr(a) %s : ", paciente);
    while(!input.hasNextDouble()){
  	  input.nextLine();
        System.out.println("\t Tipo inválido !!! => digite um NÚMERO REAL EXE.:  10,9 ");
    	System.out.printf("\t INFORME O VALOR DA CONSULTA DO Sr(a) %s NOVAMENTE : ", paciente);
    }
   
    double valordaconsulta = input.nextDouble();
    input.nextLine();
	
	return valordaconsulta;
}
/***
 * * FUNÇÃO EXIBE TODOS OS CADASTROS DOS PACIENTES
 * @param i
 * @param paciente
 * @param sexo
 * @param idade
 * @param valorconsulta
 */
private static void Exibe(int i,String []paciente,String []sexo, int []idade,double []valorconsulta){
	
	for(int cont = 0;cont < i ; cont ++){
System.out.println("  \n  ------- FORMULÁRIO  -------  ");
System.out.printf("%dº Nome: %s | Sexo:  %s | Idade: %d | Valor da consulta: R$: %.2f \n",cont,paciente[cont],sexo[cont],idade[cont],valorconsulta[cont]);
System.out.println("    ------- ========== -------  ");
	}
}
/***
 * 	 * FUNÇÃO MÉDIA DOS VALORES DOS PACIENTES
 * @param i
 * @param valorconsulta
 */
private static void MediaFunc(int i, double[]valorconsulta){
	double soma=0 , media=0;
	for(int cont =0;cont < i;cont++){
		soma+=valorconsulta[cont];
		System.out.printf(" SOMA do for ===> R$: [ %.2f ] ",soma);
	}
	media=soma/i;
	 System.out.println("  \n  ------- MÉDIA DAS CONSULTA ------- \n ");
	System.out.printf(" = SOMA ===> R$: [ %.2f ] ",soma);
	System.out.printf("=== MÉDIA == DA == CONSULTA == > R$: [ %.2f ] \n",media);
}
/***
 * 	 * FUNÇÃO EXIBE AS INFORMAÇÕES DOS PACIENTES MASCULINOS
 * @param i
 * @param paciente
 * @param sexo
 * @param idade
 * @param valorconsulta
 */
 private static void FuncSexoMas(int i,String []paciente,String []sexo, int []idade,double []valorconsulta){
	 for(int cont = 0; cont < i;cont++){
		 if(sexo[cont].equals("MASCULINO")){
			 System.out.println("  \n  ------- FORMULÁRIO PACIENTES MASCULINOS  ------- \n ");
			 System.out.printf("%dº Nome: %s | Sexo:  %s | Idade: %d | Valor da consulta: R$:  %.2f \n",cont,paciente[cont],sexo[cont],idade[cont],valorconsulta[cont]);
			 System.out.println("    --------- ===============================  -------  "); 
		 }
	}
}
/***
 * FUNÇÃO EXIBE O VALOR DA MAIOR CONSULTA DOS PACIENTES DO SEXO [ FEMININO ] 
 * @param i
 * @param paciente
 * @param sexo
 * @param valorconsulta
 */
 private static void FuncSexoFem(int i,String []paciente,String []sexo,double []valorconsulta){
	  double MAX =0;
	  String nome = null;
	 for(int cont = 0 ; cont < i ; cont++){
		 if(sexo[cont].equals("FEMININO")){
			if(valorconsulta[cont] > MAX){
			 MAX = valorconsulta[cont];	
			 nome=paciente[cont];
			}
		}	  
	 }
System.out.println("  \n  ------- MAIOR VALOR DE UMA CONSULTA FEMININA  ------- \n ");
System.out.printf("=== NOME: %s MAIOR VALOR DA CONSULTA DO SEXO FEMININO === > R$:  [ %.2f ] ",nome,MAX);
System.out.println("    --------- ===============================  ------- \n "); 
 }
 
}//final da classe
