public class enumType {
    public enum Day {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
        THURSDAY, FRIDAY, SATURDAY
    }

    public static void main(String[] args) {
        Day day = Day.SATURDAY;
        switch (day) {
            case MONDAY:
                System.out.println("Mondays are bad.");
                break;
            case FRIDAY:
                System.out.println("Fridays are better.");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("Weekends are best.");
                break;
            default:
                System.out.println("Midweek days are so-so.");
                break;
        }

                    int[] numbers = {1,2,3,4,5,6,7,8,9,10};
                    for (int item : numbers) {
                        System.out.println("Count is: " + item);
                    }


        }
    }

