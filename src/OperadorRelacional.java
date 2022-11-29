public final class OperadorRelacional extends Automata {
    public static int cantidadOperadorRelacional = 0;

    public OperadorRelacional() {
        super();
        q0();
    }

    protected void q0() {
        if (Automata.position >= Automata.cadena.length()) return;

        System.out.println("Entro en el estado q0 -> " + this.getClass().getSimpleName());

        if ((Automata.cadena.charAt(Automata.position) == '<' || Automata.cadena.charAt(Automata.position) == '>') &&
                ControlAutomata.saberSiHayEspacio(Automata.position + 1)) {
//            GUI.textArea.setText(GUI.textArea.getText() + "\n" + "Entro en el estado q0 -> " + this.getClass().getSimpleName());

            aceptado = true;
            ++OperadorRelacional.cantidadOperadorRelacional;
            return;
        }


        if (Automata.cadena.charAt(Automata.position) == '<' || Automata.cadena.charAt(Automata.position) == '>' ||
                Automata.cadena.charAt(Automata.position) == '=' || Automata.cadena.charAt(Automata.position) == '!') {
            Automata.position++;
            q1();
        }
    }

    private void q1() {
        System.out.println("Entro en el estado q1 -> " + this.getClass().getSimpleName());
//        GUI.textArea.setText(GUI.textArea.getText() + "\n" + "Entro en el estado q1 -> " + this.getClass().getSimpleName());
        if (Automata.cadena.charAt(Automata.position) == '=' &&
                ControlAutomata.saberSiHayEspacio(Automata.position + 1)) {
            aceptado = true;
            ++OperadorRelacional.cantidadOperadorRelacional;
        }
    }
}
