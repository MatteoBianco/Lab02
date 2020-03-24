package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import it.polito.tdp.model.alien.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class FXMLController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private TextField wordTxt;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtTranslation;

    @FXML
    private Button btnReset;

    @FXML
    void doReset(ActionEvent event) {
    	model.resetDizionario();
    	txtTranslation.setText("Dizionario cancellato!");
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	String testo = wordTxt.getText();
    	StringTokenizer st = new StringTokenizer(testo);
    	if(st.countTokens() > 2 || st.countTokens() == 0) {
    		txtTranslation.setText("Inserire solo parole nel formato <parola Aliena> <traduzione>, o una <parola Aliena> di cui si vuole cercare la traduzione!");
    		wordTxt.clear();
    		return;
    	}
    	
    	if(st.countTokens() == 2) {
    	
    		String parolaAliena = st.nextToken();
    		String traduzione = st.nextToken();
    	
    		for(char c : parolaAliena.toCharArray()) {
    			if(!Character.isAlphabetic(c)) {
    				txtTranslation.setText("Inserire solo parole con caratteri alfabetici!");
    				wordTxt.clear();
    				return;
    			}
    		}
    		for(char c : traduzione.toCharArray()) {
    			if(!Character.isAlphabetic(c)) {
    				txtTranslation.setText("Inserire solo parole con caratteri alfabetici!");
    				wordTxt.clear();
    				return;
    			}
    		}
    	   		
    		model.nuovaParola(parolaAliena, traduzione);
    		txtTranslation.setText("Parola aggiunta nel dizionario: " + parolaAliena.toLowerCase() + "\nTraduzione: " + traduzione.toLowerCase());
    		wordTxt.clear();
    	}
    	
    	if(st.countTokens() == 1) {
    		
    		String parolaAliena = st.nextToken();
    		
    		for(char c: parolaAliena.toCharArray()) {
    			if(!Character.isAlphabetic(c)) {
    				txtTranslation.setText("Inserire solo parole con caratteri alfabetici!");
    				wordTxt.clear();
    				return;
    			}
    		}
    		
    		
    		String traduzione = model.traduzioneParola(parolaAliena);
    		if(traduzione == null) {
    			txtTranslation.setText("La parola " + parolaAliena.toLowerCase() + " non esiste nel dizionario!");
    			wordTxt.clear();
    			return;
    		}
    		txtTranslation.setText("La/e traduzione/i della parola " + parolaAliena + " è/sono: " + traduzione);
    		wordTxt.clear();
    	}
    }
    
    
    @FXML
    void initialize() {

    }
    
    public void setModel(Model model) {
    	
    	this.model= model;
    }
}