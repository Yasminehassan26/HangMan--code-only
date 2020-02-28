package eg.edu.alexu.csd.datastructure.hangman;

public interface IHangman {
	 String[] words=new String[10] ;
	
	void setDictionary(String[] words);
	/**
	* Pick a random secret word from the dictionary and returns it
	* @return secret word or null
	*/
	String selectRandomSecretWord();
	
	String guess(Character c ) throws Exception;
	
	void setMaxWrongGuesses(Integer max);

}
