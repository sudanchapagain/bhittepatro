import { BikramSambatData, NepaliDate, CalendarDay } from "../types";

export class BikramSambat {
  private readonly bsData: BikramSambatData[] = [
    { year: 2000, months: [30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31] },
    { year: 2001, months: [31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30] },
    { year: 2002, months: [31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30] },
    { year: 2003, months: [31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31] },
    { year: 2004, months: [30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31] },
    { year: 2005, months: [31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30] },
    { year: 2006, months: [31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30] },
    { year: 2007, months: [31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31] },
    { year: 2008, months: [31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 29, 31] },
    { year: 2009, months: [31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30] },
    { year: 2010, months: [31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30] },
    { year: 2011, months: [31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31] },
    { year: 2012, months: [31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30] },
    { year: 2013, months: [31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30] },
    { year: 2014, months: [31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30] },
    { year: 2015, months: [31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31] },
    { year: 2016, months: [31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30] },
    { year: 2017, months: [31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30] },
    { year: 2018, months: [31, 32, 31, 32, 31, 30, 30, 29, 30, 29, 30, 30] },
    { year: 2019, months: [31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31] },
    { year: 2020, months: [31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30] },
    { year: 2021, months: [31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30] },
    { year: 2022, months: [31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30] },
    { year: 2023, months: [31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31] },
    { year: 2024, months: [31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30] },
    { year: 2025, months: [31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30] },
    { year: 2026, months: [31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31] },
    { year: 2027, months: [30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31] },
    { year: 2028, months: [31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30] },
    { year: 2029, months: [31, 31, 32, 31, 32, 30, 30, 29, 30, 29, 30, 30] },
    { year: 2030, months: [31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31] },
    { year: 2031, months: [30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31] },
    { year: 2032, months: [31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30] },
    { year: 2033, months: [31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30] },
    { year: 2034, months: [31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31] },
    { year: 2035, months: [30, 32, 31, 32, 31, 31, 29, 30, 30, 29, 29, 31] },
    { year: 2036, months: [31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30] },
    { year: 2037, months: [31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30] },
    { year: 2038, months: [31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31] },
    { year: 2039, months: [31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30] },
    { year: 2040, months: [31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30] },
    { year: 2041, months: [31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30] },
    { year: 2042, months: [31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31] },
    { year: 2043, months: [31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30] },
    { year: 2044, months: [31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30] },
    { year: 2045, months: [31, 32, 31, 32, 31, 30, 30, 29, 30, 29, 30, 30] },
    { year: 2046, months: [31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31] },
    { year: 2047, months: [31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30] },
    { year: 2048, months: [31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30] },
    { year: 2049, months: [31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30] },
    { year: 2050, months: [31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31] },
    { year: 2051, months: [31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30] },
    { year: 2052, months: [31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30] },
    { year: 2053, months: [31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30] },
    { year: 2054, months: [31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31] },
    { year: 2055, months: [31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30] },
    { year: 2056, months: [31, 31, 32, 31, 32, 30, 30, 29, 30, 29, 30, 30] },
    { year: 2057, months: [31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31] },
    { year: 2058, months: [30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31] },
    { year: 2059, months: [31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30] },
    { year: 2060, months: [31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30] },
    { year: 2061, months: [31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31] },
    { year: 2062, months: [30, 32, 31, 32, 31, 31, 29, 30, 29, 30, 29, 31] },
    { year: 2063, months: [31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30] },
    { year: 2064, months: [31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30] },
    { year: 2065, months: [31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31] },
    { year: 2066, months: [31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 29, 31] },
    { year: 2067, months: [31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30] },
    { year: 2068, months: [31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30] },
    { year: 2069, months: [31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31] },
    { year: 2070, months: [31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30] },
    { year: 2071, months: [31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30] },
    { year: 2072, months: [31, 32, 31, 32, 31, 30, 30, 29, 30, 29, 30, 30] },
    { year: 2073, months: [31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31] },
    { year: 2074, months: [31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30] },
    { year: 2075, months: [31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30] },
    { year: 2076, months: [31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30] },
    { year: 2077, months: [31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31] },
    { year: 2078, months: [31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30] },
    { year: 2079, months: [31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30] },
    { year: 2080, months: [31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30] },
    { year: 2081, months: [31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31] },
    { year: 2082, months: [31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30] },
    { year: 2083, months: [31, 31, 32, 31, 31, 30, 30, 30, 29, 30, 30, 30] },
    { year: 2084, months: [31, 31, 32, 31, 31, 30, 30, 30, 29, 30, 30, 30] },
    { year: 2085, months: [31, 32, 31, 32, 30, 31, 30, 30, 29, 30, 30, 30] },
    { year: 2086, months: [30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 30, 30] },
    { year: 2087, months: [31, 31, 32, 31, 31, 31, 30, 30, 29, 30, 30, 30] },
    { year: 2088, months: [30, 31, 32, 32, 30, 31, 30, 30, 29, 30, 30, 30] },
    { year: 2089, months: [30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 30, 30] },
    { year: 2090, months: [30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 30, 30] },
  ];

  private readonly nepaliMonths = [
    "बैशाख",
    "जेठ",
    "आषाढ",
    "सावन",
    "भदौ",
    "आश्विन",
    "कार्तिक",
    "मार्ग",
    "पुष",
    "माघ",
    "फाल्गुन",
    "चैत",
  ];

  private readonly nepaliMonthsEng = [
    "Baisakh",
    "Jestha",
    "Ashadh",
    "Shrawan",
    "Bhadra",
    "Ashwin",
    "Kartik",
    "Mangshir",
    "Poush",
    "Magh",
    "Falgun",
    "Chaitra",
  ];

  private readonly baseDateAD = new Date(1943, 3, 14);
  private readonly baseDateBS: NepaliDate = { year: 2000, month: 0, day: 1 };

  /**
   * Convert Gregorian date to Nepali date
   */
  public gregorianToNepali(gregorianDate: Date): NepaliDate {
    const daysDiff = Math.floor(
      (gregorianDate.getTime() - this.baseDateAD.getTime()) /
        (1000 * 60 * 60 * 24)
    );

    let totalDays = daysDiff;
    let year = this.baseDateBS.year;
    let month = this.baseDateBS.month;
    let day = this.baseDateBS.day;

    while (totalDays > 0) {
      const yearData = this.bsData.find((data) => data.year === year);
      if (!yearData) break;

      const daysInCurrentMonth = yearData.months[month];
      const remainingDaysInMonth = daysInCurrentMonth - day + 1;

      if (totalDays >= remainingDaysInMonth) {
        totalDays -= remainingDaysInMonth;
        month++;
        if (month >= 12) {
          month = 0;
          year++;
        }
        day = 1;
      } else {
        day += totalDays;
        totalDays = 0;
      }
    }

    return { year, month, day };
  }

  /**
   * Convert Nepali date to Gregorian date
   */
  public nepaliToGregorian(nepaliDate: NepaliDate): Date {
    let totalDays = 0;

    for (let year = this.baseDateBS.year; year < nepaliDate.year; year++) {
      const yearData = this.bsData.find((data) => data.year === year);
      if (yearData) {
        totalDays += yearData.months.reduce((sum, days) => sum + days, 0);
      }
    }

    for (let month = 0; month < nepaliDate.month; month++) {
      const yearData = this.bsData.find(
        (data) => data.year === nepaliDate.year
      );
      if (yearData) {
        totalDays += yearData.months[month];
      }
    }

    totalDays += nepaliDate.day - this.baseDateBS.day;

    const result = new Date(this.baseDateAD);
    result.setDate(result.getDate() + totalDays);
    return result;
  }

  /**
   * Get today's date in Nepali calendar
   */
  public getTodayNepali(): NepaliDate {
    return this.gregorianToNepali(new Date());
  }

  /**
   * Get month name in Nepali
   */
  public getNepaliMonthName(monthIndex: number): string {
    return this.nepaliMonths[monthIndex] || "";
  }

  /**
   * Get month name in English
   */
  public getEnglishMonthName(monthIndex: number): string {
    return this.nepaliMonthsEng[monthIndex] || "";
  }

  /**
   * Get number of days in a specific Nepali month
   */
  public getDaysInMonth(year: number, month: number): number {
    const yearData = this.bsData.find((data) => data.year === year);
    return yearData ? yearData.months[month] : 30;
  }

  /**
   * Format Nepali date as string
   */
  public formatNepaliDate(nepaliDate: NepaliDate): string {
    return `${nepaliDate.year}/${(nepaliDate.month + 1)
      .toString()
      .padStart(2, "0")}/${nepaliDate.day.toString().padStart(2, "0")}`;
  }

  /**
   * Get calendar data for a specific month and year
   */
  public getCalendarData(year: number, month: number): CalendarDay[] {
    const daysInMonth = this.getDaysInMonth(year, month);
    const firstDayNepali: NepaliDate = { year, month, day: 1 };
    const firstDayGregorian = this.nepaliToGregorian(firstDayNepali);
    const startDayOfWeek = firstDayGregorian.getDay();

    const today = new Date();
    const todayNepali = this.gregorianToNepali(today);

    const calendarDays: CalendarDay[] = [];

    for (let i = 0; i < startDayOfWeek; i++) {
      const emptyDay: CalendarDay = {
        day: 0,
        isCurrentMonth: false,
        isToday: false,
        gregorianDate: new Date(),
        nepaliDate: { year: 0, month: 0, day: 0 },
      };
      calendarDays.push(emptyDay);
    }

    for (let day = 1; day <= daysInMonth; day++) {
      const nepaliDate: NepaliDate = { year, month, day };
      const gregorianDate = this.nepaliToGregorian(nepaliDate);
      const isToday =
        nepaliDate.year === todayNepali.year &&
        nepaliDate.month === todayNepali.month &&
        nepaliDate.day === todayNepali.day;

      const calendarDay: CalendarDay = {
        day,
        isCurrentMonth: true,
        isToday,
        gregorianDate,
        nepaliDate,
      };
      calendarDays.push(calendarDay);
    }

    return calendarDays;
  }
}
