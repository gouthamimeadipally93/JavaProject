package com;


import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
public class Assignment2 {
	
 public static void main(String args[]) {
	String folder_path="",month_name="";
    List<String> fileNames = new ArrayList<>();
    List<Items> items = new ArrayList<>();
    System.out.println("Please give the folder path");
    try (Scanner sc=new Scanner(System.in)){
   
	 folder_path=sc.next();
	   
     DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(folder_path));
     
     for (Path path : directoryStream) {
    	 int i=0;
       fileNames.add(path.toString());
       
       FileTime time=(FileTime) Files.getAttribute(path, "creationTime");
      
       String arr[]=String.valueOf(time).split("-");
      
       int month=Integer.parseInt(arr[1])-1;
       month_name=(new DateFormatSymbols().getMonths()[month]);
       month_name= month_name.substring(0,3);
       
       items.add(new Items(new File(path.toString()), month_name,i++));
       
     }
    
     
   } catch (IOException ex) {
	   ex.printStackTrace();
   }
   System.out.println("Total File Count:"+fileNames.size());
   System.out.print("Month wise created count:");
   Map<String, Long> counting = items.stream().collect(
           Collectors.groupingBy(Items::getMonth, Collectors.counting()));

   System.out.println(counting);


 }
 }
class Items{

private File file;
private int count;
private String month;

public Items(File file,String  month,int count) {
	this.month=month;
	this.file=file;
	this.count=count;
}

public File getFile() {
	return file;
}

public void setFile(File file) {
	this.file = file;
}

public int getCount() {
	return count;
}

public void setCount(int count) {
	this.count = count;
}

public String getMonth() {
	return month;
}

public void setMonth(String month) {
	this.month = month;
}



}

