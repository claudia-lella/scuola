/*
 * Questo esercizio è stato eseguito all'interno del corso di Generation Italy 
 * con l'affiancamento di Accademia del Levante. Ogni diritto è riservato.
 * 
 * Esercizio scuola
 * 
 * 23_06_23
 * 
 * Traccia base:
 * Scrivere un programma di gestione di una scuola,
 * con incapsulamento dei dati, che permetta di stampare elenchi di studenti e docenti di una scuola,
 * utilizzando l'ereditarietà attraverso la superclasse Persona per raggruppare le caratteristiche
 * comuni alle sottoclassi Studente e Docente: nome, cognome, anno di nascita.
 * Gli studenti avranno l'esclusiva della classe, sezione frequentata e matricola, i docenti della materia insegnata.
 * 
 * L'anno di nascita dovrà essere sottoposto a un filtro che accetti docenti nati tra il 1963 e il 1993,
 * e studenti nati prima del 2017, con relativo messaggio di avviso sull'esito dell'inserimento;
 * il metodo di controllo dovrà di conseguenza essere abstract in superclasse.
 * La matricola dev'essere univoca di 6 caratteri (anche se inizia per 0) composta dalle ultime due cifre dell'anno di nascita,
 * da un numero progressivo di tre cifre e dalla sezione frequentata (per es.: 15088B per uno studente del 2015
 * iscritto in una sezione B, 88° come numero progressivo da 000 a 999).
 * 
 * La scuola accoglie studenti con bisogni educativi speciali (BES), per i quali è previsto un docente di sostegno.
 * Per tali studenti andrà prevista una classe Java StudenteBES che consenta di assegnargli il docente di sostegno.
 * Discorso analogo per i docenti di sostegno, per i quali andrà prevista una classe Java DocenteBES
 * che consenta di definire da 1 a 3 studenti BES assegnati a esso.
 * Entrambe le classi Java saranno gestite attraverso un'interfaccia Sostegno.
 * Gli abbinamenti andranno fatti previo semplice inserimento dei nomi,
 * senza collegare tra loro istanze di DocenteBES con istanze di StudenteBES.
 * 
 * Predisporre un menù da terminale per inserire la figura scolastica desiderata tra le categorie previste,
 * nonché la possibilità di stampare gli elenchi di tutti gli studenti e/oppure di tutti i docenti su richiesta.
 * 
 * Traccia avanzata:
 * La scuola prevede un percorso pomeridiano facoltativo dedicato a discipline extrascolastiche
 * (per es.: teatro, musica, fotografia, sport, …); per gli studenti iscritti a uno o più di tali percorsi
 * vanno aggiunti campo e metodi che, a differenza degli altri studenti, consenta di registrare tali iscrizioni.
 * 
 * Gli studenti BES fanno comunque parte di una normale classe della scuola, così come i docenti BES sono accreditati di una materia insegnata.
 */

import java.util.Scanner;
import java.util.ArrayList;


public class Scuola {
    
    /* ---------- CAMPI ---------- */
    ArrayList<Studente> Studenti = new ArrayList<Studente>();
    ArrayList<Docente> Docenti = new ArrayList<Docente>();
    ArrayList<StudenteBES> StudentiBES = new ArrayList<StudenteBES>();
    ArrayList<DocenteBES> DocentiBES = new ArrayList<DocenteBES>();

    String[] materie = {"Matematica", "Italiano", "Geografia", "Inglese", "Scienze", "Storia", "Ed. fisica"};

    Scanner testo = new Scanner(System.in);
    Scanner numero = new Scanner(System.in);
    int selezione;

    int annoIscrizione;
    int codice;
    String codiceTotale;

    String no;
    String cogno;
    int annoDiNasci;
    String matrico;
    char sezio;
    int clas;
    int mater;

    int contatore;
    int posizione;

    String docenteSosteg;

    public void esegui() {

        boolean again = true;

        do {

            System.out.println("Benvenuti nel programma gestionale della scuola. Di seguito le istruzioni: ");
            System.out.println("1. Per aggiungere un nuovo studente 2. Per aggiungere un nuovo docente 3. Per accedere all'elenco studenti 4. Per accedere all'elenco docenti 0. Per chiudere il programma");
            System.out.print("Digitare: ");
            selezione = numero.nextInt();

            switch (selezione) {

                case 1:

                    System.out.print("Inserire il nome dello studente: ");
                    no = testo.nextLine();
                    System.out.print("Inserire il cognome dello studente: ");
                    cogno = testo.nextLine();
                    System.out.print("Inserire l'anno di nascita dello studente: ");
                    annoDiNasci = numero.nextInt();

                    if (annoDiNasci <= 2017) {

                        contatore++;

                        System.out.print("Inserire la sezione dello studente (A, B, C, D, E, F): ");
                        sezio = testo.nextLine().toUpperCase().charAt(0);

                        System.out.print("Inserire la classe dello studente (1, 2, 3, 4, 5): ");
                        clas = numero.nextInt();

                        matrico = String.format("%02d%03d%c", annoDiNasci % 100, contatore, sezio);

                        System.out.print("Lo studente ha Bisogni Educativi Speciali (S/N)? : ");
                        char risposta = testo.nextLine().toUpperCase().charAt(0);

                        if (risposta == 'S') {

                            StudentiBES.add(new StudenteBES(no, cogno, annoDiNasci, sezio, clas, matrico));

                        } else if (risposta == 'N') {

                           Studenti.add(new Studente(no, cogno, annoDiNasci, sezio, clas, matrico));

                        } else {

                            System.out.println("Input non valido.");

                            System.out.print("Lo studente ha Bisogni Educativi Speciali (S/N)? : ");
                            risposta = testo.nextLine().toUpperCase().charAt(0);
                        }
                                

                    } else {

                        break;

                    }

                    break;

                case 2:

                    System.out.print("Inserire il nome del docente : ");
                    no = testo.nextLine();
                    System.out.print("Inserire il cognome del docente: ");
                    cogno = testo.nextLine();
                    System.out.print("Inserire l'anno di nascita del docente: ");
                    annoDiNasci = numero.nextInt();

                    if (annoDiNasci <= 1993 && annoDiNasci > 1963) {
                        
                        System.out.println("Selezionare la materia del docente: ");

                        for (int i = 0; i < materie.length; i++ ) {

                            System.out.println((i + 1) + ". " + materie[i] + " ");

                        }

                        posizione = numero.nextInt();
                        mater = materie.length -1;

                        System.out.print("Il docente è un docente di sostegno (S/N)? : ");
                        int risposta2 = testo.nextLine().toUpperCase().charAt(0);

                        if (risposta2 == 'S') {

                            DocentiBES.add(new DocenteBES(no, cogno, annoDiNasci, mater));
                        
                        } else if (risposta2 == 'N') {
                        
                           Docenti.add(new Docente(no, cogno, annoDiNasci, mater));
                        
                        } else {
                        
                            System.out.println("Input non valido.");
                            System.out.print("Lo studente ha Bisogni Educativi Speciali (S/N)? : ");
                            risposta2 = testo.nextLine().toUpperCase().charAt(0);
                        }   


                    } else {

                        break;
                    }

                    break;

                case 3:
                    
                    for (Studente stampa : Studenti) {

                        System.out.println("Nome: " + stampa.getNome());
                        System.out.println("Cognome: " + stampa.getCognome());
                        System.out.println("Anno di nascita: " + stampa.getAnnoDiNascita());
                        System.out.println("Sezione: " + stampa.getSezione());
                        System.out.println("Classe: " + stampa.getClasse());
                        System.out.println("Matricola: " + stampa.getMatricola());
                        System.out.println(" ------------ ");
                     
                    }

                    for (StudenteBES stampa : StudentiBES) {

                        System.out.println("**** Studenti BES ****");
                        System.out.println("Nome: " + stampa.getNome());
                        System.out.println("Cognome: " + stampa.getCognome());
                        System.out.println("Anno di nascita: " + stampa.getAnnoDiNascita());
                        System.out.println("Sezione: " + stampa.getSezione());
                        System.out.println("Classe: " + stampa.getClasse());
                        System.out.println("Matricola: " + stampa.getMatricola());
                        System.out.println("Docente di sostegno assegnato: " + stampa.assegnazione);
                        System.out.println(" ------------ ");
                     
                    }

                    break;

                case 4:

                    for (Docente stampa : Docenti) {
 
                        String materiaScelta = materie[stampa.getMateria() - 1];

                        System.out.println("Nome: " + stampa.getNome());
                        System.out.println("Cognome: " + stampa.getCognome());
                        System.out.println("Anno di nascita: " + stampa.getAnnoDiNascita());
                        System.out.println("Materia: " + materiaScelta);
                        
                        System.out.println(" ------------ ");
                     
                    }

                     for (DocenteBES stampa : DocentiBES) {

                        System.out.println("**** Docenti BES ****");
                        System.out.println("Nome: " + stampa.getNome());
                        System.out.println("Cognome: " + stampa.getCognome());
                        System.out.println("Anno di nascita: " + stampa.getAnnoDiNascita());
                        System.out.println("Materia: " + stampa.getMateria());
                        System.out.println("Studenti assegnati: " + stampa.assegnazione);

                        
                        System.out.println(" ------------ ");
                     
                    }

                    break;

                case 0:

                    again = false;
                    break;

                default:
                
                System.out.println("Input errato.");
                System.out.println("1. Per aggiungere un nuovo studente 2. Per aggiungere un nuovo docente 3. Per accedere all'elenco studenti 4. Per accedere all'elenco docenti 0. Per chiudere il programma");
                System.out.print("Digitare: ");
                selezione = numero.nextInt();
                break;

            }

        } while (again);
    }

}
