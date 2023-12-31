package trie;

public class TrieNodeWithIndex {
	private TrieNodeWithIndex[] trieNodeWithIndices;
	private boolean isWord;
	private Character character;

	public TrieNodeWithIndex() {
		init();
	}

	public TrieNodeWithIndex(Character character) {
		this.character = character;
		init();
	}

	private void init() {
		trieNodeWithIndices = new TrieNodeWithIndex[26];
		for (int i = 0; i < 26; i++) {
			trieNodeWithIndices[i] = null;
		}
	}

	public TrieNodeWithIndex[] getTrieNodeWithIndices() {
		return trieNodeWithIndices;
	}

	public void setTrieNodeWithIndices(TrieNodeWithIndex[] trieNodeWithIndices) {
		this.trieNodeWithIndices = trieNodeWithIndices;
	}

	public boolean isWord() {
		return isWord;
	}

	public void setWord(boolean word) {
		isWord = word;
	}

	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	public void insertWord(String word, TrieNodeWithIndex trieNodeWithIndex) {
		TrieNodeWithIndex tni = trieNodeWithIndex;
		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';
			if (tni.getTrieNodeWithIndices()[i] == null) {
				tni.getTrieNodeWithIndices()[i] = new TrieNodeWithIndex(word.charAt(i));
			}
			tni = tni.getTrieNodeWithIndices()[i];
		}
		tni.setWord(true);
	}

	public boolean findWord(String word, TrieNodeWithIndex trieNodeWithIndex) {
		TrieNodeWithIndex trie = trieNodeWithIndex;
		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';
			TrieNodeWithIndex tr = trie.getTrieNodeWithIndices()[index];
			if (tr == null) {
				return false;
			}
			trie = trie.getTrieNodeWithIndices()[index];
		}
		return trie.isWord;
	}
}
