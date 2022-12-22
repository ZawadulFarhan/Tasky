package Task;

import java.time.LocalDate;

//for tasks to be repeated on a weekly basis
public class WeeklyTask extends RegularTask{

	public WeeklyTask(LocalDate date, String description) {
		super(date, description);
	}

	//if task is completed, set new deadline to next week.
	@Override
	public void setCompleted() {
		date = date.plusDays(7);
	}

	//date might be set to date in the past. since task is repeated, weekly task should be set to some date this week
	@Override
	public LocalDate getDate() {
		while(date.isBefore(LocalDate.now())) {
			date = date.plusDays(7);
		}
		return date;
	}
}