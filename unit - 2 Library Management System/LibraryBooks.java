import java.util.*;

abstract class LibraryBook{
String name;
String bookName;
int bookNumber;
String authorName;
LibraryBook(String a,String b,int c,String d){
this.name = a;
this.bookName = b;
this.bookNumber = c;
this.authorName = d;
}
abstract void display();
}

class englishBook extends LibraryBook{
int number;
englishBook(String a,String b,int c,String d,int e){
super(a,b,c,d);
this.number = e;
}
void display(){
System.out.println("Book Details :");
System.out.println("Name : " + name);
System.out.println("Book Name : " + bookName);
System.out.println("Book Number : " + bookNumber);
System.out.println("Author Name : " + authorName);
System.out.println("English Book Number : " + number);
}
}

class tamilBook extends LibraryBook{
int number;
tamilBook(String a,String b,int c,String d,int e){
super(a,b,c,d);
this.number = e;
}
void display(){
System.out.println("Book Details :");
System.out.println("Name : " + name);
System.out.println("Book Name : " + bookName);
System.out.println("Book Number : " + bookNumber);
System.out.println("Author Name : " + authorName);
System.out.println("Tamil Book Number : " + number);
}
}

class otherLanguageBook extends LibraryBook{
int number;
otherLanguageBook(String a,String b,int c,String d,int e){
super(a,b,c,d);
this.number = e;
}
void display(){
System.out.println("Book Details :");
System.out.println("Name : " + name);
System.out.println("Book Name : " + bookName);
System.out.println("Book Number : " + bookNumber);
System.out.println("Author Name : " + authorName);
System.out.println("Other Language Book Number : " + number);
}
}

public class LibraryBooks{
    public static void main(String[] args) {
Scanner scan = new Scanner(System.in);
System.out.println("Enter the Number");
 int ne = scan.nextInt();
scan.nextLine();
System.out.println("Enter Your Name: ");
String a = scan.nextLine();
System.out.println("Enter the Book Name: ");
String b = scan.nextLine();
System.out.println("Enter the Book Number: ");
int c = scan.nextInt();
scan.nextLine();
System.out.println("Enter the Author Name: ");
String d = scan.nextLine();
LibraryBook l;
if(ne==1){
System.out.println("Enter the English Number: ");
int e = scan.nextInt();
l = new englishBook(a,b,c,d,e);
l.display();
}
else if(ne==2){
System.out.println("Enter the Tamil Number: ");
int e = scan.nextInt();
l = new tamilBook(a,b,c,d,e);
l.display();
}
else{
System.out.println("Enter the Other Language Book Number: ");
int e = scan.nextInt();
l = new otherLanguageBook(a,b,c,d,e);
l.display();
}
}
}



