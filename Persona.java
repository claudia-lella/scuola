import java.util.Scanner;

/* superclasse Persona */
public abstract class Persona {
   
    /* ---------- CAMPI ---------- */
    Scanner testo = new Scanner(System.in);
    Scanner numero = new Scanner(System.in);
    private String nome;
    private String cognome;
    protected int annoDiNascita;

    /* ---------- METODI ---------- */

    /* ---- costruttore ---- */
    public Persona(String nome, String cognome, int annoDiNascita) {

        setNome(nome);
        setCognome(cognome);
    }

    /* ---- inizio incapsulamento ---- */

    /* nome */
    public void setNome(String nome) {

        boolean repeat = true;

        do {

            if (nome.length() > 1) {

                this.nome = nome;
                repeat = false;

            } else {

                System.out.println("Il nome immesso non è valido, deve avere più di 1 carattere. Inserire il nome: ");
                nome = testo.nextLine();
            }

        } while (repeat);

        
    }

    public String getNome() {
        return nome;
    }

    /* cognome */
    public void setCognome(String cognome) {

        boolean repeat = true;

        do {

            if (cognome.length() > 1) {

                this.cognome = cognome;
                repeat = false;

            } else {

                System.out.println("Il cognome immesso non è valido, deve avere più di 1 carattere. Inserire il cognome: ");
                cognome = testo.nextLine();
            }

        } while (repeat);

        
    }

    public String getCognome() {
        return cognome;
    }

    public abstract void setAnnoDiNascita(int annoDiNascita);
	
	public abstract int getAnnoDiNascita();


}
