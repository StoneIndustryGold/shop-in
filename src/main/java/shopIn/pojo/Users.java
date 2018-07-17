package shopIn.pojo;

import shopIn.Sex;

public class Users {
    private Integer id ;
    private String username;
    private String password;
    private Sex sex ;
    private Integer age_id ;
    private String gmail;
    private Boolean enabled;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Sex getSex() {
		return sex;
	}
	public void setSex(Sex sex) {
		this.sex = sex;
	}
	public Integer getAge_id() {
		return age_id;
	}
	public void setAge_id(Integer age_id) {
		this.age_id = age_id;
	}
	public String getGmail() {
		return gmail;
	}
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
    
    
}
