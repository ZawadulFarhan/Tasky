package Task;

import java.time.LocalDate;

//basic object for a task. It stores a description and a date as the deadline. a boolean value determines if task is complete. Task is sortable by date
public class Task implements Comparable<Task> {
	LocalDate date;
	String description;
	boolean completed;
	
	public Task(LocalDate date, String description) {
		this.date = date;
		this.description = description;
		this.completed = false;
	}
	
	public Task(String description) {
		this(LocalDate.now(), description);
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted() {
		this.completed = true;
	}

	@Override
	public int compareTo(Task o) {
		return this.getDate().compareTo(o.getDate());
	}	
}