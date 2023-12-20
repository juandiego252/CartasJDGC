package com.krakedev.servicios;

import java.util.ArrayList;

import com.krakedev.entidades.*;

public class Juego {

	private Naipe naipe;

	private ArrayList<ArrayList<Carta>> cartasJugador;
	
	public Juego() {
        naipe = new Naipe();
        naipe.barajar();
        cartasJugador = new ArrayList<ArrayList<Carta>>();

	}

	public Juego(ArrayList<String> idsJugadores) {

		this.cartasJugador = new ArrayList<>();

		for (String id : idsJugadores) {
			ArrayList<Carta> cartasJugadorActual = new ArrayList<Carta>();
			cartasJugador.add(cartasJugadorActual);
		}
	}

	public ArrayList<ArrayList<Carta>> getCartasJugador() {
		return cartasJugador;
	}

	public void entregarCartas(int cartasPorjugador) {

		for (int i = 0; i < cartasPorjugador; i++) {
	        for (ArrayList<Carta> cartasActualJugador : cartasJugador) {
	                Carta cartaEntregada = naipe.getCartas().remove(3);
	                cartasActualJugador.add(cartaEntregada);
	            }
	        }
	    }


	public int devolverTotal(String idJugador) {
		for (ArrayList<Carta> jugador : cartasJugador) {
			if (jugador.get(0).getNumero().getNumeroCarta().equals(idJugador)) {
				int total = 0;
				for (Carta carta : jugador) {
					total += carta.getNumero().getValor();
				}
				return total;
			}
		}
		System.out.println("Error al encontrar jugador");
		return 0;

	}

	public String determinarGanador() {
		String idGanador = cartasJugador.get(0).get(0).getNumero().getNumeroCarta();
		int sumGanador = devolverTotal(idGanador);

		for (ArrayList<Carta> jugador : cartasJugador) {
			String idJugador = jugador.get(0).getNumero().getNumeroCarta();
			int sumaJugador = devolverTotal(idJugador);

			if (sumaJugador > sumGanador) {
				idGanador = idJugador;
				sumGanador = sumaJugador;
			}
		}
		return idGanador;

	}

}
