import java.util.Comparator;

public class TaskComparator implements Comparator<Task> {

    private SortDirection sortDirection;

    private String field;


    public TaskComparator(SortDirection sortDirection, String field) {
        this.sortDirection = sortDirection;
        this.field = field;
    }

    public int compare(Task o1, Task o2) {
        int direction = (sortDirection == SortDirection.ASC) ? 1 : -1;
        switch (field.toLowerCase()) {
            case "date_created": {
                return o1.getDate().compareTo(o2.getDate()) * direction;
            }
            case "name": {
                return (o1.getTitle().compareTo(o2.getTitle()) * direction);
            }
            default: {
                return 0;
            }
        }
    }
}