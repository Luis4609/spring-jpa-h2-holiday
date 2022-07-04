package com.optimissa.holidayreader;

import javax.persistence.EntityManager;

public class ServicioCalendar {

	

	//añadir
	
		public static To_Trade_Calendars createCalendar(EntityManager em, int id, String nombre) {
			
			To_Trade_Calendars a = new To_Trade_Calendars (id,nombre);
			
			em.persist(a);
			
			return a;
		}
		
		//borrar
		
		public static boolean deleteCalendar(EntityManager em, int id) {
			
			To_Trade_Calendars a = em.find(To_Trade_Calendars.class, id);
			
			if(a!=null) {
				
				em.remove(a);
				return true;
			}
			return false;
		}
		
		//modificar
		
		public static To_Trade_Calendars modifyCalendar(EntityManager em ,int id,String nombre) {
			
			To_Trade_Calendars a = em.find(To_Trade_Calendars.class, id);
			
			if(a!=null) {
			
				a.setId_idCalendar(id);
				a.setNombre(nombre);
				
			}
			return a;
		}
		
		//buscar
		
		public static To_Trade_Calendars searchCalendar(EntityManager em, int id) {
			
			return em.find(To_Trade_Calendars.class, id);
			
		}
}
