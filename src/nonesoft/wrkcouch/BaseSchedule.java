/**
 * 
 */
package nonesoft.wrkcouch;

import java.util.Date;
import java.util.Calendar;
import java.util.*;

/**
 * @author mikke
 *
 */
public abstract class BaseSchedule {
	/** Important days for schedule*/
	private Map<KeyDays, Date> schedule_key_days;
	
	/** Last day with was worked in project*/
	private Date last_execution_day;
	
	/** All days defined between start date and final date*/
	private Calendar schedule_calendar; 
	
//-----------  Methods --------------------	
	
	protected BaseSchedule(Map<KeyDays, Date> schedule_key_days, Calendar schedule_calendar, Date last_execution_day) {
		super();
		this.schedule_key_days = schedule_key_days;
		this.last_execution_day = last_execution_day;
		this.schedule_calendar = schedule_calendar;
	}

	protected BaseSchedule() {
		last_execution_day = new java.util.Date();
		schedule_key_days = new java.util.HashMap<KeyDays, Date>(null);
		set_Schedule_calendar(java.util.Calendar.getInstance());
	}
	
	
	protected BaseSchedule(BaseSchedule oldSchedule) {
		this(oldSchedule.get_Schedule_key_days(),oldSchedule.get_Schedule_calendar(),oldSchedule.get_Last_exec_day());		
	}
	
	/** @return whole list of key days*/
	public Map<KeyDays, Date> get_Schedule_key_days() {
		return schedule_key_days;
	}
	
	public void set_Schedule_key_days(Map<KeyDays, Date> schedule_key_days) {
		this.schedule_key_days = schedule_key_days;	
	}
	
	/**@return last day of execution */
	public Date get_Last_exec_day() {
		return last_execution_day;
	}
	
	/**@param   at start it's every time current day*/
	public void set_Last_exec_day(Date last_day) {
		this.last_execution_day = last_day;
	}

	/**@return java.util.Calendar but why returned it?*/
	public Calendar get_Schedule_calendar() {
		return schedule_calendar;
	}
	
	public void set_Schedule_calendar(Calendar schedule_calendar) {
		this.schedule_calendar = schedule_calendar;
	}
	
	
	
}
