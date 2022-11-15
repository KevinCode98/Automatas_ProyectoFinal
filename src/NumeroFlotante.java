public class NumeroFlotante {
    private final String cadena;
    private boolean aceptado;
    private int position;

    public NumeroFlotante(String cadena) {
        this.cadena = cadena;
        this.aceptado = false;
        this.position = 0;
        q0();
    }

    private void q0() {
        if (position == cadena.length()) return;

        System.out.println("Entro en el estado q0");
        if (cadena.charAt(position) >= 48 && cadena.charAt(position) <= 57) {
            position++;
            q0();
        } else if (cadena.charAt(position) == '.') {
            position++;
            q1();
        }
    }

    // Puntos a tener en cuenta → Leer archivo .txt
    // Esto lleva una interfaz gráfica

    // 1.- Recibir la cadena
    // 2.- Split de la cadena
    // 3.- recorrido de todas las sub-cadenas
    // 4.- System -> Saber si se encuentra en las palabras reservadas
        // -> true: Next cadena
        // -> false: posición de cadena para hacer la búsqueda de autómata signado
            // -> NumeroEntero, NumeroFlotante, Comentario, igualación,etc....


    private void q1() {
        if(position == cadena.length()) return;

        System.out.println("Entro en el estado q1");
        if (cadena.charAt(position) >= 48 && cadena.charAt(position) <= 57) {
            position++;
            if (position == cadena.length()) aceptado = true;
            q1();
        }
    }

    public void esNumeroFlotante() {
        if (this.aceptado) System.out.println("Es un número flotante.");
        else System.out.println("No es un número flotante.");
    }
}
