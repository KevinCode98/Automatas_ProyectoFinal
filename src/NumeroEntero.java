public class NumeroEntero {
    private boolean aceptado;
    private final String cadena;
    private int position;

    public NumeroEntero(String cadena) {
        this.cadena = cadena;
        this.aceptado = false;
        this.position = 0;
        q0();
    }

    public void q0() {
        if (position == cadena.length()) return;

        System.out.println("Entro en el estado q0");
        if (cadena.charAt(position) >= 48 && cadena.charAt(position) <= 57) {
            position++;
            if (position == cadena.length()) aceptado = true;
            q0();
        }
    }

    public void esNumeroEntero() {
        if (this.aceptado) System.out.println("Es un número entero.");
        else System.out.println("No es un número entero.");
    }
}
