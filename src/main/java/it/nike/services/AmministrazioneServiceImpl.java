package it.nike.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.nike.models.amministrazione.Amministrazione;
import it.nike.repository.AmministrazioneRepository;

@Service
public class AmministrazioneServiceImpl implements AmministrazioneService {
	
	
	@Autowired
	private AmministrazioneRepository amministrazioneRepository;
	
	@Override
	public Amministrazione salvaAmministratore (Amministrazione amministrazione){
	
		if(amministrazione != null) {
		
		return amministrazioneRepository.save(amministrazione);
	}
		else {
			return null;
		}
	}
	
	public Amministrazione aggiornaAmministratore (Amministrazione amministratoreNew, String email) {
		
		Amministrazione amministratore = amministrazioneRepository.findByEmail(email);
		amministratore.setPassword(amministratoreNew.getPassword());
		
		return amministrazioneRepository.save(amministratore);
		
	}
	
	public void cancellaAmmnistratore (Amministrazione amministrazione) {
		
		 amministrazioneRepository.delete(amministrazione);
	}
	
}
