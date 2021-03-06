package Controller;

import Model.Onibus;
import Model.Paradas;
import java.util.concurrent.ThreadLocalRandom;

public class OnibusRoda extends Thread {

    private Onibus progresso;
    private int idOnibus;
    private Paradas paradaLivre = null;
    private Thread thread;
    private Onibus onibus;
    private int tempo;

    public OnibusRoda(int idOnibus, Onibus onibus) {
        this.idOnibus = idOnibus;
        this.onibus = onibus;
        thread = new Thread();
    }

    public OnibusRoda() {
    }

    @Override
    public void run() {
        while (true) {
            paradaLivre = SincMetodos.getParadaDisponivel(paradaLivre);

            if (paradaLivre != null) {
                //imprime sequência de 10 números inteiros aleatórios entre 0 e 25               

                tempo = ThreadLocalRandom.current().nextInt(1, 6);
                tempo = tempo * 1000;

                try {
                    paradaLivre.getProgressbar().setMinimum(0);
                    paradaLivre.getProgressbar().setMaximum(tempo);
                    paradaLivre.getProgressbar().setForeground(onibus.getCorTextoProgBar());
                    paradaLivre.getProgressbar().setBackground(onibus.getCorProgressBar());
                    paradaLivre.getProgressbar().setString("Onibus " + onibus.getIdOnibus() + " aguardando embarque");

                    for (int x = 1; x <= tempo; x++) {
                        synchronized (this) {
                            while (SincMetodos.paradinha) {
                                wait();
                            }
                        }

                        paradaLivre.getProgressbar().setValue(x);
                        thread.sleep(1);
                    }

                    SincMetodos.ZerarBarra(paradaLivre);

                } catch (Exception e) {
                }
            }
        }
    }

}
