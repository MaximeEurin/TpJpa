package fr.adaming.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="agent")
@NamedQuery(name="getAgent",query="SELECT a from Agent as a where a.mail=?1 and a.password=?2")
public class Agent {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String mail;
	private String password;
	
	/**
	 * Constructeur sans paramètres
	 */
	public Agent() {
		super();
	}
	
	/**
	 * 
	 * Constructeur avec paramètres sans id
	 * @param mail
	 * @param mdp
	 */
	public Agent(String mail, String mdp) {
		super();
		this.mail = mail;
		this.password = mdp;
	}

	/**
	 * Constructeurs avec tous les paramètres
	 * @param id_agent
	 * @param mail
	 * @param mdp
	 */
	public Agent(int id_agent, String mail, String mdp) {
		super();
		this.id = id_agent;
		this.mail = mail;
		this.password = mdp;
	}
	
	/**
	 * 
	 * Getter et Setter
	 * @return
	 */

	public int getId_agent() {
		return id;
	}

	public void setId_agent(int id_agent) {
		this.id = id_agent;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMdp() {
		return password;
	}

	public void setMdp(String mdp) {
		this.password = mdp;
	}
	
	
	@Override
	public String toString() {
		return "Agent [id_agent=" + id + ", mail=" + mail + ", mdp="
				+ password + "]";
	}
	
	

}
