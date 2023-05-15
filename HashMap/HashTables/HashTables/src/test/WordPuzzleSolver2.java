package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import hash.HashTable;

public class WordPuzzleSolver {

	public static void main(String[] args) {
		
		/* Kick everything off by calling solve() */
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
	

	
	/* Solve the puzzle */
	private void solve(String dictFile, String gridFile) throws IOException {
			
		/* Implement this method. Open the files and solve the word puzzle!! */
		
		//puts words from dict into hashtable
		HashTable<String, String> ht = new HashTable<String, String>(10000);
		BufferedReader in = new BufferedReader(new FileReader(dictFile));
		String text = in.readLine(); // reads the next line
		while(text != null) {
			ht.insert(text, text);
			text = in.readLine();
		}
		in.close();
		
		//puts characters into a grid
		BufferedReader inGrid = new BufferedReader(new FileReader(gridFile));
		Integer rows = Integer.parseInt(inGrid.readLine());
		Integer cols = Integer.parseInt(inGrid.readLine());
		String letters = inGrid.readLine();
		inGrid.close();
		int count = 0;
		char[][] grid = new char[rows][cols];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				grid[i][j] = letters.charAt(count);
				count++;
			}
		}
		
		String[] cardinalDirections = new String[] {"N", "S", "E", "W", "NW", "NE", "SW", "SE"};
		
		// to find the words
		
		String gridString = "";
		int wordsFound = 0;
		
		for(int row = 0; row < grid.length; row ++) {
			for(int col = 0; col < grid[0].length; col++) {
				for(String direction : cardinalDirections) {
					for(int len = 3; len <= 22; len++) {
						gridString = getString(grid, row, col, direction, len);
						//System.out.println(gridString);
						if(gridString.length() == len && ht.contains(gridString)) {
							wordsFound++;
						}
					}
				}
			}
		}
		System.out.println(wordsFound + " words found");
	}
	
	private String getString(char[][] table, int col, int row, String dir, int len) {
		String retString = "";
		while(retString.length() < len && inRange(table, col, row)) {
			retString += table[col][row];
			if(dir.equals("N") || dir.equals("NW") || dir.equals("NE")) row--;
			if(dir.equals("S") || dir.equals("SW") || dir.equals("SE")) row++;
			if(dir.equals("E") || dir.equals("NE") || dir.equals("SE")) col++;
			if(dir.equals("W") || dir.equals("NW") || dir.equals("SW")) col--;
		}
		return retString;
	}
	
	private boolean inRange(char[][] table, int col, int row) {
		return((col>=0 && col<table.length) && (row>=0 && row<table[0].length));
	}
	
}