export interface NepaliDate {
  year: number;
  month: number;
  day: number;
}

export interface BikramSambatData {
  year: number;
  months: number[];
}

export interface CalendarDay {
  day: number;
  isCurrentMonth: boolean;
  isToday: boolean;
  gregorianDate: Date;
  nepaliDate: NepaliDate;
}

export type WeekDay = "Sun" | "Mon" | "Tue" | "Wed" | "Thu" | "Fri" | "Sat";
