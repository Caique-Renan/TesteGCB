package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "TB_MEDICAL")
public class MedicalEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	@Column
	private String nome;
	
	@Column
	private String CRM;
	
	@Column
	private Byte telefone;
	
	@Column
	private Byte celular;
	
	@Column
	private String especialidade;
	
	@Column
	private Byte CEP;

}
