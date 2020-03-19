package it.polito.tdp.model.alien.model;

import it.polito.tdp.alien.AlienDictionary;

public class Model {
	
	private AlienDictionary dictionary;
	
	public Model() {
		
		this.dictionary = new AlienDictionary();
	}

	public void nuovaParola(String alienWord, String translation) {
		
		dictionary.addWord(alienWord, translation);
	}
	
	public String traduzioneParola(String alienWord) {
		return dictionary.translateWord(alienWord);
	}
	
	/**elimina il dizionario
	 * 
	 */
	public void resetDizionario() {
		dictionary.clearDictionary();
	}
	
	public String stampaDizionario() {
		return dictionary.printWords();
	}

}
