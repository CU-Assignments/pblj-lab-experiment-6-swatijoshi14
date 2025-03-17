import java.util.*; 
import java.util.stream.Collectors; 
class Student { 
String name; 
int marks; 
public Student(String name, int marks) { 
this.name = name; 
this.marks = marks; 
} 
@Override 
public String toString() { 
return "Student{name='" + name + "', marks=" + marks + "}"; 
} 
} 
public class StudentFilterSort { 
public static void main(String[] args) { 
List<Student> students = Arrays.asList( 
new Student("Alice", 80), 
new Student("Bob", 65), 
new Student("Charlie", 90), 
new Student("David", 70) 
); 
List<Student> filteredSortedStudents = students.stream() 
.filter(s -> s.marks > 75) 
.sorted((s1, s2) -> Integer.compare(s2.marks, s1.marks)) 
.collect(Collectors.toList()); 
filteredSortedStudents.forEach(System.out::println); 
} 
}
