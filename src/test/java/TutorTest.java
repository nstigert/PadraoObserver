import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TutorTest {
    @Test
    void deveNotificarUmTutor() {
        Servico servico = new Servico("Banho");
        Tutor tutor = new Tutor("Nathalia", new Animal("Marie"));
        tutor.contratarServico(servico);
        servico.finalizarServico();
        assertEquals("Nathalia, Banho do(a) Marie finalizado", tutor.getUltimaNotificacao());
    }

    @Test
    void deveNotificarTutors() {
        Servico servico = new Servico("Banho");
        Tutor tutor1 = new Tutor("Nathalia", new Animal("Marie"));
        Tutor tutor2 = new Tutor("Marco", new Animal("Thor"));
        tutor1.contratarServico(servico);
        tutor2.contratarServico(servico);
        servico.finalizarServico();
        assertEquals("Nathalia, Banho do(a) Marie finalizado", tutor1.getUltimaNotificacao());
        assertEquals("Marco, Banho do(a) Thor finalizado", tutor2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarTutor() {
        Servico servico = new Servico("Tosa");
        Tutor tutor = new Tutor("Nathalia", new Animal("Marie"));
        servico.finalizarServico();
        assertEquals(null, tutor.getUltimaNotificacao());
    }

    @Test
    void deveNotificarTutorServicoA() {
        Servico servicoA = new Servico("Tosa");
        Servico servicoB = new Servico("Banho");
        Tutor tutor1 = new Tutor("Nathalia", new Animal("Marie"));
        Tutor tutor2 = new Tutor("Marco", new Animal("Thor"));
        tutor1.contratarServico(servicoA);
        tutor2.contratarServico(servicoB);
        servicoA.finalizarServico();
        assertEquals("Nathalia, Tosa do(a) Marie finalizado", tutor1.getUltimaNotificacao());
        assertEquals(null, tutor2.getUltimaNotificacao());
    }

}