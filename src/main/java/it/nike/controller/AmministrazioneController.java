package it.nike.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.nike.models.amministrazione.Amministrazione;
import it.nike.services.AmministrazioneService;

@RestController
@RequestMapping(path="/api/v1")
@CrossOrigin("http://localhost:27017")
public class AmministrazioneController {

	
	private AmministrazioneService amministrazioneService;
	
	@PostMapping(path="/salvaAmministratore")
	public Amministrazione salvaAmministratore (@RequestBody Amministrazione amministrazione) {
		return amministrazioneService.salvaAmministratore(amministrazione);
	}
	
	@PutMapping(path="/aggiornaAmmnistratore/{email}")
	public Amministrazione aggiornaAmministratore (@RequestBody Amministrazione amministratore, @PathVariable String email) {
		return amministrazioneService.aggiornaAmministratore(amministratore, email);
	}
	
	@DeleteMapping(path="/cancellaAmministratore")
	public void cancellaAmministratore (@RequestBody Amministrazione amministrazione) {
		
		this.amministrazioneService.cancellaAmmnistratore(amministrazione);
		
	}
	
	
	
	
}
