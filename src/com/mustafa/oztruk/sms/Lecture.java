package com.mustafa.oztruk.sms;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Lecture {
	Lesson lecturename;
	protected Teacher masterTeacher;
	protected Teacher asistanTeacher;
	protected List<Student> studentsOfLecture;
	protected LocalTime lectureHour;
	protected Days dayOflecture;
	protected long lessonTime;
	protected LocalDate lessonyear;
	
	public Lecture(Lesson lecturename, LocalTime lectureHour, Days dayOflecture) {
		super();
		this.lecturename = lecturename;
		this.lectureHour = lectureHour;
		this.dayOflecture = dayOflecture;
		studentsOfLecture = new ArrayList<Student>();
	}
	
	@Override
	public String toString() {
		return "Lecture [lecturename=" + lecturename + ", masterTeacher=" + masterTeacher + ", asistanTeacher="
				+ asistanTeacher + ", studentsOfLecture=" + studentsOfLecture + ", lectureHour=" + lectureHour
				+ ", dayOflecture=" + dayOflecture + ", lessonTime=" + lessonTime + ", lessonyear=" + lessonyear + "]";
	}
	
	public Teacher getMasterTeacher() {
		return masterTeacher;
	}
	
	public void setMasterTeacher(Teacher masterTeacher) {
		this.masterTeacher = masterTeacher;
	}
	
	public Teacher getAsistanTeacher() {
		return asistanTeacher;
	}
	
	public void setAsistanTeacher(Teacher asistanTeacher) {
		this.asistanTeacher = asistanTeacher;
	}
	
	public List<Student> getStudentsOfLecture() {
		return studentsOfLecture;
	}
	
	public void setStudentsOfLecture(Student student) {
		this.studentsOfLecture.add(student);
		
	}
	
	public LocalTime getLectureHour() {
		return lectureHour;
	}
	
	public void setLectureHour(LocalTime lectureHour) {
		this.lectureHour = lectureHour;
	}
	
	public Days getDayOflecture() {
		return dayOflecture;
	}
	
	public void setDayOflecture(Days dayOflecture) {
		this.dayOflecture = dayOflecture;
	}
	
	public Lesson getLecturename() {
		return lecturename;
	}
	
	public long getLessonTime() {
		return lessonTime;
	}
	
	public void setLessonTime(long lessonTime) {
		this.lessonTime = lessonTime;
	}
	
	public LocalDate getLessonyear() {
		return lessonyear;
	}
	
	public void setLessonyear(LocalDate lessonyear) {
		this.lessonyear = lessonyear;
	}
	
}
