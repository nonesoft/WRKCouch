/**
 * 
 */
package nonesoft.wrkcouch;

import java.util.Date;
import java.util.Calendar;
import nonesoft.wrkcouch.BaseUnit;
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
	private Map<Date, Object> schedule_days;
	
//-----------  Methods --------------------	
	
	protected BaseSchedule(Map<KeyDays, Date> schedule_key_days, Date last_execution_day) {
		super();
		this.schedule_key_days = schedule_key_days;
		this.last_execution_day = last_execution_day;		
	}

	protected BaseSchedule() {
		last_execution_day = new java.util.Date();
		schedule_key_days = new java.util.HashMap<KeyDays, Date>(null);
	}
		
	protected BaseSchedule(BaseSchedule oldSchedule) {
		this(oldSchedule.get_Schedule_key_days(),oldSchedule.get_Last_exec_day());		
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
	
	/**@param at start it's every time current day*/
	public void set_Last_exec_day(Date last_day) {
		this.last_execution_day = last_day;
	}	

	/**@return collection of all days which have any unit*/
	public Map<Date, Object> getSchedule_days() {
		return schedule_days;
	}

	/**@param collection of all days with units */
	public void setSchedule_days(Map<Date, Object> schedule_days) {
		this.schedule_days = schedule_days;
	}
	
	/**@param searchDate - only date format for find unit from calendar, 
	 * if don't exist then will be created a new unit and insert into calendar
	 * @return unit which is saved in calendar with current day as a key
	 * 
	 * */
	public Object getUnitFromCalendar(Date searchDate) {
		
		Object findUnit = null;		
		try {			
			if(schedule_days.containsKey(searchDate)) {
				findUnit = schedule_days.get(searchDate); 
			}
			else {
				findUnit = new Object();
				Calendar today = Calendar.getInstance();
				schedule_days.put(today.getTime(), findUnit);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return findUnit;
	}	
}
