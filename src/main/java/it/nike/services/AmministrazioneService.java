package it.nike.services;

import it.nike.models.amministrazione.AppUser;

public interface AmministrazioneService {

	public AppUser salvaAmministratore (AppUser amministrazione);
	public AppUser aggiornaAmministratore (AppUser amministratoreNew, String email);
	public void cancellaAmmnistratore (AppUser amministratore);
}
