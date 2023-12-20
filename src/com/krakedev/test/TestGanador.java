package com.krakedev.test;

import java.util.ArrayList;

import com.krakedev.entidades.Naipe;
import com.krakedev.servicios.Juego;

public class TestGanador {

	public static void main(String[] args) {

        ArrayList<String> listaJugadores = new ArrayList<>();
        listaJugadores.add("jugador 1");
        listaJugadores.add("jugador 2");
        listaJugadores.add("jugador 3");

        Juego juego = new Juego(listaJugadores);
        juego.entregarCartas(5);

        for (String jugador : listaJugadores) {
            int total = juego.devolverTotal(jugador);
            System.out.println("Total del jugador " + jugador + ": " + total);
        }

        String ganador = juego.determinarGanador();
        System.out.println("El ganador es: " + ganador);

	}
}

