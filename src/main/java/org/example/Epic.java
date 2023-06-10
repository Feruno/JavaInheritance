package org.example;

public class Epic extends Task {
    protected String[] subtasks;

    public Epic(int id, String[] sub) {
        super(id);
        this.subtasks = sub;
    }

    public String[] getListEpic() {
        return subtasks;
    }

    @Override
    public boolean matches(String query) {
        for (String i : subtasks) {
            if (i.contains(query)) {
                return true;
            }
        }
        return false;
    }
}
