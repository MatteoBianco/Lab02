package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class Word {
	
	private String alienWord;
	private List<String> translations = new ArrayList<>();
	
	/**Costruttore oggetto Word che associa la parola 
	 * aliena alla traduzione inglese
	 * 
	 * @param alienWord parola aliena
	 * @param translation traduzione inglese
	 */
	public Word(String alienWord, String translation) {
		this.alienWord = alienWord;
		this.translations.add(translation);
	}

	public String getAlienWord() {
		return this.alienWord;
	}

	public String getTranslations() {
		String s = "";
		for(String t : translations) {
			s += t + "; ";
		}
		return s;
	}
	
	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}

	public void setTranslation(String translation) {
		this.translations.add(translation);
	}
		
	public String toString() {
		return this.alienWord + " - " + this.getTranslations() + "\n"; 
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alienWord == null) ? 0 : alienWord.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		if (alienWord == null) {
			if (other.alienWord != null)
				return false;
		} else if (!alienWord.equals(other.alienWord))
			return false;
		return true;
	}
	

}
