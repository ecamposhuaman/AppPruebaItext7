package com.eich.apppruebaitext7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.File;
import java.io.FileNotFoundException;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            crearPdf();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    private void crearPdf() throws FileNotFoundException {
        String pdfPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString();
        File file = new File(pdfPath, "myPDF.pdf");
        PdfWriter writer = new PdfWriter(String.valueOf(file));
        PdfDocument pdfDocument = new PdfDocument(writer);
        Document document = new Document(pdfDocument);
        // Adding paragraphs to document
        document.add(new Paragraph("Hi. The journey commenced with a single tutorial"));
        document.close();
        Toast.makeText(this, "The PDF document has been created successfully", Toast.LENGTH_SHORT).show();
    }
}