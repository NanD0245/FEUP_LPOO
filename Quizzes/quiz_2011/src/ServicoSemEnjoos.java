public class ServicoSemEnjoos implements ServicoABordo{
    String descricao;

    ServicoSemEnjoos() {
        descricao = "Servico sem enjoos.";
    }

    @Override
    public String getDescricao() { return descricao; }
}
