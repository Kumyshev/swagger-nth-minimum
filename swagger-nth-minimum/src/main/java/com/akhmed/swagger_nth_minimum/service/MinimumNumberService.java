package com.akhmed.swagger_nth_minimum.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

@Service
public class MinimumNumberService {

    public Integer findMinimumNumber(String filePath, int n) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        try (FileInputStream file = new FileInputStream(filePath);
                Workbook workbook = new XSSFWorkbook(file)) {
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                Cell cell = row.getCell(0);
                numbers.add((int) cell.getNumericCellValue());
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Файл не нйден!");
        }

        quickSort(numbers, 0, numbers.size() - 1);

        return numbers.get(n - 1);
    }

    void quickSort(List<Integer> numbers, int low, int high) {
        if (low < high) {
            int pi = partition(numbers, low, high);
            quickSort(numbers, low, pi - 1);
            quickSort(numbers, pi + 1, high);
        }
    }

    int partition(List<Integer> numbers, int low, int high) {
        int pivot = numbers.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (numbers.get(j) <= pivot) {
                i++;
                int temp = numbers.get(i);
                numbers.set(i, numbers.get(j));
                numbers.set(j, temp);
            }
        }
        int temp = numbers.get(i + 1);
        numbers.set(i + 1, numbers.get(high));
        numbers.set(high, temp);
        return i + 1;
    }
}
