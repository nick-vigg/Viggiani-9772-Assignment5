package ucf.assignments;

import javafx.stage.FileChooser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class FileManager {
    public static String promptOpenFile() {
        //prompts user for file to open in GUI
        //files are filtered to only .txt, .html
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter txtFilter =
                new FileChooser.ExtensionFilter("TEXT files (*.txt)", "*.txt");
        //FileChooser.ExtensionFilter htmlFilter =
          //      new FileChooser.ExtensionFilter("HTML files (*.html)", "*.html");
        fileChooser.getExtensionFilters().addAll(txtFilter);
        fileChooser.setTitle("Open Resource File");
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            return file.getAbsolutePath();
        }
        return "";
    }

    public static String promptSaveFile() {
        //prompts user to save file from GUI
        //files are filtered to only .txt, .html
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter txtFilter =
                new FileChooser.ExtensionFilter("TEXT files (*.txt)", "*.txt");
        FileChooser.ExtensionFilter htmlFilter =
                new FileChooser.ExtensionFilter("HTML files (*.html)", "*.html");
       // FileChooser.ExtensionFilter jsonFilter =
         //       new FileChooser.ExtensionFilter("JSON files (*.json)", "*.json");
        fileChooser.getExtensionFilters().addAll(txtFilter, htmlFilter);
        fileChooser.setTitle("Save File");
        File file = fileChooser.showSaveDialog(null);
        if (file != null) {
            return file.getAbsolutePath();
        }
        return "";
    }

    public static void writeToFile(String path, List list) {
        //Data stored in ToDoList is written to a file given by the user
        if (path.contains(".txt")) {
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(path));
                bw.write(String.format("%-10s %-2s %-10s %-2s %-10s %-2s \n",
                        "$", "|",
                        "ID", "|",
                        "Name", "|"));
                for (int i = 0; i < list.getSize(); i++) {
                    bw.write(String.format("%-10s %-2s %-10s %-2s %-10s %-2s \n",
                            list.getItem(i).getValue(), "|",
                            list.getItem(i).getId(), "|",
                            list.getItem(i).getName(), "|"));
                }
                bw.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        } else if (path.contains(".html")) {
            try {
                PrintWriter pw = new PrintWriter((new FileWriter(path)));
                pw.println("<table border = 1><tr><th>Value($)<th>Serial Number<th>Name");
                for (int i = 0; i < list.getSize(); i++) {
                    pw.println(String.format("<tr><td>%s<td>%s<td>%s",
                            list.getItem(i).getValue(),
                            list.getItem(i).getId(),
                            list.getItem(i).getName()));
                }
                pw.println("</TABLE>");
                pw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static ArrayList<String> readFromFile(String path) {
        //Data read from .txt file in lines of data
        ArrayList<String> ret = new ArrayList<>();
            try {
                BufferedReader br = new BufferedReader(new FileReader(path));
                br.readLine();
                String line = br.readLine();
                while (line != null) {
                    ret.add(line);
                    line = br.readLine();
                }
                br.close();
            } catch (IOException e) {
                return new ArrayList<>();
            }
        return ret;
    }
}


