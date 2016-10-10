package fr.adaming.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import fr.adaming.entities.User;


public class UserDaoImpl implements IUserDao{
		
		
		@Override
		public void ajouterUserDao(User us){
			
			/**
			 * Créer une EMF
			 */
			
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("PU");
			
			/**
			 * Créer un EM
			 */
			
			EntityManager em=emf.createEntityManager();
			
			/**
			 * Créer une transaction à partir de em 
			 */
			
			EntityTransaction tx=em.getTransaction();
			
			/**
			 * Ouvrir la transaction
			 */
			
			tx.begin();
			
			User user=new User(us.getNom(), us.getPrenom(), us.getMail(), us.getMdp());
			
			em.persist(user);
			
			tx.commit();
			
			//Fermer les flux
			em.close();
			emf.close();	
			
			
					}

		@Override
		public List<User> getAllUserDao() {
			
			
			/**
			 * Créer une EMF			
			 */
			
			EntityManagerFactory emf= Persistence.createEntityManagerFactory("PU");
			
			/**
			 * Créer une EM
			 */
			
			EntityManager em=emf.createEntityManager();
			
			/**
			 * Créer une transaction à partir de em
			 */
			
			EntityTransaction tx=em.getTransaction();
			
			/**
			 * Ouvrir la transaction
			 */
			
			tx.begin();
			
			String jpqlReq="SELECT u from User as u";
			
			Query queryJpql=em.createQuery(jpqlReq);
			
			List<User> liste= queryJpql.getResultList();
			
			/**
			 * Fermer les flux 
			 */
			em.close();
			emf.close();
			
			return liste;
		}

		@Override
		public User getUserByIdDao(int id_user) {
//			
//			try {
//				/**
//				 * Chargement du driver
//				 */
//				Class.forName("com.mysql.jdbc.Driver");
//				
//				/**
//				 * Creation de la connexion
//				 */
//				cx=DriverManager.getConnection(url, userDb, passwordDb);
//				
//				/**
//				 * Ecrire la requete
//				 */
//				String sqlReq="SELECT * from user where id=?";
//				
//				/**
//				 * Creer un ps
//				 */
//				ps=cx.prepareStatement(sqlReq);
//				
//				ps.setInt(1, id_user);
//				
//				ResultSet rs=ps.executeQuery();
//				//"Genre" de curseur placé avant le tableau de résultat, on lui dit d'aller à la 1ère ligne du tablea
//				rs.next();
//				int id=rs.getInt("id");
//				
//				String nom=rs.getString("nom");
//				String prenom=rs.getString("prenom");
//				String mail=rs.getString("mail");
//				String password=rs.getString("mdp");
//				User us = new User(id, nom, prenom, mail, password); //User(id, nom, prenom, mail, rs.getString("mdp"));			
//				return us;
//						
//			} catch (ClassNotFoundException e) {
//				System.out.println("Exception ClassNotFound");
//				e.printStackTrace();
//			} catch (SQLException e) {
//				System.out.println("Exception SQL");
//				e.printStackTrace();
//			}finally{
//				try{
//					if(cx!=null)
//					{
//					cx.close();
//					}
//					}catch(Exception e)
//					{
//					e.printStackTrace();	
//					}
//				}

			
			
			return null;
		}

		@Override
		public void supprimerUserDao(User us) {
			
			/**
			 * Créer une EMF
			 */
			
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("PU");
			
			/**
			 * Créer un EM
			 */
			
			EntityManager em=emf.createEntityManager();
			
			/**
			 * Créer une transaction à partir de em 
			 */
			
			EntityTransaction tx=em.getTransaction();
			
			/**
			 * Ouvrir la transaction
			 */
			
			tx.begin();
			
			User u=em.find(User.class, us.getId());
			
			em.remove(u);
			
			//commiter la transaction
			tx.commit();
			
			//fermer les flux
			em.close();
			emf.close();
			

		}


		@Override
		public void modifierUserDao(User us) {
			
			//Creer une EMF
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("PU");
					
			//Creer em
			EntityManager em=emf.createEntityManager();
					
			//creer une transaction
			EntityTransaction tx=em.getTransaction();
					
			//ouvrir une transaction
			tx.begin();
			
			//récupérer un user de l'Id2
			User u=em.find(User.class, us.getId());
			
			//Faire un set sur les attributs qu'on souhaite changer
			u.setNom(us.getNom());
			u.setPrenom(us.getPrenom());
			u.setMail(us.getMail());
			u.setMdp(us.getMdp());
			
			//Envoyer les nouvelles infos dans l'EM
			em.merge(u);
			
			//Envoyer les infos dans la DB
			tx.commit();
			
			//Fermer les flux
			em.close();
			emf.close();
			
		}

	}
