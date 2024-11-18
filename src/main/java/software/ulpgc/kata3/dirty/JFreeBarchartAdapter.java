package software.ulpgc.kata3.dirty;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import software.ulpgc.kata3.clean.model.Barchart;

public class JFreeBarchartAdapter {
    public static JFreeChart adapt(Barchart barchart) {
        return ChartFactory.createBarChart(
                "",
                barchart.getTitle(),
                "Count",
                datasetOf(barchart)
        );
    }

    private static CategoryDataset datasetOf(Barchart barchart) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (String category: barchart.categories()) {
            dataset.addValue(barchart.get(category), "", category);
        }
        return dataset;
    }
}
