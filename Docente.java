public class Docente extends Persona {
    
    /* ---------- CAMPI ---------- */
    private int materia;
    int annoIscrizione;
    String[] materie = {"Matematica", "Italiano", "Geografia", "Inglese", "Scienze", "Storia", "Ed. fisica"};



    /* ---------- METODI ---------- */

    /* ---- costruttore ---- */
    public Docente(String nome, String cognome, int annoDiNascita, int materia) {
        super(nome, cognome, annoDiNascita);
        setAnnoDiNascita(annoDiNascita);
        setMateria(materia);
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

}
