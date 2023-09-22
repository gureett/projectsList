import java.io.*;

public class sortArrays {
  public static String[] sortedStudent(String[] student, double[] mark) {
    // First for loop for the position of the array
    for (int i = 0; i < student.length - 1; i++) {
      // Second for loop to keep going to make sure it is all in order
      for(int j = 0; j < student.length - 1; j++) {
        // If Mark at I is less than the one next to it, it will swap
        if (mark[j] < mark[j+1]) {
          // Temp Variable
          double temp = mark[j+1];
          // Swaps
          mark[j+1] = mark[j];
          mark[j] = temp;
          // Temp Variable
          String tStudent = student[j+1];
          // Swaps
          student[j+1] = student[j];
          student[j] = tStudent;
        }
      }
    }
    return student;
  }
  public static double[] sortedMark(String[] student, double[] mark) {
    // First for loop for the position of the array
    for (int i = 0; i < student.length - 1; i++) {
      // Second for loop to keep going to make sure it is all in order
      for(int j = 0; j < student.length - 1; j++) {
        // If Mark at I is less than the one next to it, it will swap
        if (mark[j] < mark[j+1]) {
          // Temp Variable
          double temp = mark[j+1];
          // Swaps
          mark[j+1] = mark[j];
          mark[j] = temp;
          // Temp Variable
          String tStudent = student[j+1];
          // Swaps
          student[j+1] = student[j];
          student[j] = tStudent;
        }
      }
    }
    return mark;
  }
}