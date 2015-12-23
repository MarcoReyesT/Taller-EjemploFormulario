/**
 * Licensee: Universidad de La Frontera
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class CreateTaller1MagisterInformaticaData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = orm.Taller1MagisterInformaticaPersistentManager.instance().getSession().beginTransaction();
		try {
			orm.Contacto lormContacto = orm.ContactoDAO.createContacto();
			// Initialize the properties of the persistent object here
			lormContacto.setNombre("Victor");
			lormContacto.setApellido("Aravena");
			lormContacto.setMail("victoraravena@ceisufro.cl");
			lormContacto.setTelefono("888888888");
			System.out.println("Ingreso Exitoso");
			orm.ContactoDAO.save(lormContacto);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateTaller1MagisterInformaticaData createTaller1MagisterInformaticaData = new CreateTaller1MagisterInformaticaData();
			try {
				createTaller1MagisterInformaticaData.createTestData();
			}
			finally {
				orm.Taller1MagisterInformaticaPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
