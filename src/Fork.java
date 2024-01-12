public class Fork {
    private int number;
    private boolean isFree; // свободна ли вилка или философ ест ею
    private boolean isValid; // валидна ли вилка для конкретного философа

    public Fork(int number) {
        this.number = number;
        isFree = true;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        this.isFree = free;
    }

    public boolean getValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        this.isValid = valid;
    }

    public int getNumber() {
        return number;
    }
}
