package Task;

import java.time.LocalDate;

//for tasks that is to be done on a daily basis
public class DailyTask extends RegularTask {

	public DailyTask(LocalDate date, String description) {
		super(date, description);
	}
	
	//if tasks is completed, set new deadline to next day.
	@Override
	public void setCompleted() {
		date = date.plusDays(1);
	}
	
	//date might be set to date in the past. since task is repeated, daily task should be set to today
	@Override
	public LocalDate getDate() {
		if(date.isBefore(LocalDate.now())) {
			date = LocalDate.now();
		}
		return date;
	}
}