package com.deloitte.Patyal.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This class is the bean class for the Task Entity. It has the attributes
 * related to the Task Entity and the constructors for creating an object for
 * that class.
 * 
 * @author Billy Jacob
 * @version %I%, %G%
 * @since 1.0
 */
@Entity
@Table
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer taskId;
	@Column
	private String taskName;
	@Column
	private String description;
	@Column
	private Date date;
	@Column
	private int priority;
	@Column
	private boolean completed;
	@Column
	private int userId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Task() {

	}

	public Task(int taskId, String taskName, String description, Date date, int priority, boolean completed,
			int userId) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.description = description;
		this.date = date;
		this.priority = priority;
		this.completed = completed;
		this.userId = userId;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

}