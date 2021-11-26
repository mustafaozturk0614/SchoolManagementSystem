package com.mustafa.oztruk.sms.main;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.mustafa.oztruk.sms.CivilStatus;
import com.mustafa.oztruk.sms.Days;
import com.mustafa.oztruk.sms.Gender;
import com.mustafa.oztruk.sms.Lecture;
import com.mustafa.oztruk.sms.Lesson;
import com.mustafa.oztruk.sms.Officer;
import com.mustafa.oztruk.sms.PersonName;
import com.mustafa.oztruk.sms.School;
import com.mustafa.oztruk.sms.Student;
import com.mustafa.oztruk.sms.Teacher;
import com.mustafa.oztruk.sms.Worker;
import com.mustafa.oztruk.sms.utils.BAUtils;

/*
 * Okul Yönetim Sistemi
 * 1-Çalışan Ana sınıfından Öğretmen,Memur ve Hizmet Görevlisi alt sınıfları
 * Oluşturuldu
 * 2-Öğrenci Ve Ders Sınıfları Oluşturuldu
 * 3-Her dersin bir ana öğretmeni ve bir yedek öğretmeni ve 1 den çok öğrencisi
 * bulumkatadır.
 * 4- Ana Menü de öncelikli olarak
 * 5-createEmployee() metodu ile çalışan sınıflarından objeler metodun
 * içerisinde
 * oluşturuldu.
 * 6-creatLecture() metodu ile dersler objeleri yaratıldı ve öğretmenleri
 * atandı.
 * studentAssigment() metodu ile öğrenci nesneleri yaratıldı ve derslere atandı
 * 7-Listele menüsünde ise ana menü de yarattığımız nesnelerin özelleiklerini
 * kullanarak listeleme yapılmaktadır.
 * 8-employeeLİst() metodu ile Şuan hali hazırda çalışanların listeleme işlemi
 * yapıldı
 * 9-oldEmployeeLİst(); metodu ile işten ayrılmış eski çalışanların listelemerli
 * yapıldı
 * 10-lectureList(); metodu ile oluşturulan dersleri alan öğrencilerin bilgileri
 * getirildi
 * 11- lecturesOfStudent(); metodu ile bir öğrencinin hangi dersleri aldığı
 * bilgis
 * getirildi
 * 12- presentList(); metodu ile işlem yapılan ayda doğum günü bulunan
 * çalışanların
 * listesi getirildi
 * 13-salaryList(); metodu ile çalışanları ücret bilgileri getirildi (hangi
 * tarihde
 * işe başlamış başlangıç maaşı kaç kere zam aldığı ve son maaşı)
 */
public class SchoolManager {
	
	School school = new School();
	
	public void menu() {
		boolean isCreateClass = false;
		boolean isCreateEmployee = false;
		boolean isAssignmentStudent = false;
		
		HashMap<Integer, String> menuItems = new HashMap<Integer, String>();
		HashMap<Integer, String> menuItems2 = new HashMap<Integer, String>();
		
		System.out.println("====ANA MENÜ====\n");
		System.out.println("Lütfen Önce Çalışan Yaratma İle Başlayınız\n");
		menuItems.put(1, "Çalışan Yaratma");
		menuItems.put(2, "Yeni Ders Yaratma");
		menuItems.put(3, "Öğrenci Atama");
		menuItems.put(4, "Bir sonraki Menüye geç ");
		menuItems.put(99, "Çıkış");
		
		do {
			
			int chose = BAUtils.menu(menuItems);
			
			switch (chose) {
				case 1:
					isCreateEmployee = createEmployee();
					System.out.println("Çalışanlar yaratıldı");
					
					break;
				case 2:
					if (isCreateEmployee) {
						isCreateClass = creatLecture();
						System.out.println("Dersler yaratıldı");
					} else {
						isCreateEmployee = createEmployee();
						isCreateClass = creatLecture();
						System.out.println("Çalışanlar Ve Dersler Yaratıldı");
					}
					
					break;
				case 3:
					try {
						isAssignmentStudent = studentAssigment();
						System.out.println("Öğrencile sınıflara atandı");
					} catch (Exception e) {
						System.err
								.println("lütfen Önce Dersleri Yaratınız MEnüden Sırayla 1 ve 2 ci işlemleri yapınız");
					}
					
					break;
				case 4:
					if (isAssignmentStudent == true && isCreateClass == true && isCreateEmployee == true) {
						do {
							System.out.println("\n\n====Listeleme Menüsü====\n\n");
							menuItems2.put(5, "Çalşan listesi");
							menuItems2.put(6, "Eski Çalışan Listesi");
							menuItems2.put(7, "Sınıf Listesi");
							menuItems2.put(8, "Öğrencinin Katıldığı Sınıflar");
							menuItems2.put(9, "Hediye Listesi");
							menuItems2.put(10, "Maaş Listesi");
							menuItems2.put(99, "Çıkış");
							int input = BAUtils.menu(menuItems2);
							switch (input) {
								case 5:
									employeeLİst();
									
									break;
								case 6:
									
									oldEmployeeLİst();
									break;
								case 7:
									
									lectureList();
									
									break;
								case 8:
									
									lecturesOfStudent();
									
									break;
								case 9:
									
									presentList();
									break;
								case 10:
									salaryList();
									break;
								case 99:
									System.exit(0);
									break;
								default:
									break;
							}
						} while (BAUtils.wantToEnd(
								"Bir üst menüye dönmek için herhan gi bir tuşa basınız Çıkmak için 'Q' tuşusna basınız",
								"q"));
						
					} else {
						System.err.println("lÜTFEN MENÜDE Kİ İŞLEMLERİ SIRAYLA YAPINIZ");
						menu();
					}
					break;
				case 99:
					System.exit(-1);
					
				default:
					break;
			}
			
		} while (BAUtils.wantToEnd("Devam etmek için herhangi bir tuşa basınız Çıkmak için q tuşuna", "q"));
		
	}
	
	private void lecturesOfStudent() {
		
		Set<Map.Entry<String, Student>> classSet = school.getSutudents().entrySet();
		for (Entry<String, Student> entry : classSet) {
			Student student = entry.getValue();
			
			System.out.println(student.getName());
			student.printlist();
			System.out.println("------------------------");
			
		}
	}
	
	private void oldEmployeeLİst() {
		for (int i = 0; i < school.getEmployees().size(); i++) {
			if (school.getEmployees().get(i).getdateOfFinish() != null) {
				
				System.out.println(school.getEmployees().get(i).toString());
			}
		}
		
	}
	
	private void salaryList() {
		System.out.println("\t\t=--------------------=");
		System.out.println("\t\t=***MAAŞ ÇİZELGESİ***=");
		System.out.println("\t\t=--------------------=\n");
		for (int i = 0; i < school.getEmployees().size(); i++) {
			long month = school.getEmployees().get(i).getDateOfStart().getMonth().getValue();
			long year = school.getEmployees().get(i).getDateOfStart().until(LocalDate.now(), ChronoUnit.MONTHS);
			int mod = Math.round(year / 6);
			double salary = school.getEmployees().get(i).getSalary();
			for (int j = 0; j < mod; j++) {
				if (school.getEmployees().get(i).getRegistrationNumber().contains("Ö")) {
					
					salary = salary + (salary = school.getEmployees().get(i).getSalary() * 1 / 10);
					
				} else if (school.getEmployees().get(i).getRegistrationNumber().contains("M")) {
					
					salary = salary + (salary = school.getEmployees().get(i).getSalary() * 9 / 100);
					
				} else {
					
					salary = salary + (salary = school.getEmployees().get(i).getSalary() * 8.5 / 10);
					
				}
			}
			System.out.println("İşlem Tarihi= " + LocalDate.now());
			System.out.println("Çalıştığı Birim= " + school.getEmployees().get(i).getClass().getSimpleName());
			
			System.out.println(school.getEmployees().get(i).getName().getName() + " "
					+ school.getEmployees().get(i).getName().getSurName());
			
			System.out.println("İşe başlama tarihi= " + school.getEmployees().get(i).getDateOfStart());
			
			System.out.println("İlk maaş= " + school.getEmployees().get(i).getSalary());
			System.out.println("Kaçkere Zam Aldığı= " + mod);
			System.out.println("Son maaş= " + salary);
			System.out.println("-----------------------------------------");
			
		}
	}
	
	private void presentList() {
		int count = 1;
		Month month = LocalDate.now().getMonth();
		System.out.println("\t" + month + " Ayı Hediye Listesi");
		for (int i = 0; i < school.getEmployees().size(); i++) {
			if (school.getEmployees().get(i).gender == Gender.WOMAN) {
				if (school.getEmployees().get(i).getBitrhday().getMonth().equals(month)) {
					System.out.println(count + "-" + school.getEmployees().get(i).getName().getName() + " "
							+ school.getEmployees().get(i).getName().getSurName());
					count++;
				}
			}
			if (school.getEmployees().get(i).getDateOfStart().getMonth().equals(month)) {
				System.out.println(count + "-" + school.getEmployees().get(i).getName().getName() + " "
						+ school.getEmployees().get(i).getName().getSurName());
				count++;
			}
			
		}
	}
	
	private boolean studentAssigment() {
		
		Student student1 = new Student(new PersonName("Hüsamettin", "Cindoruk"), Gender.MAN,
				LocalDate.parse("2000-12-12"));
		student1.setStartDate(LocalDate.parse("2020-09-09"));
		student1.addTelephoneNumber(555);
		student1.addTelephoneNumber(556);
		student1.addTelephoneNumber(156);
		student1.addLectures(school.getLectures().get(Lesson.HISTORY));
		school.getLectures().get(Lesson.HISTORY).getStudentsOfLecture().add(student1);
		student1.addLectures(school.getLectures().get(Lesson.LITERATURE));
		school.getLectures().get(Lesson.LITERATURE).getStudentsOfLecture().add(student1);
		student1.addLectures(school.getLectures().get(Lesson.MATH));
		school.getLectures().get(Lesson.MATH).getStudentsOfLecture().add(student1);
		school.getSutudents().put(student1.getRegistrationNumber(), student1);
		Student student2 = new Student(new PersonName("Şakir", "Çakır"), Gender.MAN, LocalDate.parse("1998-10-10"));
		student2.setStartDate(LocalDate.parse("2020-09-09"));
		student2.addTelephoneNumber(555);
		student2.addTelephoneNumber(556);
		student2.addTelephoneNumber(156);
		student2.addLectures(school.getLectures().get(Lesson.HISTORY));
		school.getLectures().get(Lesson.HISTORY).getStudentsOfLecture().add(student2);
		student2.addLectures(school.getLectures().get(Lesson.LITERATURE));
		school.getLectures().get(Lesson.LITERATURE).getStudentsOfLecture().add(student2);
		student2.addLectures(school.getLectures().get(Lesson.MATH));
		school.getLectures().get(Lesson.MATH).getStudentsOfLecture().add(student2);
		school.getSutudents().put(student2.getRegistrationNumber(), student2);
		Student student3 = new Student(new PersonName("Safiye", "Tendürek"), Gender.WOMAN,
				LocalDate.parse("1999-05-25"));
		student3.setStartDate(LocalDate.parse("2019-09-07"));
		student3.addTelephoneNumber(560);
		student3.addTelephoneNumber(561);
		student3.addTelephoneNumber(160);
		student3.addLectures(school.getLectures().get(Lesson.LITERATURE));
		school.getLectures().get(Lesson.LITERATURE).getStudentsOfLecture().add(student3);
		student3.addLectures(school.getLectures().get(Lesson.SCIENCE));
		school.getLectures().get(Lesson.SCIENCE).getStudentsOfLecture().add(student3);
		student3.addLectures(school.getLectures().get(Lesson.MATH));
		school.getLectures().get(Lesson.MATH).getStudentsOfLecture().add(student3);
		school.getSutudents().put(student3.getRegistrationNumber(), student3);
		Student student4 = new Student(new PersonName("Juliet", "Nelson"), Gender.WOMAN, LocalDate.parse("2001-05-25"));
		student4.setStartDate(LocalDate.parse("2020-09-09"));
		student4.addTelephoneNumber(570);
		student4.addTelephoneNumber(571);
		student4.addTelephoneNumber(170);
		student1.addLectures(school.getLectures().get(Lesson.LITERATURE));
		school.getLectures().get(Lesson.LITERATURE).getStudentsOfLecture().add(student4);
		student4.addLectures(school.getLectures().get(Lesson.SCIENCE));
		school.getLectures().get(Lesson.SCIENCE).getStudentsOfLecture().add(student4);
		student4.addLectures(school.getLectures().get(Lesson.MATH));
		school.getLectures().get(Lesson.MATH).getStudentsOfLecture().add(student4);
		student4.addLectures(school.getLectures().get(Lesson.HISTORY));
		school.getLectures().get(Lesson.HISTORY).getStudentsOfLecture().add(student4);
		school.getSutudents().put(student4.getRegistrationNumber(), student4);
		return true;
		
	}
	
	private void lectureList() {
		HashMap<Integer, String> menuItems = new HashMap<Integer, String>();
		menuItems.put(1, "Tarih dersi alan Öğrenciler");
		menuItems.put(2, "MAtematik dersi alan Öğrenciler");
		menuItems.put(3, "Edebiyat dersi alan Öğrenciler");
		menuItems.put(4, "Fen dersi alan Öğrenciler");
		do {
			
			int chose = BAUtils.menu(menuItems);
			
			switch (chose) {
				case 1:
					System.out.println("\t\tTarih dersi alan Öğrenciler".toUpperCase());
					
					school.getLectures().get(Lesson.HISTORY).getStudentsOfLecture().forEach(System.out::println);
					
					break;
				case 2:
					System.out.println("\t\tMatematik dersi alan Öğrenciler".toUpperCase());
					school.getLectures().get(Lesson.MATH).getStudentsOfLecture().forEach(System.out::println);
					break;
				
				case 3:
					System.out.println("\t\tEdebiyat dersi alan Öğrenciler".toUpperCase());
					school.getLectures().get(Lesson.LITERATURE).getStudentsOfLecture().forEach(System.out::println);
					
					break;
				case 4:
					System.out.println("\t\tFen dersi alan Öğrenciler".toUpperCase());
					school.getLectures().get(Lesson.SCIENCE).getStudentsOfLecture().forEach(System.out::println);
					
					break;
				
				default:
					break;
			}
			
		} while (BAUtils.wantToEnd("çıkmak için q", "q"));
		
	}
	
	private boolean creatLecture() {
		Lecture historyLecture = new Lecture(Lesson.HISTORY, LocalTime.parse("09:00:00"), Days.MONDAY);
		historyLecture.setMasterTeacher(school.getTeachers().get("Ö-001"));
		historyLecture.setAsistanTeacher(school.getTeachers().get("Ö-002"));
		historyLecture.setLessonyear(LocalDate.now());
		
		Lecture mathLecture = new Lecture(Lesson.MATH, LocalTime.parse("10:00:00"), Days.TUESDAY);
		mathLecture.setMasterTeacher(school.getTeachers().get(0));
		mathLecture.setAsistanTeacher(school.getTeachers().get(3));
		mathLecture.setLessonyear(LocalDate.now());
		Lecture scienceLecture = new Lecture(Lesson.SCIENCE, LocalTime.parse("13:00:00"), Days.MONDAY);
		scienceLecture.setMasterTeacher(school.getTeachers().get("Ö-001"));
		scienceLecture.setAsistanTeacher(school.getTeachers().get("Ö-003"));
		scienceLecture.setLessonyear(LocalDate.now());
		Lecture literatureLecture = new Lecture(Lesson.LITERATURE, LocalTime.parse("11:00:00"), Days.WEDNESDAY);
		literatureLecture.setMasterTeacher(school.getTeachers().get("Ö-002"));
		literatureLecture.setAsistanTeacher(school.getTeachers().get("Ö-001"));
		literatureLecture.setLessonyear(LocalDate.now());
		
		school.getLectures().put(Lesson.HISTORY, historyLecture);
		school.getLectures().put(Lesson.MATH, mathLecture);
		school.getLectures().put(Lesson.SCIENCE, scienceLecture);
		school.getLectures().put(Lesson.LITERATURE, literatureLecture);
		return true;
		
	}
	
	private void employeeLİst() {
		for (int i = 0; i < school.getEmployees().size(); i++) {
			if (school.getEmployees().get(i).getdateOfFinish() == null) {
				
				System.out.println(school.getEmployees().get(i).toString());
			}
		}
		
	}
	
	private boolean createEmployee() {
		Teacher teacher1 = new Teacher(new PersonName("Mustafa", "ÖZtürk"), Gender.MAN, LocalDate.parse("1987-12-12"),
				CivilStatus.SİNGLE, 4250, LocalDate.parse("2020-11-11"));
		teacher1.addTelephoneNumber(0535);
		
		teacher1.addTelephoneNumber(0312);
		Teacher teacher2 = new Teacher(new PersonName("Tuba", "ÖZtürk"), Gender.WOMAN, LocalDate.parse("1990-11-11"),
				CivilStatus.MARIED, 500, LocalDate.parse("2018-05-12"));
		teacher2.addTelephoneNumber(0536);
		teacher2.addTelephoneNumber(03121);
		teacher2.setdateOfFinish(LocalDate.parse("2021-10-10"));
		Teacher teacher3 = new Teacher(new PersonName("Derya", "ÖZtürk"), Gender.WOMAN, LocalDate.parse("1983-05-09"),
				CivilStatus.MARIED, 5200, LocalDate.parse("2017-10-20"));
		teacher3.addTelephoneNumber(0537);
		teacher3.addTelephoneNumber(03122);
		school.getEmployees().add(teacher1);
		school.getEmployees().add(teacher2);
		school.getEmployees().add(teacher3);
		school.getTeachers().put(teacher1.getRegistrationNumber(), teacher1);
		school.getTeachers().put(teacher2.getRegistrationNumber(), teacher2);
		school.getTeachers().put(teacher3.getRegistrationNumber(), teacher3);
		Worker worker1 = new Worker(new PersonName("Mustafa", "Gök"), Gender.MAN, LocalDate.parse("1965-08-25"),
				CivilStatus.MARIED, 2850, LocalDate.parse("2010-01-24"));
		worker1.setdateOfFinish(LocalDate.parse("2012-01-10"));
		worker1.addTelephoneNumber(0505);
		worker1.addTelephoneNumber(03131);
		
		Worker worker2 = new Worker(new PersonName("Ahmet", "Dursun"), Gender.MAN, LocalDate.parse("1980-02-02"),
				CivilStatus.MARIED, 3000, LocalDate.parse("2012-01-24"));
		
		worker2.addTelephoneNumber(0506);
		worker2.addTelephoneNumber(03132);
		Worker worker3 = new Worker(new PersonName("Mustafa", "Gök"), Gender.MAN, LocalDate.parse("1965-08-25"),
				CivilStatus.SİNGLE, 3200, LocalDate.parse("2010-01-24"));
		worker3.setdateOfFinish(LocalDate.parse("2012-01-10"));
		worker3.addTelephoneNumber(0505);
		worker3.addTelephoneNumber(03133);
		Worker worker4 = new Worker(new PersonName("Fatma", "Çal"), Gender.WOMAN, LocalDate.parse("1982-12-25"),
				CivilStatus.MARIED, 2850, LocalDate.parse("2018-08-14"));
		worker4.addTelephoneNumber(0504);
		worker4.addTelephoneNumber(03134);
		school.getEmployees().add(worker1);
		school.getEmployees().add(worker2);
		school.getEmployees().add(worker3);
		school.getEmployees().add(worker4);
		school.getWorkers().put(worker1.getRegistrationNumber(), worker1);
		school.getWorkers().put(worker2.getRegistrationNumber(), worker2);
		school.getWorkers().put(worker3.getRegistrationNumber(), worker3);
		school.getWorkers().put(worker4.getRegistrationNumber(), worker4);
		
		Officer officer1 = new Officer(new PersonName("Kemal", "Öztürk"), Gender.MAN, LocalDate.parse("1954-04-08"),
				CivilStatus.MARIED, 3000, LocalDate.parse("1980-05-10"));
		officer1.addTelephoneNumber(520);
		officer1.addTelephoneNumber(212);
		officer1.setdateOfFinish(LocalDate.parse("2007-06-12"));
		
		Officer officer2 = new Officer(new PersonName("Emre", "Dağdeviren"), Gender.MAN, LocalDate.parse("1995-11-12"),
				CivilStatus.MARIED, 4000, LocalDate.parse("2021-09-10"));
		officer2.addTelephoneNumber(521);
		officer2.addTelephoneNumber(213);
		Officer officer3 = new Officer(new PersonName("Zeliha", "Can"), Gender.WOMAN, LocalDate.parse("1992-05-19"),
				CivilStatus.MARIED, 4500, LocalDate.parse("2019-05-10"));
		officer3.addTelephoneNumber(522);
		officer3.addTelephoneNumber(214);
		school.getEmployees().add(officer1);
		school.getEmployees().add(officer2);
		school.getEmployees().add(officer3);
		school.getOfficers().put(officer1.getRegistrationNumber(), officer1);
		school.getOfficers().put(officer2.getRegistrationNumber(), officer2);
		school.getOfficers().put(officer3.getRegistrationNumber(), officer3);
		school.getTeachers().entrySet().forEach(System.out::println);
		return true;
		
	}
	
	public static void main(String[] args) {
		
		SchoolManager schoolManager = new SchoolManager();
		schoolManager.menu();
		
	}
	
	private void println(String string1, Student student2) {
	}
}
