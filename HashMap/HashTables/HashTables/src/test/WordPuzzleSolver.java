package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import hash.HashTable;

public class WordPuzzleSolver {

	public static void main(String[] args) {
		
		try {
			Scanner in = new Scanner(System.in);
			String dicFile = in.next();
			String gridFile = in.next();
			in.close();
			new WordPuzzleSolver().solve(dicFile, gridFile);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void solve(String dictFile, String gridFile) throws IOException {
		HashTable<String, String> table = new HashTable<String, String>(10000);
		
		BufferedReader dict = new BufferedReader(new FileReader(dictFile));
		BufferedReader dimensions = new BufferedReader(new FileReader(gridFile));
		
		int wordsFound = 0;
		int charTotal = 0;
		
		Integer rows = Integer.valueOf(dimensions.readLine());
		Integer columns = Integer.valueOf(dimensions.readLine());
		String letters = dimensions.readLine();
		char[][] wordSearch = new char[rows][columns];
		
		dimensions.close();
		
		String line;
		while(true) {
			line = dict.readLine();
			if (line == null) { break; }
			table.insert(line, line);
		}
		dict.close();
		
		for(int r = 0; r < rows; r++) {
			for(int c = 0; c < columns; c++) {
				wordSearch[r][c] = letters.charAt(charTotal);
				charTotal++;
			}
		}
		
		String[] directions = new String[] {"N", "S", "E", "W", "NW", "NE", "SW", "SE"};
		
		for(int r = 0; r < wordSearch.length; r ++) {
			for(int c = 0; c < wordSearch[r].length; c++) {
				for(String d : directions) {
					for(int l = 3; l <= 22; l++) {
						String newWord = findWord(wordSearch, r, c, d, l);
						if(newWord.length() == l && table.contains(findWord(wordSearch, r, c, d, l))) {
							wordsFound++;
						}
					}
				}
			}
		}
		
		System.out.println(wordsFound + " words found");
	}

	private String findWord(char[][] table, int row, int column, String dir, int len) {
		String word = "";
		while(word.length() < len && validIndex(table, column, row)) {
			word += table[row][column];
			if(dir.equals("N") || dir.equals("NE") || dir.equals("NW")) row--;
			if(dir.equals("S") || dir.equals("SE") || dir.equals("SW")) row++;
			if(dir.equals("E") || dir.equals("NE") || dir.equals("SE")) column++;
			if(dir.equals("W") || dir.equals("NW") || dir.equals("SW")) column--;
		}
		return word;
	}
	
	private boolean validIndex(char[][] table, int row, int column) {
		return((column>=0 && column<table.length) && (row>=0 && row<table[0].length));
	}
}
