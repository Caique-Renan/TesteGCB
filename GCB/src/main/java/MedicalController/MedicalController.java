package MedicalController;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import domain.MedicalEntity;
import services.MedicalServices;

public class MedicalController {
	
	private MedicalServices medicalServices;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<MedicalEntity>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(medicalServices.listar());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Validated @RequestBody MedicalEntity addressRequest) {
		addressRequest = medicalServices.salvar(addressRequest);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(addressRequest.getClass()).toUri();
		
		return ResponseEntity.created(uri).build();
	
	}
	
}


