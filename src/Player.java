public class Player {
    private String name;
    private int Puntaje;

    public Player(String name) {
        this.name = name;
        this.Puntaje=0;
    }

    public String getName() {
        return name;
    }

    public int getPuntaje() {
        return Puntaje;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPuntaje(int puntaje) {
        Puntaje = puntaje;
    }
}
