package progexam.demo.AJAX;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AJAXstudent {

    Long id;
    String name;
    String eMail;
    Long supervisor;


    public AJAXstudent() {

    }

    public void setId(Long id){
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public Long getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Long supervisor) {
        this.supervisor = supervisor;
    }


}
