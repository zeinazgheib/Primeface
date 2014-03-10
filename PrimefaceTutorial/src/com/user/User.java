package com.user;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;

@ManagedBean(name="user")
@RequestScoped
public class User implements Serializable{

public User(){
	
}
	private String username;
	private String password;
	private String confirmpassword;
	private String firstname;
	private String lastname;
	private String email;
	private String phone;
	private String mobile;
	private String confirmemail;
	private String city;
	private Date dob;
	private String selectedGroup;
	
	public String getUsername() {return username;}

	public void setUsername(String username) {this.username = username;}

	public String getPassword() {return password;}

	public void setPassword(String password) {this.password = password;}

	public String getConfirmpassword() {return confirmpassword;}

	public void setConfirmpassword(String confirmpassword) {this.confirmpassword = confirmpassword;}

	public String getFirstname() {return firstname;}

	public void setFirstname(String firstname) {this.firstname = firstname;}

	public String getLastname() {return lastname;}

	public void setLastname(String lastname) {this.lastname = lastname;}

	public String getPhone() {return phone;}

	public void setPhone(String phone) {this.phone = phone;}
	
	public String getMobile() {return mobile;}

	public void setMobile(String mobile) {this.mobile = mobile;}
	
	public Date getDob() {
		return dob;}

	public void setDob(Date dob) {this.dob = dob;}

	public void handleDateSelect(SelectEvent selectEvent) throws ParseException {

        //System.out.println("inside get age");
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date date1=(Date) selectEvent.getObject();
        String dd=null;
        dd=format.format(date1);
       // System.out.println("date dd"+dd);
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dd);
        //System.out.println("date+++++++++"+date);
        Calendar birth = new GregorianCalendar();
        Calendar today = new GregorianCalendar();
        int calculatedAge = 0;
        int factor = 0;

        Date currentDate = new Date(); // current date
        Date currentDate1= new SimpleDateFormat("dd/MM/yyyy").parse(format.format(currentDate));
       // System.out.println("DOB" + dob);
        birth.setTime(date);
        //System.out.println("set birth" + birth);
        today.setTime(currentDate1);

        if (today.get(Calendar.DAY_OF_YEAR) < birth.get(Calendar.DAY_OF_YEAR)) {
            factor = -1;

        }
        calculatedAge = today.get(Calendar.YEAR) - birth.get(Calendar.YEAR) + factor;
        //System.out.println("age is " + calculatedAge);
        String calcAge = String.valueOf(calculatedAge);
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "The Age is" , calcAge);
        facesContext.addMessage("dob", facesMessage);
    }
	
	
	public String getEmail() {return email;}

	public void setEmail(String email) {this.email = email;}

	public String getConfirmemail() {return confirmemail;}

	public void setConfirmemail(String confirmemail) {this.confirmemail = confirmemail;}

	public String getCity() {return city;}

	public void setCity(String city) {this.city = city;}

	public String getSelectedGroup() {return selectedGroup;}

	public void setSelectedGroup(String selectedGroup) {this.selectedGroup = selectedGroup;}


}
