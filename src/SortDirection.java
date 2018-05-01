public enum SortDirection {
    ASC("asc"), DESC("desc");

    private String direction;

    SortDirection(String direction) {
        this.direction = direction;
    }

    public String getDirection() {
        return direction;
    }

    public static SortDirection getDirectionFromString(String direction) {
        SortDirection[] sortDirections = SortDirection.values();
        for (SortDirection sortDirection: sortDirections) {
            if (sortDirection.getDirection().equals(direction)) {
                return sortDirection;
            }
        }
        return null;
    }
}
