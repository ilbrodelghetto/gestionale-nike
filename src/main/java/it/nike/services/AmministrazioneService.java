package it.nike.services;

import it.nike.models.amministrazione.Amministrazione;

public interface AmministrazioneService {

	public Amministrazione salvaAmministratore (Amministrazione amministrazione);
	public Amministrazione aggiornaAmministratore (Amministrazione amministratoreNew, String email);
	public void cancellaAmmnistratore (Amministrazione amministratore);
}
