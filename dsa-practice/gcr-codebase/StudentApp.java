// Node class
class StudentNode {
    int rollNo;
    String name;
    int age;
    char grade;
    StudentNode next;

    StudentNode(int rollNo, String name, int age, char grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

// Linked List class
class StudentManager {
    private StudentNode head;

    public void addAtBeginning(int rollNo, String name, int age, char grade) {
        StudentNode newNode = new StudentNode(rollNo, name, age, grade);
        newNode.next = head;
        head = newNode;
    }

    public void addAtEnd(int rollNo, String name, int age, char grade) {
        StudentNode newNode = new StudentNode(rollNo, name, age, grade);

        if (head == null) {
            head = newNode;
            return;
        }

        StudentNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void deleteByRollNo(int rollNo) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.rollNo == rollNo) {
            head = head.next;
            return;
        }

        StudentNode temp = head;
        while (temp.next != null && temp.next.rollNo != rollNo) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Student not found");
        } else {
            temp.next = temp.next.next;
        }
    }

    public void searchByRollNo(int rollNo) {
        StudentNode temp = head;
        while (temp != null) {
            if (temp.rollNo == rollNo) {
                System.out.println(
                    temp.rollNo + " | " +
                    temp.name + " | " +
                    temp.age + " | " +
                    temp.grade
                );
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found");
    }

    public void updateGrade(int rollNo, char newGrade) {
        StudentNode temp = head;
        while (temp != null) {
            if (temp.rollNo == rollNo) {
                temp.grade = newGrade;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found");
    }

    public void displayAll() {
        StudentNode temp = head;
        if (temp == null) {
            System.out.println("No records");
            return;
        }

        while (temp != null) {
            System.out.println(
                temp.rollNo + " | " +
                temp.name + " | " +
                temp.age + " | " +
                temp.grade
            );
            temp = temp.next;
        }
    }
}

// ❗ Class name is NOT Main, but it HAS main method
public class StudentApp {
    public static void main(String[] args) {

        StudentManager sm = new StudentManager();

        sm.addAtBeginning(101, "Ankit", 20, 'A');
        sm.addAtEnd(102, "Ravi", 21, 'B');
        sm.addAtEnd(103, "Neha", 19, 'A');

        sm.displayAll();

        sm.searchByRollNo(102);
        sm.updateGrade(102, 'A');
        sm.deleteByRollNo(101);

        System.out.println("After updates:");
        sm.displayAll();
    }
}
