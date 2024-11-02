package ma.tp.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import ma.tp.entities.Compte;
import ma.tp.repository.CompteRepository;

@Component
@Path("/banque")
public class CompteRestJaxRSAPI {

	@Autowired
	private CompteRepository compteRepository;

	@GET
	@Path("/comptes")
	@Produces({ MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public List<Compte> getComptes() {
		return this.compteRepository.findAll();
	}

	@GET
	@Path("/comptes/{id}")
	@Produces({ MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public Compte getCompte(@PathParam("id") Long id) {
		return this.compteRepository.findById(id).orElse(null);
	}

	@POST
	@Path("/comptes")
	@Produces({ MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@Consumes({ MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public Compte addCompte(Compte compte) {
		return this.compteRepository.save(compte);
	}

	@PUT
	@Path("/comptes/{id}")
	@Produces({ MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@Consumes({ MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public Compte updateCompte(@PathParam("id") Long id, Compte compte) {
		Compte existingCompte = this.compteRepository.findById(id).orElse(null);
		if (existingCompte != null) {
			existingCompte.setSold(compte.getSold());
			existingCompte.setDateCreation(compte.getDateCreation());
			existingCompte.setTypeCompte(compte.getTypeCompte());
			return this.compteRepository.save(existingCompte);
		}

		return null;
	}

	@DELETE
	@Path("/comptes/{id}")
	@Produces({ MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public void deleteCompte(@PathParam("id") Long id) {
		this.compteRepository.deleteById(id);
	}

}