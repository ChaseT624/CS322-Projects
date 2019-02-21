import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class WebSearch {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		//Prompt user for a URL
		System.out.print("Please enter a URL: ");
		String urlString = in.next();
		//Ask the user what they're looking for 
		System.out.print("What are you looking for? ");
		String searchString = in.next();
		in.close();
		//make URL object
		try {
			URL url = new URL (urlString);
			//if URL is valid make a input stream and scanner to read the text
			InputStream urlText = url.openStream();
			Scanner urlTextScan = new Scanner (urlText);
			//make an int variable to keep track of the line number 
			//and the number of strings that match the searchString
			int lineNum = 0;
			int matches = 0;
			//Loop to read  through all the text
			while (urlTextScan.hasNext()) {
				lineNum++;
				//get the current line
				String currLine = urlTextScan.nextLine();
				//check if the current line contains the search and print it if so
				if (currLine.contains(searchString)) {
					System.out.println(lineNum + ".   " + currLine);
					matches++;
				}
			}
			//print the total number of lines containing the searchString
			System.out.println(matches + " matches.");	
			urlTextScan.close();
		}
		//if URL is invalid throw an exception
		catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
