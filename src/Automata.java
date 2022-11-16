public abstract class Automata {
    protected abstract void q0();

    protected boolean aceptado;
    protected final String cadena;
    protected int position;

    public Automata(String cadena) {
        this.cadena = cadena;
        this.aceptado = false;
        this.position = 0;
    }

    protected boolean isAceptado() {
        return aceptado;
    }

    protected void setAceptado(boolean aceptado) {
        this.aceptado = aceptado;
    }

    protected String getCadena() {
        return cadena;
    }

    protected int getPosition() {
        return position;
    }

    protected void setPosition(int position) {
        this.position = position;
    }

    protected void esAceptado() {
        if (this.aceptado) System.out.println("Es un " + this.getClass().getSimpleName() + ".");
        else System.out.println("No es un " + this.getClass().getSimpleName() + ".");
    }
}
