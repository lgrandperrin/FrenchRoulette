//Cynthia Maillard et Loic Grandperrin
public class Roulette{
	public static void main (String [] args){
			    
//Declaration des variables
int capitalJoueur=100;
int miseJetons;
int typeMise;
int numeroMise=0;
char PIMise='A';
char MPMise='A';
int numeroTire;
char PITire='A';
char MPTire='A';
char couleurMise='A';
int MenuCouleur;
String couleurTire="";
char continuer='n';
int i=0;
String PIAffiche="";
String MPAffiche="";

//Debut du jeu
Ecran.afficher("Bienvenue dans le jeu de la roulette francaise !");

//Boucle
do{
//Choix du nombre de jetons mises.
Ecran.afficher("\n \nVotre capital actuel est de ", capitalJoueur, " jetons\n");
Ecran.afficher("Faites vos jeux.\nMise :");
miseJetons = Clavier.saisirInt();

//Verification mise correct
			while(miseJetons<1||miseJetons>capitalJoueur){
				Ecran.afficher("Mise incorrecte: Verifier que votre capital de jetons est suffisant pour cette mise.\nMise:");
				miseJetons = Clavier.saisirInt();
			}
			//capital du joueur apres mise
			capitalJoueur = capitalJoueur - miseJetons;
			Ecran.afficherln("Vous avez misez ", miseJetons, " jetons, il vous reste ", capitalJoueur, " jetons !\n");
							  
			//Choix du type de mise.
			Ecran.afficher("Quel type de mise voulez-vous effectuer ? Taper le numero correspondant:\n   1 : Miser sur un numero\nChances simples :\n   2 : Pair ou Impair\n   3 : Manque ou Passe\n   4 : Couleur\nChoix :");
			typeMise = Clavier.saisirInt();

			switch (typeMise){
				case 1 : {        //Mise sur un numero.
					Ecran.afficher("\nSur quel numero voulez-vous miser (numero inclu entre 0 et 36) ?\nNumero :");
					numeroMise = Clavier.saisirInt();
				}
				break;
				case 2 : {        //Mise paire ou impaire.
					Ecran.afficher("\nChoisissez de miser sur un nombre pair ou impair : \n   P : Pair \n   I : Impair\nChoix :");
					PIMise = Clavier.saisirChar();
				}
				break;
				case 3 : {        //Mise Manque ou Passe
					Ecran.afficher("\nChoisissez de miser sur un manque ou Passe : \n   M : Manque (entre 0 et 18 inclus) \n   P : Passe (entre 19 et 36 inclus)\nChoix :");
					MPMise = Clavier.saisirChar();
				}
				break;
				case 4 : {		//Mise couleur
					Ecran.afficher("\nChoisissez de miser sur une couleur : \n  R : Rouge \n  N : Noir\nChoix :");
					couleurMise = Clavier.saisirChar();
				}
			}

			//Tirage du numero
			Ecran.afficherln("\nRien ne va plus!");
			numeroTire = (int)(Math.random()*37);
			      
			//Affichage en ligne du numero tire (entre etoiles)
			for(i=0; i<numeroTire; i=i+1){
				Ecran.afficher(i, " ");
			}
			
			Ecran.afficher("*", numeroTire, "* ");
			
			for(i=numeroTire+1; i<=36; i=i+1){
				Ecran.afficher(i, " ");
			}

			//Numero tire : Pair ou Impair ? 
			if(numeroTire !=0 && numeroTire%2==0){
				PITire='P';
				PIAffiche=" Pair et ";
			}
			else 
				if(numeroTire !=0 && numeroTire%2!=0){
					PITire='I';
					PIAffiche=" Impair et ";
				}
				else{
					PIAffiche="";
				}  
				
			//Numero tire : Manque ou Passe ou 0 ?
			if(numeroTire>0 && numeroTire<19){
				MPTire='M';
				MPAffiche="Manque";
			}
			else {
				if(numeroTire>=19){
					MPTire='P';
					MPAffiche="Passe";
				}
				else{
					MPAffiche="";
				}
			}
			
			//Numero tire : Rouge ou noir ?
			if(numeroTire>=1 && numeroTire<=10){
				MenuCouleur=1;
			}
			else{
				if(numeroTire>=11 && numeroTire<=18){
				MenuCouleur=2;
				}
				else{
					if(numeroTire>=19){
						MenuCouleur=3;
					}
					else{
						MenuCouleur=4;
					}
				}
			}
			
			switch(MenuCouleur){
				case 1 : {
					if(numeroTire%2==0){
						couleurTire=" Noir";
					}
					else {
						couleurTire=" Rouge";
					}
				}
				break;
				case 2 : {
					if(numeroTire%2==0){
						couleurTire=" Rouge";
					}
					else {
						couleurTire=" Noir";
					}
				}
				break;
				case 3 : {
					if(numeroTire%2==0){
						couleurTire=" Noir";
					}
					else{
						couleurTire=" Rouge";
					}
				}
				break;
				case 4 : {
					couleurTire="";
				}
			}	  
			      
			//Affichage numero, couleur, paire/impaire, manque/passe	
			Ecran.afficherln("\n\nLes jeux sont faits !");
			Ecran.afficher(numeroTire, couleurTire, PIAffiche, MPAffiche);
			      
			//Calcul du gain suivant mise effectuee
			switch(typeMise){
				case 1 : {		//Mise sur un numero
					if(numeroMise==0 && numeroMise==numeroTire){
						miseJetons=miseJetons*36;
						capitalJoueur=capitalJoueur+miseJetons;
						Ecran.afficher("\nVous gagnez 36 fois votre mise.\n");
					}
					else {
						if(numeroMise!=0 && numeroMise==numeroTire){
							miseJetons=miseJetons*35;
							capitalJoueur=capitalJoueur+miseJetons;
							Ecran.afficher("\nVous gagnez 35 fois votre mise.\n");
						}
						else{
							Ecran.afficher("\nVous avez perdu votre mise.\n");
						}
					}
				}
				break;
				case 2 : {		//Mise sur Paire ou Impaire
					if(PITire==0 && PITire==PIMise){
						capitalJoueur=capitalJoueur+miseJetons;
						Ecran.afficher("\nVous recuperez votre mise.\n");
					}
					else {
						if(PITire!=0 && PIMise==PITire){
							miseJetons=miseJetons*2;
							capitalJoueur=capitalJoueur+miseJetons;
							Ecran.afficher("\nVous gagnez 2 fois votre mise.");
						}
						else{
							Ecran.afficher("\nVous avez perdu votre mise.");	
						}
					}
				}
				break;
				case 3 : {		//Mise sur Manque ou Passe
					if(MPTire==0 && MPTire==MPMise){
						capitalJoueur=capitalJoueur+miseJetons;
						Ecran.afficher("\nVous recuperez votre mise.\n");
					}
					else { 
						if(MPTire!=0 && MPMise==MPTire){
							miseJetons=miseJetons*2;
							capitalJoueur=capitalJoueur+miseJetons;
							Ecran.afficher("\nVous gagnez 2 fois votre mise.\n");
						}
						else{
							Ecran.afficher("\nVous avez perdu votre mise.");
						}
					}
				}
                                break;
				case 4 : {	//Mise sur une couleur
					if(couleurTire==" Rouge" && couleurMise=='R'){
						miseJetons = miseJetons*2;
						capitalJoueur = capitalJoueur + miseJetons;
						Ecran.afficher("\nVous gagnez 2 fois votre mise.\n");
					}
					else {
						if(couleurTire==" Noir" && couleurMise=='N'){
							miseJetons = miseJetons*2;
							capitalJoueur = capitalJoueur + miseJetons;
							Ecran.afficher("\nVous gagnez 2 fois votre mise.\n");
						}
						else {
							Ecran.afficher("\nVous avez perdu votre mise.");
						}
					}
				}	
			}

			//Rejouer ?
			if(capitalJoueur>0){
				Ecran.afficherln("\n\nVoulez-vous recommencer ? O/N");
				continuer = Clavier.saisirChar();
			}
			else{
				continuer = 'n' ;
				Ecran.afficher("\nVous n'avez plus de jetons\n");
			}
                      
		}while(continuer=='O' || continuer=='o' );
		Ecran.afficher("\nFin de partie\n");
	}
}
