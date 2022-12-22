package TaskyInterface;

import java.util.List;

import Task.Task;

//an interface for the user interface. Currently only supports CLI but if GUI is to be implemented, will be done by implementing this interface
public interface TaskyInterface {
	//sends hello message to user
	void sayHello();
	//asks for a command and returns the user input as string
	String promptCommand();
	//displays list of tasks to do
	void showTasks(List<Task> toDoList);
	//prints goodbye message
	void sayGoodBye();
}
