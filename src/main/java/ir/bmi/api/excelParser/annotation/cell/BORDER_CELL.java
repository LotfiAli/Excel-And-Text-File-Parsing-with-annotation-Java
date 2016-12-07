package ir.bmi.api.excelParser.annotation.cell;

/**
 * Created by alotfi on 12/7/2016.
 */
public enum BORDER_CELL {
    BORDER_NONE((short) 0),
    BORDER_THIN((short) 1),
    BORDER_MEDIUM((short) 2),
    BORDER_DASHED((short) 3),
    BORDER_HAIR((short) 4),
    BORDER_THICK((short) 5),
    BORDER_DOUBLE((short) 6),
    BORDER_DOTTED((short) 7),
    BORDER_MEDIUM_DASHED((short) 8),
    BORDER_DASH_DOT((short) 9),
    BORDER_MEDIUM_DASH_DOT((short) 10),
    BORDER_DASH_DOT_DOT((short) 11),
    BORDER_MEDIUM_DASH_DOT_DOT((short) 12),
    BORDER_SLANTED_DASH_DOT((short) 13);

    private short value;

    BORDER_CELL(short value) {
        this.value = value;
    }

    public short getValue() {
        return value;
    }
}
