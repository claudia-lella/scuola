import java.util.ArrayList;

public class DocenteBES extends Persona implements Sostegno{
    
    /* ---------- CAMPI ---------- */
    private int materia;
    int annoIscrizione;
    public ArrayList<String> Assegnazione = new ArrayList<String>();
    public String assegnazione;
    public String docenteSostegno;
    String[] materie = {"Matematica", "Italiano", "Geografia", "Inglese", "Scienze", "Storia", "Ed. fisica"};



    /* ---------- METODI ---------- */

    /* ---- costruttore ---- */
    public DocenteBES(String nome, String cognome, int annoDiNascita, int materia) {
        super(nome, cognome, annoDiNascita);
        setAnnoDiNascita(annoDiNascita);
        setMateria(materia);
        assegnazione = assegnazioneSostegno();
        
    }

    /* ---- inizio incapsulamento ---- */

    /* annoDiNascita */
    public void setAnnoDiNascita(int annoDiNascita) {

         if (annoDiNascita <= 1993 && annoDiNascita > 1963) {

                this.annoDiNascita = annoDiNascita;
                // repeat = false;

            } else {

                System.out.println("Purtroppo il docente non può essere assunto.");
            }

    }

    public int getAnnoDiNascita() {
        return annoDiNascita;
    }

    /* materia */
    public void setMateria(int materia) {

         boolean repeat = true;

        /* regola: lunghezza materia > 3 */

        do {    
        
            if (materia <= (materie.length - 1)) {

                this.materia = materia;
                repeat = false;

            } else {

                System.out.println("Materia non valida, deve avere più di 2 caratteri. Inserire la materia: ");
                materia = numero.nextInt();

            }
        
        } while (repeat);


    }

    public int getMateria() {
        return materia;
    }

    public String assegnazioneSostegno() {
        
        boolean repeat = true;
        int assegnazione = 1;
        StringBuilder sb = new StringBuilder();

        do {

            System.out.print("Assegnare un nuovo studenteBES al docente (S/N)? :");
            char risposta = testo.nextLine().toUpperCase().charAt(0);

            switch (risposta) {

                case 'S':    

                    if (Assegnazione.size() < 3) {

                        System.out.print("Inserire il nome dello studente: ");
                        String n = testo.nextLine();
                        System.out.print("Inserire il cognome dello studente: ");
                        String c = testo.nextLine();
                        Assegnazione.add(assegnazione + ". " + n + " " + c + " ");
                        assegnazione++;

                    } else if (Assegnazione.size() >= 3) {

                        System.out.print("E' stato già raggiunto il numero massimo di studenti assegnabili al docente.");
                        repeat = false;
                    }

                    break;

                case 'N':
                
                repeat = false;
                break; 
            
            }

        } while (repeat);

        for (int i = 0; i < Assegnazione.size(); i++) {

            sb.append(Assegnazione.get(i));

            if (i != Assegnazione.size() - 1) {
                sb.append(", ");
            }
        }

        return docenteSostegno = sb.toString();
    }
}
