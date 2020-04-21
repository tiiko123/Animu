package com.animu;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class Archivos {



    public void abrir(){
        JFileChooser fc=new JFileChooser();
        Component contentPane = null;
        int seleccion=fc.showOpenDialog(contentPane);


        if(seleccion==JFileChooser.APPROVE_OPTION){
            File fichero=fc.getSelectedFile();

            try (FileInputStream file = new FileInputStream(new File(fichero.getAbsolutePath()))) {
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
                        cell = cellIterator.next();
                        try{

                            System.out.println(cell.getStringCellValue());
                        }catch (Exception e){

                            System.out.println(cell.getNumericCellValue());
                            System.out.println("no imprimio nada");
                        }

                    }



                }
            } catch (Exception e) {

            }

        }
    }

    public ArrayList<Cuentas>  cargarCuentas() throws IOException {
        URL ruta;
        String usuario,password,intentos;
        ArrayList<Cuentas> cuentas = new ArrayList<>();
        ruta = getClass().getResource("/Txt/Cuentas.txt");
        BufferedReader bf = new BufferedReader(new FileReader(String.valueOf(ruta).substring(6,String.valueOf(ruta).length())));
        String bfRead;
        while((bfRead = bf.readLine())!= null){
            usuario = bfRead.substring(bfRead.indexOf(""),bfRead.indexOf("#"));
            password = bfRead.substring(bfRead.indexOf("#")+1,bfRead.indexOf("$"));
            intentos = bfRead.substring(bfRead.indexOf("$")+1,bfRead.length());
            cuentas.add(new Cuentas(usuario,password,intentos));
        }
        return cuentas;
    }

    public void registrarCuenta(ArrayList<Cuentas> cuentas) throws IOException {
        URL ruta;
        ruta = getClass().getResource("/Txt/Cuentas.txt");
        BufferedWriter bf = new BufferedWriter(new FileWriter(String.valueOf(ruta).substring(6,String.valueOf(ruta).length())));
        for(int i = 0; i < cuentas.size();i++){
            bf.write(cuentas.get(i).getUsuario()+"#"+cuentas.get(i).getPassword()+"$"+cuentas.get(i).getIntentos()+"\n");
        }
        bf.close();
    }
}
