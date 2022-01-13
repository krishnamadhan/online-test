package questions;

import java.util.List;

public class SubjectRepo {

    private List<LevelRepo> levels;
    private int max_level;
    public SubjectRepo() {
        max_level=0;
    }

    public List<LevelRepo> getLevels() {
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
