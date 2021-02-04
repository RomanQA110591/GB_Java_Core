package ru.GB.Lesson2;

public class MyArraySizeException extends Exception {
    MyArraySizeException(String msg) {
      super(msg);
   }

    public MyArraySizeException() {

    }
}