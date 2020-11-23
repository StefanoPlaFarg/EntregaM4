/*
 * Nota: s'ha realitzat la fase 1, fase2 i fase 3 en un sol exercici
 * 
 * 
 */


import java.util.HashMap;
import java.util.Scanner; 
import java.util.ArrayList;
import java.util.InputMismatchException;

public class EntregaM4App {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Fase 1
		//final int BITLLET5=5,BITLLET10=10,BITLLET20=20,BITLLET50=50,BITLLET100=100,BITLLET200=200,BITLLET500=500;
	    HashMap<String,Integer> carta =new HashMap<String,Integer>(); //Utilitzem un HashMap en comptes de dos ArrayList
	    ArrayList<Integer> llistaTipusBitllets = new ArrayList<Integer> ();
	    
	    llistaTipusBitllets.add(500);
	    llistaTipusBitllets.add(200);
	    llistaTipusBitllets.add(100);
	    llistaTipusBitllets.add(50);
	    llistaTipusBitllets.add(20);
	    llistaTipusBitllets.add(10);
	    llistaTipusBitllets.add(5);
	    
	    
	    //Fase2
	    carta.put("sopa", 10);
	    carta.put("pasta", 15);
	    carta.put("amanida", 10);
	    carta.put("peix", 20);
	    carta.put("carn", 15);
	    carta.put("copavi", 5);
	    carta.put("macedonia", 5);
	    carta.put("gelat", 5);
	    carta.put("refresc", 5);
	    carta.put("aigua", 5);
	    carta.put("botellavi", 20);
	   
	    int preu=0;	    
	    ArrayList<String> comanda= new ArrayList<String>(); 
	    
	    System.out.println("Què vol menjar?");    
	    agafarComanda(comanda);
	        
	    //Fase3
	    //Comprobar producte 
	    //Si tots els productes estan a la llista, calcular el preu
	       
	    preu=comprobarLlistaPreu(carta,comanda);
	    System.out.println("El preu es: " + preu); 
	    calcularBitllets (llistaTipusBitllets,preu);
	    
	    
	}
	
	static public void agafarComanda(ArrayList<String> comanda) {
		/*
		 * Mètode que agafa la comanda de tots els plats
		 * 
		 */

		/*
		 * Replace " "->""
		 * 
		 * public static String removeSpace(String s) { String withoutspaces = ""; for
		 * (int i = 0; i < s.length(); i++) { if (s.charAt(i) != ' ') withoutspaces +=
		 * s.charAt(i);
		 * 
		 * } return withoutspaces;
		 * 
		 * }
		 * 
		 * boolean flag = true; while(flag) { s = s.replaceAll(" ", ""); if
		 * (!s.contains(" ")) flag = false; } return s;
		 * 
		 */

		int flag = 1;
		String input;
		Scanner myObj = new Scanner(System.in);
		while (flag != 0) {

			input = myObj.nextLine();
			input = input.replaceAll(" ", "");
			comanda.add(input.toLowerCase());
			input = "";
			System.out.println("Vol alguna cosa més?");
			input = myObj.nextLine();

			// Nota: es podria també tractar amb un InputMismatchException 

			if (input.equals("1")) {
				flag = 1;
			} else if (input.equals("0")) {
				flag = 0;
			} else {
				// Si no respon ni 1 ni 0 es suposa que no vol res més.
				flag = 0;
			}

		}

	}
	
	static public int comprobarLlistaPreu(HashMap<String, Integer> carta, ArrayList<String> comanda) throws NullPointerException {
		/*
		 * Metode que comproba si tots els plats ordenats a la comanda estan a la carta.
		 * En cas d'estar-hi, calcula el preu de la comanda i el retorna
		 * 
		 */
		int preu = 0;
		for (String plat : comanda) {
			try {

				preu += carta.get(plat);

			} catch (NullPointerException e) {

				System.out.println("El plat ordenat no està a la carta");	
				preu = 0;

			}
		}

		/*
		 * Aquesta seria la manera correcta de solucionar una excepcio de tipus NullPointerException:
		 * for (String plat:comanda) {
		 * 
		 * if (carta.get(plat)==null) {
		 * System.out.println("El plat ordenat no està a la carta"); //Fi de programa }
		 * 
		 * else { preu += carta.get(plat); } }
		 */
		return preu;
	}

	static public void calcularBitllets (ArrayList<Integer> llistaTipusBitllets,int preu ) {
		/*
		 * Metode que calcula els diferents bitllets a entragar per pagar la comanda. L'objectiu és minimitzar el nombre de bitllets a entregar.
		 */
		ArrayList<Integer> llistaBitlletsPagar = new ArrayList<Integer>() ; //Llista de bitllets per imprimir
		
		for (Integer bitllet:llistaTipusBitllets) {
									
			if ( preu>=bitllet.intValue())
			
            {
                //Obtenim la quantitat d'un tipus de bitllet i l'afegim a la llista de bitllets per imprimir
				int numBitllets =(int)(Math.floor(preu/bitllet));      
	            llistaBitlletsPagar.add(numBitllets);           
	           	            
                //Actualitzem l'import que ens queda de dividir
                preu=preu-(numBitllets*bitllet.intValue());
            }
			
			else {
				llistaBitlletsPagar.add(0);
				
				
			}
		
		 }
			
		System.out.println("Els bitlles necessaris per pagar i les quantitats pertinents són els següents:");
		System.out.println(llistaTipusBitllets);
		System.out.println(llistaBitlletsPagar);
			
		}
	    
	    
		
		
		
	}
	


