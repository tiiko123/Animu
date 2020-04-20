package com.animu;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

public class CargarArchivos {



    public void abrir(){
        JFileChooser fc=new JFileChooser();
        Component contentPane = null;
        int seleccion=fc.showOpenDialog(contentPane);


        if(seleccion==JFileChooser.APPROVE_OPTION){
            System.out.println("Entra 1");
            File fichero=fc.getSelectedFile();

            try (FileInputStream file = new FileInputStream(new File(fichero.getAbsolutePath()))) {
                System.out.println("Entra 2");

                XSSFWorkbook worbook = new XSSFWorkbook(file);
                XSSFSheet sheet = worbook.getSheetAt(0);
                Iterator<Row> rowIterator = sheet.iterator();

                Row row;
                // se recorre cada fila hasta el final
                while (rowIterator.hasNext()) {
                    row = rowIterator.next();
                    Iterator<Cell> cellIterator = row.cellIterator();
                    Cell cell;

                    while (cellIterator.hasNext()) {
                        try{
                            cell = cellIterator.next();
                            System.out.println(cell.getStringCellValue());
                        }catch (Exception e){
                            cell = cellIterator.next();
                            System.out.println(cell.getNumericCellValue());
                            System.out.println("no imprimio nada");
                        }

                    }



                }
            } catch (Exception e) {

            }

        }
    }
}
