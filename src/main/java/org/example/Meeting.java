package org.example;

public class Meeting extends Task {
    protected String topic;
    protected String project;
    protected String start;

    public Meeting(int id, String topicTem, String proj, String timeStart) {
        super(id);
        this.topic = topicTem;
        this.project = proj;
        this.start = timeStart;
    }

    public String getMeeting() {
        return topic;
    }

    @Override
    public boolean matches(String query) {
        if (topic.contains(query)) {
            return true;
        }
        if (project.contains(query)) {
            return true;
        }
        return false;
    }
}
