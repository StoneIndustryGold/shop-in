package shopIn.pojo;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import shopIn.Sex;

public class Users {
    private Integer id ;
    @Pattern(regexp = "[0-9a-zA-Z-_]{2,64}", message ="2~64位，仅限数字字母、连字符-、下划线_")
    private String username;
    @Pattern(regexp = "[\\p{Digit}\\p{Alpha}\\p{Punct}]{6,64}", message ="6~64位，仅限数字字母、英文标")
    private String password;
    @NotNull
    private Sex sex ;
    @Max(120)
    private Integer age_id ;
    @Size(min=2,max=64,message="2~64字")
    private String gmail;
    
    private Boolean enabled;
    
    private String images;
    
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
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
    
    
}
