package simplon.lucas;
import java.util.*;
import java.io.*;


class Pendu{
	
	public static int NB_ERREURS_MAX=10;
	public static void main (String args[]){
		
		
		int i;
		
		String tabMots[] = {"ablation","hypocrisie","interminable","revolution","erudit","feudiste","accueil","explosion","reliure","niais","petit","piquet","blond","punk"};
		
		Random rand=new Random();
				
		int nbAleatoire=rand.nextInt(tabMots.length); 
		
		String motADeviner=tabMots[nbAleatoire];
		
		int longueurMotAChercher=motADeviner.length(); 
				
		char tabMotAChercher[]; 
		
		tabMotAChercher=new char [longueurMotAChercher];
		
		char lettreSaisie; 
		
		boolean motTrouve=false; 
		
		int nbLettresBonnes=0; 
		
		boolean bonneLettre=false; 
		
		int erreur=0; /
		
		boolean identique=false; 
		
		String continuer=""; 
		
		int k=0;
		
		boolean difference;
		
		boolean identique2=false; 
		
		char verifSaisie[];
		
		verifSaisie=new char [NB_ERREURS_MAX];	
		System.out.print("Voici le mot a trouver: ");
		
		
		for (i=0;i<tabMotAChercher.length;i++){
			
			if (i==0){ 
				
				tabMotAChercher[i]=motADeviner.charAt(i);
			}
			
			else if (i==tabMotAChercher.length-1){ 
				
				tabMotAChercher[i]=motADeviner.charAt(i);
				
				
			}
			else{
			
				tabMotAChercher[i]='-'; 
			}
			
			System.out.print(tabMotAChercher[i]); 
		}
		
		System.out.println("-----------------------------------");
		do{
			nbLettresBonnes=0;
			
			bonneLettre=false; 
				do{ 		
					if ((identique!=false) || (identique2!=false)){		
						System.out.println("");
						System.out.println("-------------------------------------");
						System.out.println("");
						System.out.print("RAPPEL: le mot a chercher est: ");
						
					
						for (i=0;i<tabMotAChercher.length;i++){
						
							System.out.print(tabMotAChercher[i]);
							
					
						}
					
						System.out.println("");
						System.out.println("");
					
					}
							
					lettreSaisie=Console.readLine("Quelle lettre desirez vous entrer? ").toLowerCase().charAt(0);  
					
					difference=true; 
					
					identique=false;
					identique2=false;
					
					for (i=0;i<NB_ERREURS_MAX;i++){ 
					
						if (verifSaisie[i]==lettreSaisie){
							
							identique2=true;
						}
					}
					
					
						
						for (i=1;i<tabMotAChercher.length-1;i++){
						
							if ((lettreSaisie==motADeviner.charAt(i)) || (identique2==true)){
								
								difference=false;
								
							}
						}
								
						
											
						if (difference==true){
								
							
							verifSaisie[k]=lettreSaisie;
							
							k=k+1;
									
						}
	
					
					for (i=1;i<tabMotAChercher.length-1;i++){
					
						if (lettreSaisie==tabMotAChercher[i]){
						
							identique=true;
						}
					
					}
						
					
				}	
			
			while((identique!=false) || (identique2!=false));
			
				
			System.out.println("");				
			for (i=1;i<tabMotAChercher.length-1;i++){
				
				
				if (lettreSaisie==motADeviner.charAt(i)){
					
										
					tabMotAChercher[i]=lettreSaisie;
					
					bonneLettre=true;
				}
				
					
			}
			
			if (bonneLettre!=true){
					
				erreur=erreur+1;
				System.out.println("");
			}
			
			
			if (erreur!=NB_ERREURS_MAX){
		
						
				for (i=1;i<tabMotAChercher.length-1;i++){
					
					
					
					if (tabMotAChercher[i]==motADeviner.charAt(i)){ 
						
						nbLettresBonnes=nbLettresBonnes+1;
						
						
					}	
				
					if (nbLettresBonnes==motADeviner.length()-2){ 
						
						motTrouve=true;
						
						System.out.println("Vous avez trouvez le mot feliciations!");
						System.out.println("");
						System.out.println("Le mot etait: "+motADeviner);
						
						
					}
				
				}
			
			
				
				if (motTrouve!=true){
				
				
					System.out.println("Vous avez trouve en tout "+nbLettresBonnes+" lettres."); 
					System.out.println("");
					System.out.print("Maintenant le mot devient: ");
					
					for (i=0;i<tabMotAChercher.length;i++){
						
					System.out.print(tabMotAChercher[i]); 
							
					
					}
					
					System.out.println("");
					System.out.println("");
				
				}
				System.out.println("-----------------------------------");
			}
		}
		
		while ((motTrouve==false) && (erreur!=NB_ERREURS_MAX))	;
		
		if (erreur==NB_ERREURS_MAX){ 
			System.out.println("-----------------------------------");
			System.out.println("Fin de partie vous avez perdu!");
			System.out.println("");
			System.out.println("Le mot etait: "+motADeviner);
		
		}
	}
}