package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Número do quarto: ");
		int number = sc.nextInt();
		System.out.print(" Data de Check-in  (dd/mm/yyyy) ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print(" Data de Check-out  (dd/mm/yyyy) ");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: Data de check-out precisa ser depois da data de check-in! ");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reserva: "+ reservation);
			
			System.out.println();
			System.out.println("Entre com os dados de atualizacação da reserva: ");
			System.out.print(" Data de Check-in  (dd/mm/yyyy) ");
			checkIn = sdf.parse(sc.next());
			System.out.print(" Data de Check-out  (dd/mm/yyyy) ");
			checkOut = sdf.parse(sc.next());
			
			
			Date now = new Date();
			if(checkIn.before(now)|| checkOut.before(now)) {
				System.out.println("Erro na atualização da reserva: atualizacação da reserva precisa ser depois da reserva anterior!");
			} else if(!checkOut.after(checkIn)) {
				System.out.println("Erro na reserva: Data de check-out precisa ser depois da data de check-in! ");
		
			} else {
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reserva: "+ reservation);
			}
		}
		
		sc.close();
	}

}
