/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejoarchvios;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TxtToPdf {
    
    public static void main(String[] args) throws FileNotFoundException, DocumentException
	{
	    String linea, FileName, FileNameWithOutPath, FileNameWithPath;
	    File InFile = null;
	    FileReader fr = null;
	    BufferedReader br = null;
            
            
	    //Selecciona el archivo a convertir.
	    //FileName = SeleccionarArchivoTxt();
            FileNameWithOutPath = "Prueba";
            FileName = "Prueba.txt";
            FileNameWithPath = "C:\\Users\\yulia\\OneDrive\\Escritorio\\" + FileNameWithOutPath;
            
	    // Abre el archivo y crea el reader.
	    InFile = new File (FileNameWithPath);
	    fr = new FileReader (InFile);
            br = new BufferedReader(fr);
            
            
            //Crea el documento de salida.
            FileOutputStream archivo = new FileOutputStream( "C:\\Users\\yulia\\OneDrive\\Escritorio\\" + FileNameWithOutPath + ".pdf");  
	    Document documento = new Document();
	    PdfWriter.getInstance(documento, archivo);
	    documento.open();
            
	    try{
	          while((linea=br.readLine())!=null){
                  documento = AgregarLineaNueva(documento,linea);
            }
	    }catch(Exception e){e.printStackTrace();
	    }finally{
	         // En el finally cerramos el fichero, para asegurarnos en cualquier circunstancia.
	         try{
	            if( null != fr ){
	               fr.close();
	            }
	         }catch (Exception e2){
	            e2.printStackTrace();
	         }
	      }
            
	    //Cerramos el documento PDF.
	    documento.close();
	}

	static public Document AgregarLineaNueva(Document doc, String linea)
	{
		try{
		doc.add(new Paragraph(linea));
		}catch(DocumentException de){de.printStackTrace();}
		return doc;
	}
	
	static public String SeleccionarArchivoTxt(){
		int returnValue;
		File selectedFile = null;
		String FileName = "";
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT","txt");
		fileChooser.setFileFilter(filter);
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	        returnValue = fileChooser.showOpenDialog(null);
	        if (returnValue == JFileChooser.APPROVE_OPTION) {
			selectedFile = fileChooser.getSelectedFile();
			FileName = selectedFile.getPath();
		  }
		return FileName;
	}
}
