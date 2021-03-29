public class ServicoPrioritario implements ServicoABordo {
    String descrição;

    ServicoPrioritario() {
        this.descrição = "Servico prioritario.";
    }

    @Override
    public String getDescricao() { return descrição; }
}
