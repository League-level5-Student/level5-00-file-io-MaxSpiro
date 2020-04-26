package _03_To_Do_List;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 *
	 * When add task is clicked:
	 * 		Create a JOptionPane to ask the user for a task and add it to an ArrayList
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		Create a JOptionPane to prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Create a JOptionPane to Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list. 
	 */
	private static ArrayList<String> list = new ArrayList<String>();
	private final static String defaultLocation = "src/_03_To_Do_list/listFile.txt";
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
	}
	public static void addTask() {
		String s = JOptionPane.showInputDialog("Give me a task");
		list.add(s);
	}
	public static void viewTasks() {
		String s = "";
		for(int i =0;i<list.size()-1;i++) s+= list.get(i)+", ";
		JOptionPane.showMessageDialog(null, s+list.get(list.size()-1)+".");
	}
	public static void removeTask() {
		int i = Integer.parseInt(JOptionPane.showInputDialog("Which task do you want to remove?"));
		list.remove(i-1);
	}
	public static void saveList() {
		try {
			FileWriter fw = new FileWriter("src/_03_To_Do_list/listFile.txt");
			for(String s : list) {
				fw.write(s+"\n");
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void loadList() {
		String location = JOptionPane.showInputDialog("Where do you want to load the list from?");
		if(location.equals(defaultLocation)) location = defaultLocation;
		try {
			BufferedReader br = new BufferedReader(new FileReader(location));
			String line = br.readLine();
			while(line!=null) {
				list.add(line);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}

