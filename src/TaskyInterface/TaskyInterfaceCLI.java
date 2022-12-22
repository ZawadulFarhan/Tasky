package TaskyInterface;

import java.util.List;
import java.util.Scanner;

import Task.Task;

//CLI implementation of the user interface
public class TaskyInterfaceCLI implements TaskyInterface{
	int cell = 15;
	int padding = 3;
	
	//prints " " n times
	private void printWhiteSpace(int n) {
		for(int i=0; i<n; i++) {
			System.out.print(" ");
		}
	}
	
	//prints text in cell and fills remaining space with whitespace. type is for alignment. 1 for left, 2 for center and 3 for right
	private void printCell(String s, int type) {
		int startWhiteSpace = 0;
		int endWhiteSpace = 0;
		
		switch(type) {
			case 1:
				endWhiteSpace = cell-s.length();
				break;
			case 2:
				startWhiteSpace = (cell-s.length())/2 ;
				endWhiteSpace = (cell-s.length())/2 + (cell-s.length())%2;
				break;
			case 3:
				startWhiteSpace = cell-s.length();
				break;
		}
		
		printWhiteSpace(startWhiteSpace);
		System.out.print(s);
		printWhiteSpace(endWhiteSpace);
	}
	
	//draw a solid dash line of size n
	private void printSolidDash(int n) {
		for(int i=0; i<n; i++) {
			System.out.print("_");
		}
		System.out.println();
	}
	
	//prints headers of task list
	private void printHeaders() {
		printWhiteSpace(padding);
		printCell("Index", 1);
		printCell("Date", 1);
		printCell("Done?", 1);
		printCell("Description", 1);
	}
	
	//prints list of tasks in the body
	private void printBody(List<Task> toDoList) {
		int i = 1;
		for(Task t: toDoList) {
			printWhiteSpace(padding);
			printCell(Integer.toString(i) + ".", 1);
			printCell(t.getDate().toString(), 1);
			if(t.isCompleted()) {
				printCell("Done", 1);
			} else {
				printCell("no :(",1);
			}
			System.out.println(t.getDescription());
			i++;
		}
	}
	
	@Override
	public void sayHello() {
		System.out.println("Welcome to Tasky.exe v0.0001\n"
				+ "Thank you for giving this lightweight task management tool a chance :)\n\n"
				+ "<3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3\n\n"
				+ "Add Command:     a [tasktype](optional) [date] [description of task]\n"
				+ "example: a 12Dec2022 do task\n"
				+ "Use this command to add a task\n"
				+ "tasktype: enter d/w/m for daily/weekly/monthly task respectively.\n"
				+ "date: format is dMMMyyyy  NOTE! MMM has to be capitalized - Jan/Mar/Jun etc\n\n"
				+ "Delete Command:     d [index]\n"
				+ "example: d 1\n"
				+ "Use this command to delete a task\n"
				+ "index: provide index for task as shown in task list\n\n"
				+ "Completed Commnd:     c [index]\n"
				+ "example: c 1\n"
				+ "Use this command to mark a task as complete\n"
				+ "index: provide index for task as shown in task list\n\n"
				+ "Exit Commnd:     e\n"
				+ "Use this command to leave the program\n\n"				
				+ "<3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3 <3\n");
	}
	
	@Override
	public String promptCommand() {
		System.out.println("Enter command: ");
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		return s.nextLine();
	}

	@Override
	public void showTasks(List<Task> toDoList) {
		int len = 5*cell + padding;
		
		System.out.println();
		printSolidDash(len);
		
		System.out.println();
		printHeaders();
		
		System.out.println();
		printSolidDash(len);
		
		System.out.println();
		printBody(toDoList);
		
		System.out.println();
		printSolidDash(len);
		System.out.println();
	}
	
	@Override
	public void sayGoodBye() {
		System.out.println("\nThank you, see you again!");
	}
}