
package com.pluralsight.util;

import com.pluralsight.models.Order;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {
    public void writeReceipt(Order order) {
        try {
            File folder = new File("receipts");
            if (!folder.exists()) folder.mkdir();

            String filename = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss")) + ".txt";
            File file = new File(folder, filename);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write("==== MTA Subs Receipt ====\n");
                writer.write(order.toString());
                writer.write("\n=============================\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing receipt: " + e.getMessage());
        }
    }
}
