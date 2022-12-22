package Task;

import java.time.LocalDate;

//abstract class for tasks that have to be repeated on a regular basis. Example: wash car weekly
//task methods are overridden for polymorphism based on subtask
abstract public class RegularTask extends Task {

	public RegularTask(LocalDate date, String description) {
		super(date, description);
	}
	
	//tasks are no longer completable. if a task is completed, date should instead be changed to the next deadline for the task.
	@Override
	public abstract void setCompleted();
	
	//task cannot be completed
	@Override
	public boolean isCompleted() {
		return false;
	}
	
	//task deadline should be next available deadline from today
	@Override
	public abstract LocalDate getDate();
}