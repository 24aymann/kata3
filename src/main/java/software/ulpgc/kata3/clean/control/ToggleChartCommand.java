package software.ulpgc.kata3.clean.control;

import software.ulpgc.kata3.clean.model.Barchart;
import software.ulpgc.kata3.clean.model.Title;
import software.ulpgc.kata3.clean.model.TitleLoader;
import software.ulpgc.kata3.clean.view.BarchartDisplay;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ToggleChartCommand implements Command {
    private final BarchartDisplay barchartDisplay;
    private final TitleLoader titleLoader;

    public ToggleChartCommand(BarchartDisplay barchartDisplay, TitleLoader titleLoader) {
        this.barchartDisplay = barchartDisplay;
        this.titleLoader = titleLoader;
    }

    private int i = 0;
    @Override
    public void execute() {
        Barchart nextBarchart;
        try {
            nextBarchart = getBarchart(++i);
        }
        catch (IOException e) {
            e.printStackTrace();
            return;
        }
        barchartDisplay.display(nextBarchart);
    }

    private Barchart getBarchart(int index) throws IOException {
        List<Title> titles = titleLoader.load();
        return index % 2 == 0 ?
                genreBarchart(titles) :
                adultContentBarchart(titles);
    }

    private Barchart adultContentBarchart(List<Title> titles) {
        Barchart barchart = new Barchart("Adult Content");
        Map<String, Integer> adultsCount = new HashMap<>();

        adultsCount.put("Adult", 0);
        adultsCount.put("Non Adult", 0);

        for (Title title : titles) {
            if (title.isAdult()) {
                adultsCount.put("Adult", adultsCount.get("Adult") + 1);
            } else {
                adultsCount.put("Non Adult", adultsCount.get("Non Adult") + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : adultsCount.entrySet()) {
            barchart.add(entry.getKey(), entry.getValue());
        }
        return barchart;
    }

    private Barchart genreBarchart(List<Title> titles) {
        Barchart barchart = new Barchart("Genres");
        Map<String, Integer> genreCount = new HashMap<>();
        for (Title title : titles) {
            for (String genre : title.getGenre()) {
                genreCount.put(genre, genreCount.getOrDefault(genre, 0) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : genreCount.entrySet()) {
            barchart.add(entry.getKey(), entry.getValue());
        }
        return barchart;
    }
}