package dev.siea.passbro;
import dev.siea.passbro.gui.GraphicalUserInterface;
public class PassBro {
    private final GraphicalUserInterface gui;
    private static PassBro passBro;
    public static void main(String[] args) {
        passBro = new PassBro();
    }

    public void stop(){
        gui.close();
    }
    public PassBro(){
        gui = new GraphicalUserInterface(this);
    }

    public GraphicalUserInterface getGui() {
        return gui;
    }

    public static PassBro getMain(){
        return passBro;
    }
}
