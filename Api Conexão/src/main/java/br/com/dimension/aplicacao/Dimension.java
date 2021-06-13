package br.com.dimension.aplicacao;

import br.com.dimension.maquina.Maquina;
import java.util.Timer;
import java.util.TimerTask;

public class Dimension {
    public static void main(String[] args) {
        Maquina maquina = new Maquina();
        Timer timer = new Timer();
        final long intervalo = (1000*5);
        
        TimerTask tarefa = new TimerTask() {
            @Override
            public void run() {
                maquina.memoria();
                maquina.processador();
                maquina.processos();
                maquina.sistema();
//                System.exit(0); //To change body of generated methods, choose Tools | Templates.
            }
        };
        timer.scheduleAtFixedRate(tarefa, 0,intervalo);
        
    }}