package ir.bmi.api.excelParser.annotation.cell;

/**
 * Created by alotfi on 12/6/2016.
 */
public enum ALIGN_CELL {
    ALIGN_GENERAL((short) 0),
    ALIGN_LEFT((short) 1),
    ALIGN_CENTER((short) 2),
    ALIGN_RIGHT((short) 3),
    ALIGN_FILL((short) 4),
    ALIGN_JUSTIFY((short) 5),
    ALIGN_CENTER_SELECTION((short) 6);

    private short value;

    ALIGN_CELL(short value) {
        this.value = value;
    }

    public short getValue() {
        return value;
    }
}
