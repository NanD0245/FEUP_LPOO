public class TGV extends Comboio {
    public TGV(String nome) {
        super(nome, new ServicoPrioritario());
    }

    @Override
    public String toString() {
        String carruagem, lugar, passageiro;
        carruagem = (getNumCarruagens() == 1) ? " carruagem, " : " carruagens, ";
        lugar = (getNumLugares() == 1) ? " lugar, " : " lugares, ";
        passageiro = (getNumPassageiros() == 1) ? " passageiro" : " passageiros";
        return "TGV " + nome + ", " + getNumCarruagens() + carruagem + getNumLugares() + lugar +
                getNumPassageiros() + passageiro;
    }
}
