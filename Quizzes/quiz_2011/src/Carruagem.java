public class Carruagem {
    int numLugares, lugaresLivres, numPassageiros;

    public Carruagem(int numLugares) {
        this.numLugares = numLugares;
        this.lugaresLivres = numLugares;
        this.numPassageiros = 0;
    }

    public int getNumLugares() { return numLugares; }

    public int getLugaresLivres() { return lugaresLivres; }

    public int getNumPassageiros() { return numPassageiros; }

    public void addPassageiro() {
        numPassageiros++;
        lugaresLivres--;
    }

    public void removePassageiro() {
        numPassageiros--;
        lugaresLivres++;
    }

    public void removePassageirosTodos() {
        numPassageiros = 0;
        lugaresLivres = numLugares;
    }
}
