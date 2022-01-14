package questions;

import java.util.List;

public class SubjectRepo {

    private List<LevelRepo> levels;//declaring a list of type LevelRepo where each entity has all the datamembers of that class..
    private int max_level;
    public SubjectRepo() {
        max_level=0;
    }

    public List<LevelRepo> getLevels() {//this function returns the levels list of type Level Repo
        return levels;
    }

    public void setLevels(List<LevelRepo> levels) {
        this.levels = levels;
    }

    public int getMax_level() {
        return max_level;
    }

    public void setMax_level(int max_level) {
        this.max_level = max_level;
    }
}
