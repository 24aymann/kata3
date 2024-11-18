package software.ulpgc.kata3.dirty;

import software.ulpgc.kata3.clean.model.FileTitleLoader;
import software.ulpgc.kata3.clean.control.ToggleChartCommand;
import software.ulpgc.kata3.clean.model.TsvTitleDeserializer;

import java.io.File;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("C://Users/eymen/Downloads/title.basics.tsv");
        MainFrame mainFrame = new MainFrame();
        FileTitleLoader loader = new FileTitleLoader(file, new TsvTitleDeserializer());
        mainFrame.put("Toggle Chart", new ToggleChartCommand(mainFrame.barchartDisplay(), loader));
        mainFrame.setVisible(true);
    }
}