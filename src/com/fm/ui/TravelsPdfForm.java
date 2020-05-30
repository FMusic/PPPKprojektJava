package com.fm.ui;

import com.fm.db.I6;
import com.fm.model.generated.TravelWarrantsEntity;
import org.hibernate.cfg.NotYetImplementedException;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class TravelsPdfForm extends JFrame{
    private JButton xmlBillsButton;
    private JButton warrantPdfButton;
    private JPanel pnlMain;
    private JList listWarrants;
    private JButton billsToXmlButton;
    private JPanel pnlCombo;
    private JComboBox<String> cbWarrants;
    private TravelWarrantsEntity[] travelWarrants;
    private String[] warrantsStrings;

    public TravelsPdfForm() {
        initData();
        initWidgets();
        setForm();
    }

    private void initData() {
        List<TravelWarrantsEntity> warrants = I6.getAllWarrants();
        travelWarrants = new TravelWarrantsEntity[warrants.size()];
        warrantsStrings = new String[warrants.size()];
        for (int i = 0; i < warrants.size(); i++) {
            travelWarrants[i] = warrants.get(i);
            warrantsStrings[i] = warrants.get(i).toString();
        }
    }

    private void initWidgets() {
        listWarrants.setListData(warrantsStrings);
        xmlBillsButton.addActionListener(e -> inputBillsFromXml());
        warrantPdfButton.addActionListener(e -> printWarrantToPdf());
        billsToXmlButton.addActionListener(e -> billsToXml());
    }

    private void billsToXml() {
        File file = askForFile();
        String content = I6.getXmlReceipts();
        try {
            PrintStream ps = new PrintStream(file);
            ps.println(content);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void printWarrantToPdf() {
        String path = null;
        File file = askForFile();
        if (file != null) {
            path = file.getAbsolutePath();
        }
        int selectedIndex = listWarrants.getSelectedIndex();
        if (path != null && selectedIndex != 0) {
            try {
                I6.getPdfForWarrant(travelWarrants[selectedIndex], path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private File askForFile() {
        JFrame frame = new JFrame();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");
        int sel = fileChooser.showSaveDialog(frame);
        if (sel == JFileChooser.APPROVE_OPTION){
            return fileChooser.getSelectedFile();
        }
        return null;
    }

    private void inputBillsFromXml() {
        JFileChooser jfc = new JFileChooser();
        File selectedFile = null;
        int result = jfc.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION){
            selectedFile = jfc.getSelectedFile();
        }
        StringBuilder sb = new StringBuilder();
        if (selectedFile != null) {
            try {
                Scanner sc = new Scanner(selectedFile);
                while(sc.hasNextLine()){
                    sb.append(sc.nextLine());
                }
                sc.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        I6.saveXmlReceipts(sb.toString());
    }

    private void setForm() {
        setContentPane(pnlMain);
        setSize(500, 600);
        setVisible(true);
    }
}
