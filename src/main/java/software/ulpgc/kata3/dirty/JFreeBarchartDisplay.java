package software.ulpgc.kata3.dirty;

import org.jfree.chart.ChartPanel;
import software.ulpgc.kata3.clean.model.Barchart;
import software.ulpgc.kata3.clean.view.BarchartDisplay;

import javax.swing.*;

public class JFreeBarchartDisplay extends JPanel implements BarchartDisplay {
    @Override
    public void display(Barchart barchart) {
        removeAll();
        add(new ChartPanel(JFreeBarchartAdapter.adapt(barchart)));
        revalidate();
    }
}
