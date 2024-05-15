package ca.bcit.comp2601.bank;

import java.util.HashMap;
import java.util.Map;

/**
 * @author walter chu & margaryta lvova
 * @version 1.0
 */
public class Date
{
    public static final int MINIMUM_YEAR                        = 1;
    public static final int CURRENT_YEAR                        = 2024;
    public static final int MINIMUM_MONTH_NUMBER                = 1;
    public static final int MAXIMUM_MONTH_NUMBER                = 12;
    public static final int LEAP_YEAR_TRUE_IRREGULARITY         = 400;
    public static final int LEAP_YEAR_FALSE_IRREGULARITY        = 100;
    public static final int LEAP_YEAR_FREQUENCY                 = 4;
    public static final int LEAP_YEAR_ALLOWABLE_REMAINDER       = 0;
    public static final int DAYS_IN_JAN_MAR_MAY_JUL_AUG_OCT_DEC = 31;
    public static final int DAYS_IN_APR_JUN_SEP_NOV             = 30;
    public static final int DAYS_IN_NORMAL_FEB                  = 28;
    public static final int DAYS_IN_LEAP_YEAR_FEB               = 29;
    public static final int JANUARY_INDEX                       = 1;
    public static final int FEBRUARY_INDEX                      = 2;
    public static final int MARCH_INDEX                         = 3;
    public static final int APRIL_INDEX                         = 4;
    public static final int MAY_INDEX                           = 5;
    public static final int JUNE_INDEX                          = 6;
    public static final int JULY_INDEX                          = 7;
    public static final int AUGUST_INDEX                        = 8;
    public static final int SEPTEMBER_INDEX                     = 9;
    public static final int OCTOBER_INDEX                       = 10;
    public static final int NOVEMBER_INDEX                      = 11;
    public static final int DECEMBER_INDEX                      = 12;
    public static final int SATURDAY_INDEX                      = 0;
    public static final int SUNDAY_INDEX                        = 1;
    public static final int MONDAY_INDEX                        = 2;
    public static final int TUESDAY_INDEX                       = 3;
    public static final int WEDNESDAY_INDEX                     = 4;
    public static final int THURSDAY_INDEX                      = 5;
    public static final int FRIDAY_INDEX                        = 6;
    public static final int FIRST_CENTURY_INDEX                 = 0;
    public static final int SECOND_CENTURY_INDEX                = 1;
    public static final int THIRD_CENTURY_INDEX                 = 2;
    public static final int FOURTH_CENTURY_INDEX                = 3;
    public static final int MINIMUM_DAY_OF_MONTH                = 1;
    public static final int CENTURY_DIVISOR                     = 100;
    public static final int WEEKDAYS_FIRST_STEP_DIVISOR         = 12;
    private static final int WEEKDAYS_THIRD_STEP_DIVISOR        = 4;
    private static final int WEEKDAYS_SIXTH_STEP_MODIFIER       = 4;
    private static final int WEEKDAYS_LAST_STEP_DIVISOR         = 7;
    private static final int LEAP_YEAR_MODIFIER                 = 6;

    private static final Map<Integer, Integer> MONTH_CODE = new HashMap<>();
    static
    {
        MONTH_CODE.put(JANUARY_INDEX, 1);
        MONTH_CODE.put(FEBRUARY_INDEX, 4);
        MONTH_CODE.put(MARCH_INDEX, 4);
        MONTH_CODE.put(APRIL_INDEX, 0);
        MONTH_CODE.put(MAY_INDEX, 2);
        MONTH_CODE.put(JUNE_INDEX, 5);
        MONTH_CODE.put(JULY_INDEX, 0);
        MONTH_CODE.put(AUGUST_INDEX, 3);
        MONTH_CODE.put(SEPTEMBER_INDEX, 6);
        MONTH_CODE.put(OCTOBER_INDEX, 1);
        MONTH_CODE.put(NOVEMBER_INDEX, 4);
        MONTH_CODE.put(DECEMBER_INDEX, 6);
    }

    private static final Map<Integer, String> WEEKDAY_CHART = new HashMap<>();
    static
    {
        WEEKDAY_CHART.put(SATURDAY_INDEX, "Saturday");
        WEEKDAY_CHART.put(SUNDAY_INDEX, "Sunday");
        WEEKDAY_CHART.put(MONDAY_INDEX, "Monday");
        WEEKDAY_CHART.put(TUESDAY_INDEX, "Tuesday");
        WEEKDAY_CHART.put(WEDNESDAY_INDEX, "Wednesday");
        WEEKDAY_CHART.put(THURSDAY_INDEX, "Thursday");
        WEEKDAY_CHART.put(FRIDAY_INDEX, "Friday");
    }

    private static final Map<Integer, Integer> CENTURY_MODIFIER = new HashMap<>();
    static
    {
        CENTURY_MODIFIER.put(FIRST_CENTURY_INDEX, 6);
        CENTURY_MODIFIER.put(SECOND_CENTURY_INDEX, 4);
        CENTURY_MODIFIER.put(THIRD_CENTURY_INDEX, 2);
        CENTURY_MODIFIER.put(FOURTH_CENTURY_INDEX, 0);
    }

    private static final Map<Integer, String> MONTH_INDEX = new HashMap<>();
    static
    {
        MONTH_INDEX.put(JANUARY_INDEX, "January");
        MONTH_INDEX.put(FEBRUARY_INDEX, "February");
        MONTH_INDEX.put(MARCH_INDEX, "March");
        MONTH_INDEX.put(APRIL_INDEX, "April");
        MONTH_INDEX.put(MAY_INDEX, "May");
        MONTH_INDEX.put(JUNE_INDEX, "June");
        MONTH_INDEX.put(JULY_INDEX, "July");
        MONTH_INDEX.put(AUGUST_INDEX, "August");
        MONTH_INDEX.put(SEPTEMBER_INDEX, "September");
        MONTH_INDEX.put(OCTOBER_INDEX, "October");
        MONTH_INDEX.put(NOVEMBER_INDEX, "November");
        MONTH_INDEX.put(DECEMBER_INDEX, "December");
    }

    final int year;
    final int month;
    final int day;

    public Date(final int year,
                final int month,
                final int day)
    {
        if(year < MINIMUM_YEAR || year > CURRENT_YEAR)
        {
            throw new IllegalArgumentException("The year must be from " + MINIMUM_YEAR + "to " + CURRENT_YEAR + ".");
        }
        else
        {
            this.year = year;
        }

        if(month < MINIMUM_MONTH_NUMBER || month > MAXIMUM_MONTH_NUMBER)
        {
            throw new IllegalArgumentException("The month must be from " + MINIMUM_MONTH_NUMBER + "to " + MAXIMUM_MONTH_NUMBER + ".");
        }
        else
        {
            this.month = month;
        }

        if(day < MINIMUM_DAY_OF_MONTH)
        {
            throw new IllegalArgumentException("The day cannot be less than " + MINIMUM_DAY_OF_MONTH + ".");
        }
        else
        {
            if(isLeapYear(year) && month == FEBRUARY_INDEX && day > DAYS_IN_LEAP_YEAR_FEB)
            {
                throw new IllegalArgumentException("The day cannot be more than " + DAYS_IN_LEAP_YEAR_FEB + ".");
            }
            else if(month == FEBRUARY_INDEX && day > DAYS_IN_NORMAL_FEB)
            {
                throw new IllegalArgumentException("The day cannot be more than " + DAYS_IN_NORMAL_FEB + ".");
            }
            else if((month == APRIL_INDEX && day > DAYS_IN_APR_JUN_SEP_NOV) ||
                    (month == JUNE_INDEX && day > DAYS_IN_APR_JUN_SEP_NOV) ||
                    (month == SEPTEMBER_INDEX && day > DAYS_IN_APR_JUN_SEP_NOV) ||
                    (month == NOVEMBER_INDEX && day > DAYS_IN_APR_JUN_SEP_NOV))
            {
                throw new IllegalArgumentException("The day cannot be more than " + DAYS_IN_APR_JUN_SEP_NOV + ".");
            }
            else if(day > DAYS_IN_JAN_MAR_MAY_JUL_AUG_OCT_DEC)
            {
                throw new IllegalArgumentException("The day cannot be more than " + DAYS_IN_JAN_MAR_MAY_JUL_AUG_OCT_DEC + ".");
            }
            else
            {
                this.day = day;
            }
        }
    }

    public int getYear()
    {
        return year;
    }

    public int getMonth()
    {
        return month;
    }

    public int getDay()
    {
        return day;
    }

    public String getYYYYMMDD()
    {
        return String.format("%04d-%02d-%02d", this.year, this.month, this.day);
    }

    private boolean isLeapYear(final int year)
    {
        if(year % LEAP_YEAR_TRUE_IRREGULARITY == LEAP_YEAR_ALLOWABLE_REMAINDER)
        {
            return true;
        }
        else if(year % LEAP_YEAR_FALSE_IRREGULARITY == LEAP_YEAR_ALLOWABLE_REMAINDER)
        {
            return false;
        }
        else return year % LEAP_YEAR_FREQUENCY == LEAP_YEAR_ALLOWABLE_REMAINDER;
    }

    public String getDayOfTheWeek()
    {
        final int firstStep  = (this.year % CENTURY_DIVISOR) / WEEKDAYS_FIRST_STEP_DIVISOR;
        final int secondStep = (this.year % CENTURY_DIVISOR) % WEEKDAYS_FIRST_STEP_DIVISOR;
        final int thirdStep  = secondStep / WEEKDAYS_THIRD_STEP_DIVISOR;
        final int fourthStep = this.day + firstStep + secondStep + thirdStep;
        final int fifthStep  = fourthStep + MONTH_CODE.get(month);
        final int sixthStep  = fifthStep + CENTURY_MODIFIER.get((this.year / CENTURY_DIVISOR) % WEEKDAYS_SIXTH_STEP_MODIFIER);
        final int lastStep   = sixthStep % WEEKDAYS_LAST_STEP_DIVISOR;

        if((isLeapYear(this.year) && month == JANUARY_INDEX) || (isLeapYear(this.year) && month == FEBRUARY_INDEX))
        {
            final int extraStep;

            extraStep = (sixthStep + LEAP_YEAR_MODIFIER) % WEEKDAYS_LAST_STEP_DIVISOR;

            return WEEKDAY_CHART.get(extraStep);
        }
        else
        {
            return WEEKDAY_CHART.get(lastStep);
        }
    }

    public String getFormattedDate()
    {
        return MONTH_INDEX.get(this.getMonth()) + " " + this.getDay() + ", " + this.getYear();
    }
}
