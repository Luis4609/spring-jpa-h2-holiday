package com.optimissa.holidayreader;
import javax.persistence.EntityManager;

public class ServicioHolidays {

	//añadir
	
		public static To_Trade_Holidays createHolidays(EntityManager em, int id, String nombre, To_Trade_Calendars calendar) {
			
			To_Trade_Holidays a = new To_Trade_Holidays (id,nombre);
			
			em.persist(a);
			
			return a;
		}
		
		//borrar
		
		public static boolean deleteHoliday(EntityManager em, int id) {
			
			To_Trade_Holidays a = em.find(To_Trade_Holidays.class, id);
			
			if(a!=null) {
				
				em.remove(a);
				return true;
			}
			return false;
		}
		
		//modificar
		
		public static To_Trade_Holidays modifyHolidays (EntityManager em ,int id,String nombre) {
			
			To_Trade_Holidays a = em.find(To_Trade_Holidays.class, id);
			
			if(a!=null) {
			
				a.setHoliday(nombre);
				a.setId(id);
				
			}
			return a;
		}
		
		//buscar
		
		public static To_Trade_Holidays searchHolidays (EntityManager em, int id) {
			
			return em.find(To_Trade_Holidays.class, id);
			
		}
		
		
}
