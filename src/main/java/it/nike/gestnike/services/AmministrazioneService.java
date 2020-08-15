package it.nike.gestnike.services;

import it.nike.gestnike.models.AppUser;

public interface AmministrazioneService {

	public AppUser salvaAmministratore (AppUser amministrazione);
	public AppUser aggiornaAmministratore (AppUser amministratoreNew, String email);
	public void cancellaAmmnistratore (AppUser amministratore);
}
