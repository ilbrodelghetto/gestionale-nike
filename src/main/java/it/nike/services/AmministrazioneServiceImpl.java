package it.nike.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.nike.models.amministrazione.AppUser;
import it.nike.repository.AmministrazioneRepository;

@Service
public class AmministrazioneServiceImpl implements AmministrazioneService {
	
	
	@Autowired
	private AmministrazioneRepository amministrazioneRepository;
	
	@Override
	public AppUser salvaAmministratore (AppUser amministrazione){
	
		if(amministrazione != null) {
		
		return amministrazioneRepository.save(amministrazione);
	}
		else {
			return null;
		}
	}
	
	public AppUser aggiornaAmministratore (AppUser amministratoreNew, String email) {
		
		AppUser amministratore = amministrazioneRepository.findByEmail(email);
		amministratore.setPassword(amministratoreNew.getPassword());
		
		return amministrazioneRepository.save(amministratore);
		
	}
	
	public void cancellaAmmnistratore (AppUser amministrazione) {
		
		 amministrazioneRepository.delete(amministrazione);
	}
	
}
