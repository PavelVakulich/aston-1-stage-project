package com.aston.afspapp.rw.file;

import com.aston.afspapp.entity.Student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class StudentRWriter implements ReaderWriter<Student> {

    @Override
    public void writeToFile(List<Student> entities, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            for (Student student : entities) {
                String line = student.getGroupNumber() + "," + student.getAverageScore() + "," + student.getGradeBookNumber();
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeToFile(Student entity, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            String line = entity.getGroupNumber() + "," + entity.getAverageScore() + "," + entity.getGradeBookNumber();
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> readFromFile(String file) {
        List<Student> students = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            Student.Builder builder;
            while ((line = reader.readLine()) != null) {
                builder = new Student.Builder();
                String[] data = line.split(",");
                //todo data size validation -> index out of bound exception catch
                Integer groupNumber = Integer.parseInt(data[0]);
                //todo validation
                builder.setGroupNumber(groupNumber);
                BigDecimal averageScore = BigDecimal.valueOf(Double.parseDouble(data[1]));
                //todo validation
                builder.setAverageScore(averageScore);
                Integer gradeBookNumber = Integer.parseInt(data[3]);
                //todo validation
                builder.setGradebookNumber(gradeBookNumber);
                students.add(builder.build());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }
}
