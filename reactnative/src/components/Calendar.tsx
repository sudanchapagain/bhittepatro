import React, { useState, useMemo } from "react";
import { View, Text, TouchableOpacity, StyleSheet } from "react-native";
import { Ionicons } from "@expo/vector-icons";
import { BikramSambat } from "../utils/BikramSambat";
import { NepaliDate, CalendarDay, WeekDay } from "../types";
import { Colors, Spacing, BorderRadius, Typography } from "../constants";

const WEEK_DAYS: WeekDay[] = ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"];

interface CalendarProps {
  onDateSelect?: (date: NepaliDate) => void;
}

export const Calendar: React.FC<CalendarProps> = ({ onDateSelect }) => {
  const bikramSambat = useMemo(() => new BikramSambat(), []);

  const todayNepali = useMemo(
    () => bikramSambat.getTodayNepali(),
    [bikramSambat]
  );

  const [currentYear, setCurrentYear] = useState(todayNepali.year);
  const [currentMonth, setCurrentMonth] = useState(todayNepali.month);

  const calendarData = useMemo(
    () => bikramSambat.getCalendarData(currentYear, currentMonth),
    [bikramSambat, currentYear, currentMonth]
  );

  const navigateMonth = (direction: "prev" | "next") => {
    if (direction === "prev") {
      if (currentMonth === 0) {
        setCurrentMonth(11);
        setCurrentYear(currentYear - 1);
      } else {
        setCurrentMonth(currentMonth - 1);
      }
    } else {
      if (currentMonth === 11) {
        setCurrentMonth(0);
        setCurrentYear(currentYear + 1);
      } else {
        setCurrentMonth(currentMonth + 1);
      }
    }
  };

  const handleDayPress = (day: CalendarDay) => {
    if (day.isCurrentMonth && onDateSelect) {
      onDateSelect(day.nepaliDate);
    }
  };

  const renderCalendarDay = (day: CalendarDay, index: number) => {
    if (!day.isCurrentMonth) {
      return <View key={index} style={styles.emptyDay} />;
    }

    return (
      <TouchableOpacity
        key={index}
        style={[styles.dayContainer, day.isToday && styles.todayContainer]}
        onPress={() => handleDayPress(day)}
        activeOpacity={0.7}
      >
        <Text style={[styles.dayText, day.isToday && styles.todayText]}>
          {day.day}
        </Text>
      </TouchableOpacity>
    );
  };

  return (
    <View style={styles.container}>
      <View style={styles.header}>
        <TouchableOpacity
          onPress={() => navigateMonth("prev")}
          style={styles.navButton}
        >
          <Ionicons
            name="chevron-back"
            size={24}
            color={Colors.text.secondary}
          />
        </TouchableOpacity>

        <Text style={styles.monthYearText}>
          {bikramSambat.getEnglishMonthName(currentMonth)} {currentYear}
        </Text>

        <TouchableOpacity
          onPress={() => navigateMonth("next")}
          style={styles.navButton}
        >
          <Ionicons
            name="chevron-forward"
            size={24}
            color={Colors.text.secondary}
          />
        </TouchableOpacity>
      </View>

      <View style={styles.weekDaysContainer}>
        {WEEK_DAYS.map((day) => (
          <View key={day} style={styles.weekDayContainer}>
            <Text style={styles.weekDayText}>{day}</Text>
          </View>
        ))}
      </View>

      <View style={styles.calendarGrid}>
        {Array.from(
          { length: Math.ceil(calendarData.length / 7) },
          (_, weekIndex) => (
            <View key={weekIndex} style={styles.weekRow}>
              {Array.from({ length: 7 }, (_, dayIndex) => {
                const dataIndex = weekIndex * 7 + dayIndex;
                const day = calendarData[dataIndex];
                return day ? (
                  renderCalendarDay(day, dataIndex)
                ) : (
                  <View key={`empty-${dataIndex}`} style={styles.emptyDay} />
                );
              })}
            </View>
          )
        )}
      </View>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    backgroundColor: Colors.background,
    paddingHorizontal: Spacing.md,
    paddingTop: Spacing.lg,
    maxWidth: 500,
    alignSelf: "center",
    width: "100%",
  },
  header: {
    flexDirection: "row",
    justifyContent: "space-between",
    alignItems: "center",
    marginBottom: Spacing.lg,
  },
  navButton: {
    padding: Spacing.sm,
  },
  monthYearText: {
    fontSize: Typography.fontSize.xl,
    fontWeight: Typography.fontWeight.semibold,
    fontFamily: Typography.fontFamily.semibold,
    color: Colors.text.primary,
  },
  weekDaysContainer: {
    flexDirection: "row",
    marginBottom: Spacing.sm,
  },
  weekDayContainer: {
    flex: 1,
    alignItems: "center",
    paddingVertical: Spacing.sm,
  },
  weekDayText: {
    fontSize: Typography.fontSize.sm,
    fontWeight: Typography.fontWeight.semibold,
    fontFamily: Typography.fontFamily.semibold,
    color: Colors.text.secondary,
  },
  calendarGrid: {
    paddingHorizontal: 0,
  },
  weekRow: {
    flexDirection: "row",
    justifyContent: "space-between",
  },
  dayContainer: {
    flex: 1,
    aspectRatio: 1,
    justifyContent: "center",
    alignItems: "center",
    marginVertical: 1,
    marginHorizontal: 1,
  },
  emptyDay: {
    flex: 1,
    aspectRatio: 1,
  },
  dayText: {
    fontSize: Typography.fontSize.md,
    fontFamily: Typography.fontFamily.medium,
    color: Colors.text.primary,
  },
  todayContainer: {
    backgroundColor: Colors.primary,
    borderRadius: BorderRadius.round,
    margin: 2,
  },
  todayText: {
    color: Colors.background,
    fontWeight: Typography.fontWeight.semibold,
    fontFamily: Typography.fontFamily.semibold,
  },
});
