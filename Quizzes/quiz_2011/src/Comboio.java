import java.util.ArrayList;
import java.util.List;

public class Comboio {

    String nome;
    List<Carruagem> carruagens;
    ServicoABordo servicoABordo;

    public Comboio(String nome) {
        this.nome = nome;
        carruagens = new ArrayList<>();
        servicoABordo = new ServicoRegular();
    }

    public Comboio(String nome, ServicoABordo servico) {
        this.nome = nome;
        carruagens = new ArrayList<>();
        servicoABordo = servico;
    }

    public String getNome() { return nome; }

    public int getNumLugares() {
        int sum = 0;
        for (Carruagem carruagem: carruagens)
            sum += carruagem.getNumLugares();
        return sum;
    }

    public List<Carruagem> getCarruagens() { return carruagens; }

    public int getNumCarruagens() { return carruagens.size(); }

    public void addCarruagem(Carruagem carruagem) {
        carruagens.add(carruagem);
    }

    public Carruagem getCarruagemByOrder(int i) {
        return carruagens.get(i);
    }

    public ServicoABordo getServicoABordo() { return servicoABordo; }

    public void removeAllCarruagens(int capacity) {
        List<Carruagem> c = new ArrayList<>();
        for (Carruagem carruagem: carruagens)
            if (carruagem.getNumLugares() != capacity)
                c.add(carruagem);
        this.carruagens = c;
    }

    public int getNumPassageiros() {
        int sum = 0;
        for (Carruagem carruagem: carruagens)
            sum += carruagem.getNumPassageiros();
        return sum;
    }

    public int getLugaresLivres() {
        int sum = 0;
        for (Carruagem carruagem: carruagens)
            sum += carruagem.getLugaresLivres();
        return sum;
    }

    public void addPassageiros(int num) throws PassengerCapacityExceeded {
        while (num != 0) {
            boolean check = false;
            for (Carruagem carruagem: carruagens) {
                if (carruagem.getLugaresLivres() > 0) {
                    carruagem.addPassageiro();
                    num--;
                    check = true;
                    break;
                }
            }
            if (!check) throw new PassengerCapacityExceeded();
        }
    }

    public void removePassageiros(int i) {
        while (i != 0) {
            if (getNumPassageiros() == 0) break;
            for (Carruagem carruagem: carruagens)
                if (carruagem.numPassageiros > 0) {
                    carruagem.removePassageiro();
                    break;
                }
            i--;
        }
    }

    public void removePassageiros() {
        for (Carruagem carruagem: carruagens)
            carruagem.removePassageirosTodos();
    }

    @Override
    public String toString() {
        String carruagem, lugar, passageiro;
        carruagem = (getNumCarruagens() == 1) ? " carruagem, " : " carruagens, ";
        lugar = (getNumLugares() == 1) ? " lugar, " : " lugares, ";
        passageiro = (getNumPassageiros() == 1) ? " passageiro" : " passageiros";
        return "Comboio " + nome + ", " + getNumCarruagens() + carruagem + getNumLugares() + lugar +
                getNumPassageiros() + passageiro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comboio comboio = (Comboio) o;
        if (getNumCarruagens() != comboio.getNumCarruagens()) return false;
        for (int i = 0; i < getNumCarruagens(); i++)
            if (getCarruagens().get(i).getNumLugares() != comboio.getCarruagens().get(i).getNumLugares())
                return false;
        return true;
    }

    public String getDescricaoServico() { return servicoABordo.getDescricao(); }

    public void setServicoABordo(ServicoPrioritario servico) { this.servicoABordo = servico; }
}
