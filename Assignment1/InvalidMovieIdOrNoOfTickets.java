package com.Assignment1;

public class InvalidMovieIdOrNoOfTickets extends RuntimeException{

	public InvalidMovieIdOrNoOfTickets(String str) {
		super(str);
	}
}
