package com.krakedev.entidades;

public class Random {
	public static int obtenerPosicion() {
		int numeroRandom = (int) (Math.random() * 52);
		return numeroRandom;
	}
}
