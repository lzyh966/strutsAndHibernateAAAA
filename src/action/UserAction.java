package action;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import model.User;
import service.UserService;
import service.serviceImpl.UserServiceImpl;

public class UserAction extends ActionSupport{
	private User user;
	
	private File photo;
	
	private String photoFileName;
	
	
	/**
	 * 注册
	 * @return
	 */
	public String regist() {
		if (photo == null) {
			addFieldError("photoErrMsg", "必须上传照片文件");
			return INPUT;
		} else {
			// 待上传文件的保存路径字符串
			String pathStr = ServletActionContext.getServletContext().getRealPath("/upload");
			// 上传后的文件destFile。文件名 =	pathStr + 待上传文件的名字	
			File destFile = new File(pathStr, photoFileName);
			try {
				FileUtils.copyFile(photo, destFile);
				
				user.setPhotoFileName(photoFileName);
				
				UserService userService = new UserServiceImpl();
				userService.save(user);
				
				Map session = ActionContext.getContext().getSession();
				session.put("user", user);
				
				
			} catch (IOException e) {
				System.out.print("上传照文件失败");
			}
		}
		
		return SUCCESS;
	}
	
	
	/**
	 * 登录
	 * @return
	 */
	public String login() {
		String name = user.getUserName();
		String pswd = user.getPassword();
		
		UserService userService = new UserServiceImpl();
		
		User u = userService.findByNameAndPswd(name, pswd);
		
		if (u == null) {
			addFieldError("errMsg", "用户名或密码不正确");
			return INPUT;
		}else {
			Map session = ActionContext.getContext().getSession();
			session.put("user", u);
			
			return SUCCESS;
		}
	}

	
	/**
	 * 注销
	 * @return
	 */
	public String logout() {
		Map  session = ActionContext.getContext().getSession();
		if (session.get("user") != null) {
			session.remove("user");
		}
		return INPUT;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}
}
