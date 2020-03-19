package it.polito.tdp.alien;

import java.util.LinkedList;
import java.util.List;

public class AlienDictionary {

	private List<Word> words;
	
	/**Costruttore Dizionario alieno, crea una LinkedList
	 * di Word
	 * 
	 */
	public AlienDictionary() {
		this.words = new LinkedList<Word>();
	}

	/**Aggiunge una nuova parola alla Lista dizionario
	 * Modifica la traduzione se esiste già la parola aliena
	 * 
	 * @param alienWord parola aliena 
	 * @param translation traduzione inglese
	 */
	public void addWord(String alienWord, String translation) {
		
		String aw = alienWord.toLowerCase();
		String tr = translation.toLowerCase();
		Word word = new Word(aw, tr);
		if(this.words.indexOf(word) != -1) {
			this.words.get(this.words.indexOf(word)).setTranslation(tr);
		}
		else {
			this.words.add(word);
		}
	}
	
	/**Cerca la traduzione nel dizionario della parola aliena
	 * passata come parametro
	 * 
	 * @param alienWord parola aliena di cui si cerca la traduzione
	 * @return parola inglese corrispondente, o null se non esiste traduzione
	 */
	public String translateWord(String alienWord) {
		for(Word w : words) {
			if(w.getAlienWord().equals(alienWord.toLowerCase())) {
				return w.getTranslation();
			}
		}
		return null;
	}
	
	/**
	 * cancella tutta la lista di parole
	 */
	public void clearDictionary() {
		words.clear();
	}
	
	public String printWords() {
		String s = "";
		for(Word w : words) {
			s += w.toString();
		}
		return s;
	}
}
