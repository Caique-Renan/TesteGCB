package MedicalController;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import domain.MedicalEntity;
import services.MedicalServices;

public class MedicalController {
	
	private MedicalServices medicalServices;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<MedicalEntity>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(medicalServices.listar());
	}

}
