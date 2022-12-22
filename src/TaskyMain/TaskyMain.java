package TaskyMain;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import Task.*;
import TaskyInterface.*;

public class TaskyMain {
	
	static boolean exitCommand = false;
	static List<Task> toDoList = new ArrayList<>();
	
	//parses date from string. Format is of type ddMMMyyy example: 9Dec2022
	static LocalDate parseDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dMMMyyyy");
        formatter = formatter.withLocale(Locale.ENGLISH);
		return LocalDate.parse(dateString, formatter);
	}
	
	//reads through input tokens to find tasktype, date and descriptin
	static Task parseTask(String[] tokens, int index) {
		LocalDate date = LocalDate.now();
		String description;
		Task task;
		
		//check for tasktype modifiers
		switch(tokens[index].toLowerCase()) {
		//d is modifier for daily task
		case "d":
			date = parseDate(tokens[index+1]);
			description = String.join(" ", Arrays.copyOfRange(tokens, index+2, tokens.length));
			task = new DailyTask(date, description);
			break;
		//w is modifier for weekly task
		case "w":
			date = parseDate(tokens[index+1]);
			description = String.join(" ", Arrays.copyOfRange(tokens, index+2, tokens.length));
			task = new WeeklyTask(date, description);
			break;
		//m is modifier for monthly task
		case "m":
			date = parseDate(tokens[index+1]);
			description = String.join(" ", Arrays.copyOfRange(tokens, index+2, tokens.length));
			task = new MonthlyTask(date, description);
			break;
		//no moifier detected, parse for date directly
		default:
			date = parseDate(tokens[index]);
			description = String.join(" ", Arrays.copyOfRange(tokens, index+1, tokens.length));
			task = new Task(date, description);
			break;
		}
		
		return task;
		
	}
	
	//executes a command based on instructions in string
	private static void executeCommand(String s) {
		//tokenize input
		String[] tokens = s.split(" ");
		int index;

		//check first token for command type
		switch(tokens[0]) {
		//a is for adding Task
		case "a":
			toDoList.add(parseTask(tokens, 1));
			Collections.sort(toDoList);
			break;
		//e is for exiting program
		case "e":
			exitCommand = true;
			break;
		//c is for marking task as complete
		case "c":
			index = Integer.parseInt(tokens[1])-1;
			toDoList.get(index).setCompleted();
			break;
		//d is for deleting task
		case "d":
			index = Integer.parseInt(tokens[1])-1;
			toDoList.remove(index);
			Collections.sort(toDoList);
			break;
		//invalid command
		default:
			System.out.println("Invalid Command");
			break;
		}
	}
	
	
	public static void main(String[] args) {

		TaskyInterface view = new TaskyInterfaceCLI();
		
		//Print startup message
		view.sayHello();
		
		//as long as exit command not provided, keep running
		while(!exitCommand) {
			view.showTasks(toDoList);
			String s = view.promptCommand();
			try {
			executeCommand(s);
			} catch(Exception e){
				System.out.println("\n" + e.getMessage());
			}
		}
		
		//Print goodbye message
		view.sayGoodBye();
	}
}
