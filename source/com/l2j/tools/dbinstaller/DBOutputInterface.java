package com.l2j.tools.dbinstaller;

import java.sql.Connection;
/**
 * @author Konstantinos
 */

public interface DBOutputInterface {
    public void setProgressIndeterminate(boolean value);
	
	public void setProgressMaximum(int maxValue);
	
	public void setProgressValue(int value);
	
	public void setFrameVisible(boolean value);
	
	public void appendToProgressArea(String text);
	
	public Connection getConnection();
	
	public int requestConfirm(String title, String message, int type);
	
	public void showMessage(String title, String message, int type);
}
