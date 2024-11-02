package ma.tp.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private double sold;

	@Temporal(TemporalType.DATE)
	private Date dateCreation;

	@Enumerated(EnumType.ORDINAL)
	private TypeCompte typeCompte;

}
