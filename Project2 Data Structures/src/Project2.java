import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;


//In this project, Project2 class should handle all the input from users. This class is the entrance of
//the program.
public class Project2 {
	private static MVPolyTable Table = new MVPolyTable();
	
	public static void main(String[] args) {
		String input = "";
		Scanner s = new Scanner(System.in);
		input = s.nextLine();
		StringTokenizer st = new StringTokenizer(input);
		String test = st.nextToken();
	
		switch (test) {
			case "INSERT": insert(input.substring(6));
			break;
			case "DELETE": delete(input.substring(6));
			break;
			case "UPDATE": update(input.substring(6));
			break;
			case "SEARCH": search(input.substring(6));
			break;
			case "QUIT": quit();
			break;
			default: System.out.println("Neither ");
		}
    }
	
	public static void insert(String input) {
		Table.insert(input);
	}
	public static void delete(String input) {
		Table.delete(input);
	}
	public static void update(String input) {
		Table.update(input);
	}
	public static void search(String input) {
		Table.search(input);
	}
	public static void quit() {
		Table.quit();
	}
}
