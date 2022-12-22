package Task;

import java.time.LocalDate;

//for tasks to be repeated on a monthly basis.
public class MonthlyTask extends RegularTask{
	
	public MonthlyTask(LocalDate date, String description) {
		super(date, description);
	}
	
	//if task is completed, set new deadline to next month.
	@Override
	public void setCompleted() {
		date = date.plusMonths(1);
	}

	//date might be set to date in the past. since task is repeated, monthly task should be set to some date this month
	@Override
	public LocalDate getDate() {
		while(date.isBefore(LocalDate.now())) {
			date = date.plusMonths(7);
		}
		return date;
	}

}
