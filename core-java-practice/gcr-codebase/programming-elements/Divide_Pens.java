public class Divide_Pens {
    public static void main(String[] args) {

        int pens = 14;   //  pens
        int students = 3;    //  students

        // Pens per student
        int pensPerStudent = pens / students;

        // Remaining pens using modulus
        int remainPens = pens % students;

        //  result
        System.out.println(
            "The Pen Per Student is " + pensPerStudent +
            " and the remaining pen not distributed is " + remainPens
        );
    }
}
