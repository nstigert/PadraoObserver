import java.util.Observable;
import java.util.Observer;

public class Tutor implements Observer {

    private String nome;
    private String ultimaNotificacao;
    private Animal animal;

    public Tutor(String nome, Animal animal) {
        this.nome = nome;
        this.animal = animal;
    }

    public String getNomeAnimal() {
        return this.animal.getNome();
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void contratarServico(Servico servico) {
        servico.addObserver(this);
    }

    public void update(Observable servico, Object arg1) {
        this.ultimaNotificacao = this.nome + ", " +
                servico.toString() + " do(a) " +
                this.getNomeAnimal() + " finalizado";
    }
}
