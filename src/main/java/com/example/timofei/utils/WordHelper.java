package com.example.timofei.utils;

import com.example.timofei.entity.FuelDelivery;
import com.example.timofei.entity.FuelUsage;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class WordHelper {
    public static ByteArrayInputStream generateUsage(FuelUsage fuelUsage)
            throws FileNotFoundException, IOException, InvalidFormatException {
        try (XWPFDocument doc = new XWPFDocument()) {
            XWPFDocument document = new XWPFDocument(OPCPackage.open("akt.docx"));
            System.out.println(document.toString());
            for (XWPFParagraph paragraph : document.getParagraphs()) {
                for (XWPFRun run : paragraph.getRuns()) {
                    String text = run.getText(0);
                    text = text.replace("date", fuelUsage.getUsagedate().toString());
                    text = text.replace("quantity", fuelUsage.getUsageamount().toString());
                    text = text.replace("price", "100");
                    text = text.replace("reason", "Путевой лист 1");
                    run.setText(text, 0);
                }
            }
            for (XWPFTable table : document.getTables()) {
                for (XWPFTableRow run : table.getRows()) {

//                    for (XWPFTableCell cells : run.getTableCells()) {
//                        String text = cells.getText();
//                        text = text.replace("fuel", fuelUsage.getFuelType().getName());
//                        text = text.replace("quantity", fuelUsage.getUsageamount().toString());
//                        text = text.replace("vehicle", fuelUsage.getUsageamount().toString());
//                        text = text.replace("price", "100");
//                        text = text.replace("reason", "Путевой лист 1");
//                        cells.setText(text);
//                    }

                }
                table.getRow(1).getTableCells().get(1).setText(fuelUsage.getFuelType().getName());
                table.getRow(1).getTableCells().get(3).setText(fuelUsage.getUsageamount().toString());
                table.getRow(1).getTableCells().get(0).setText(fuelUsage.getVehicle().getModel());
                table.getRow(1).getTableCells().get(4).setText("100");
                table.getRow(1).getTableCells().get(5).setText("100");
                table.getRow(1).getTableCells().get(6).setText("Путевой лист" +fuelUsage.getRouteList().getId());
            }

            ByteArrayOutputStream b = new ByteArrayOutputStream();
            document.write(b);
            return new ByteArrayInputStream(b.toByteArray());
        }

    }

    public static ByteArrayInputStream generateDelivery(FuelDelivery fuelDelivery)
            throws FileNotFoundException, IOException, InvalidFormatException {
        try (XWPFDocument doc = new XWPFDocument()) {
            XWPFDocument document = new XWPFDocument(OPCPackage.open("delivery.docx"));
            System.out.println(document.toString());
            for (XWPFParagraph paragraph : document.getParagraphs()) {
                for (XWPFRun run : paragraph.getRuns()) {
                    String text = run.getText(0);
                    text = text.replace("date", fuelDelivery.getDeliverydate().toString());
                    text = text.replace("fuel", fuelDelivery.getFuelType().getName());
                    text = text.replace("quantity", fuelDelivery.getQuantity().toString());
                    text = text.replace("price", fuelDelivery.getPrice().toString());
                    run.setText(text, 0);
                }
            }
            ByteArrayOutputStream b = new ByteArrayOutputStream();
            document.write(b);
            return new ByteArrayInputStream(b.toByteArray());
        }

    }
}
