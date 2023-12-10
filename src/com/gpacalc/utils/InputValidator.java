package com.gpacalc.utils;

public class InputValidator {

  public static boolean isValidInteger(String inputValue) {
    try {
      int value = Integer.parseInt(inputValue);
      return value >= 0;
    } 
    
    catch (NumberFormatException e) {
      return false;
    }
    
 
  }


  public static boolean isValidCourseScore(int courseScore) {
    return courseScore >= 0 && courseScore <= 100;
  }

  public static boolean isValidCourseNameAndCode(String courseName) {
    return courseName.matches("[A-Za-z]{3} \\d{3}") && courseName != null && !courseName.trim().isEmpty();
  }

 

 

}
