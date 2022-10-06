public class Quarto {
    private String numero;
    private Hospede hospede;

    public Quarto(String n, Hospede h){
        numero = n;
        hospede = h;
    }

    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public Hospede getHospede() {
        return hospede;
    }
    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    
}