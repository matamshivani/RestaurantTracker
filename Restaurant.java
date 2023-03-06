import java.util.ArrayList;

public class Restaurant {
    private ArrayList<Table> tables;

    public Restaurant(int[] capacities) {
        tables = new ArrayList<Table>();
        addTables(capacities);
    }

    private void addTables(int[] capacities) {
            for (int i = 0; i < capacities.length; i++) {
                tables.add(new Table(i, capacities[i]));
            }
        
    }

    public ArrayList<Table> getTables() {
        ArrayList<Table> tableList = new ArrayList<>();
        for (Table table : tables) {
            if(table.isAvailable()) {tableList.add(table);}
        }
        return tableList;
    }

    public Table findTable(int groupSize) {
        for (Table table : tables) {
            if (table.isAvailable() && table.getCapacity() >= groupSize) {
                return table;
            }
        }
        return null;
    }

    public Table releaseTable(int tableNumber) {
        for (Table table : tables) {
            if (table.getTableNumber() == tableNumber) {
                table.release();
                return table;
            }
        }
        return null;
    }


}
