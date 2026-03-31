import java.util.*;
class Student{
	String name;
	int age;
	String branch;
	String department;
	long regno;
	String schoolname;
	int tenthgrade;
	int twelfthgrade;
Student(String a,int b,String c,String d,long e, String f,int g,int h){
	this.name = a;
	this.age = b;
	this.branch = c;
	this.department = d;
	this.regno = e;
	this.schoolname = f;
	this.tenthgrade = g;
	this.twelfthgrade = h;
   }
}

public class miniproject{
    public static void main(String[] args) {
	 Scanner scan= new Scanner(System.in);
	 System.out.println("Enter the Student details");
	 int n = scan.nextInt();
	 scan.nextLine();
	 Student s[] = new Student[n];
	 
	 for(int i=0;i<n;i++){
		System.out.println("Enter the details of Student "+(i+1));
		String input = scan.nextLine();
		String arr[] = input.split(",");
		String a = arr[0];
                int b = Integer.parseInt(arr[1]);
                String c = arr[2];
                String d = arr[3];
                long e = Long.parseLong(arr[4]);
		String f = arr[5];
		int g = Integer.parseInt(arr[6]);
		int h = Integer.parseInt(arr[7]);
        s[i] = new Student(a,b,c,d,e,f,g,h);
	}
        System.out.println("Student Details");
        for(int i=0;i<n;i++){
            System.out.println("Name: "+ s[i].name);
            System.out.println("Age: "+ s[i].age);
            System.out.println("Branch: "+ s[i].branch);
            System.out.println("Department: "+ s[i].department);
            System.out.println("Register Number: "+ s[i].regno);
            System.out.println("School Name: "+ s[i].schoolname);
            System.out.println("Tenth Grade: "+ s[i].tenthgrade);
            System.out.println("Twelfth Grade: "+ s[i].twelfthgrade);
        }
    }
}