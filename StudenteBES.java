
public class StudenteBES extends Persona implements Sostegno {

    /* ---------- CAMPI ---------- */
    private String matricola;
    private char sezione;
    private int classe;
    public String assegnazione;
    public String docenteSostegno;

    /* ---------- METODI ---------- */

    /* ---- costruttore ---- */
    public StudenteBES(String nome, String cognome, int annoDiNascita, char sezione, int classe, String matricola) {
        super(nome, cognome, annoDiNascita);
        setAnnoDiNascita(annoDiNascita);
        setSezione(sezione);
        setMatricola(matricola);
        setClasse(classe);
        assegnazione = assegnazioneSostegno();

    }

    /* ---- inizio incapsulamento ---- */

    /* annoDiNascita */
    public void setAnnoDiNascita(int annoDiNascita) {

        // boolean repeat = true;

        /* regola: annoDiNascita < 2017 */

        // do {    
        
            if (annoDiNascita <= 2017) {

                this.annoDiNascita = annoDiNascita;
                // repeat = false;

            } else {

                System.out.println("Purtroppo il ragazzo non può ancora essere iscritto.");
            }
        
        // } while (repeat);

    }

    public int getAnnoDiNascita() {
        return annoDiNascita;
    }

    /* sezione */
    public void setSezione(char sezione) {

         boolean repeat = true;

        /* regola: classi dalla A alla F */

        do {    
        
            if (sezione == 'A' || sezione == 'B' || sezione == 'C' || sezione == 'D' || sezione == 'E' || sezione == 'F' ) {

                this.sezione = sezione;
                repeat = false;

            } else {

                System.out.println("Non si sono ancora formate sezioni oltre la F. Inserire la sezione: ");
                sezione = testo.nextLine().toUpperCase().charAt(0);
            }
        
        } while (repeat);
    }

    public char getSezione() {
        return sezione;
    }

    /* classe */
    public void setClasse(int classe) {

        boolean repeat = true;

        /* regola: classe < 6 */

        do {    
        
            if (classe > 0 && classe <= 5) {

                this.classe = classe;
                repeat = false;

            } else {

                System.out.println("Input non valido. Siamo in Italia, le classi sono massimo 5. Reinserire: ");
                classe = numero.nextInt();

            }
        
        } while (repeat);

    }

    public int getClasse() {
        return classe;
    }

    /* matricola */
    public void setMatricola(String matricola) {

        boolean repeat = true;

        /* regola: lunghezza matricola di 6 caratteri */

        do {    
        
            if (matricola.length() == 6) {

                this.matricola = matricola;
                repeat = false;

            } else {

                System.out.println("Matricola non valida.");

            }
        
        } while (repeat);

    }

    public String getMatricola() {
        return matricola;
    }

    /* ---- fine incapsulamento ---- */

    public String assegnazioneSostegno() {

        System.out.print("Assegnare il docente di sostegno. Inserire il nome: ");
        String n = testo.nextLine();
        System.out.print("Inserire il cognome: ");
        String c = testo.nextLine();

        docenteSostegno = n + " " + c;

        return docenteSostegno;
    }


}
