package ToDoList;

public class Task implements Comparable<Task>{

    private String name;
    private boolean finished;
    private String description;
    private String end_data;
    private int priority_level;
    private String category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEnd_data() {
        return end_data;
    }

    public void setEnd_data(String end_data) {
        this.end_data = end_data;
    }

    public int getPriority_level() {
        return priority_level;
    }

    public void setPriority_level(int priority_level) {
        this.priority_level = priority_level;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public int compareTo(Task task) {
        return (this.priority_level - task.getPriority_level());
    }
}
