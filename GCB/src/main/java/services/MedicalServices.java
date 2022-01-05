package services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import domain.MedicalEntity;
import repository.MedicalRepository;

@Service
public class MedicalServices {
	
	@Autowired
	private MedicalRepository medicalRepository;
	
	public static final Logger log = LoggerFactory.getLogger(MedicalServices.class);
	
public List<MedicalEntity> listar() {
		
		List<MedicalEntity> addressList = medicalRepository.findAll();
		log.info("O numero de Enderecos e: {}", addressList.size());
		return addressList;
	}

public MedicalEntity salvar(MedicalEntity medicalRequest) {
	MedicalEntity save = medicalRepository.save(medicalRequest);
	log.info("Endereco criado com sucesso, com os parametros: {} ", save.toString());
	return save;
}

public void deletar(Long id) throws Exception {
	try {
		medicalRepository.deleteById(id);
	} catch (EmptyResultDataAccessException e) {
		throw new Exception("O usuário não pode ser encontrado");
	}
}
public void atualizar(MedicalEntity medico) {
	medicalRepository.save(medico);
}

public Optional<MedicalRepository> buscar(Long id) {
	Optional<MedicalRepository> usuario = medicalRepository.findOne(medicalRepository);
	
	if (usuario == null) {
		throw new Exception("O usuário não pode ser encontrado");
	}
	return usuario;
}


}
