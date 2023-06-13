import java.util.Observable;

public class Servico extends Observable {
    private String nomeServico;

    public Servico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public void finalizarServico() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return nomeServico;
    }
}
