/**
 * 
 */
package com.projet.modules.trial.main;

import com.projet.modules.trial.jdbc.MySQLAccess;
import com.projet.modules.trial.pojo.Individu;
import com.projet.modules.trial.pojo.Person;

import lombok.extern.log4j.Log4j;

/**
 * @author bilonjea
 *
 */
@Log4j
public class MainTrivialJdbc {
	///private static final Logger log = Logger.getLogger(Main.class);

		/**
		 * @param args
		 * @throws Exception 
		 */
		public static void main(String[] args) throws Exception {
	        
			//creationIndividu();
			//creationPersone();
			System.out.println("-------START--------");
			lancerMysql();
			
			System.out.println("-------STOP--------");


		}

		
		private static void creationIndividu() {
			Individu person = new Individu();
			person.setAdress("25 rue de la poste 77000");
			person.setAge(13);
			person.setNom("Durant");

			log.info(person);

		}


		private static void creationPersone() {
			Person person = new Person();
			person.setAdress("25 rue de la poste 77000");
			person.setAge(13);
			person.setNom("Durant");

			log.info(person);

		}

		private static void lancerMysql() {
			log.info("Mysql");

			try {
				MySQLAccess dao = new MySQLAccess();
				dao.readDataBase();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
