import React, { useMemo } from "react";
import {
  StyleSheet,
  Text,
  View,
  SafeAreaView,
  StatusBar,
  ScrollView,
} from "react-native";
import {
  useFonts,
  Inter_400Regular,
  Inter_500Medium,
  Inter_600SemiBold,
  Inter_700Bold,
} from "@expo-google-fonts/inter";
import { Calendar } from "./src/components";
import { BikramSambat } from "./src/utils";
import { NepaliDate } from "./src/types";
import { Colors, Spacing, Typography } from "./src/constants";

export default function App() {
  const [fontsLoaded] = useFonts({
    Inter_400Regular,
    Inter_500Medium,
    Inter_600SemiBold,
    Inter_700Bold,
  });

  const bikramSambat = useMemo(() => new BikramSambat(), []);
  const todayNepali = useMemo(
    () => bikramSambat.getTodayNepali(),
    [bikramSambat]
  );
  const todayGregorian = new Date();

  const handleDateSelect = (date: NepaliDate) => {
    console.log("Selected date:", bikramSambat.formatNepaliDate(date));
  };

  if (!fontsLoaded) {
    return null;
  }

  return (
    <SafeAreaView style={styles.container}>
      <StatusBar barStyle="dark-content" backgroundColor={Colors.background} />
      <ScrollView contentContainerStyle={styles.scrollContent}>
        <View style={styles.header}>
          <Text style={styles.appTitle}>bhittepatro</Text>
        </View>

        <View style={styles.todaySection}>
          <Text style={styles.todayLabel}>Today's Date</Text>
          <Text style={styles.nepaliDate}>
            {bikramSambat.formatNepaliDate(todayNepali)}
          </Text>
          <Text style={styles.englishDate}>
            {todayGregorian.toLocaleDateString("en-US", {
              weekday: "long",
              year: "numeric",
              month: "long",
              day: "numeric",
            })}
          </Text>
        </View>

        <Calendar onDateSelect={handleDateSelect} />
      </ScrollView>
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: Colors.background,
  },
  scrollContent: {
    flexGrow: 1,
  },
  header: {
    alignItems: "center",
    paddingVertical: Spacing.lg,
    paddingHorizontal: Spacing.md,
  },
  appTitle: {
    fontSize: Typography.fontSize.xxl,
    fontWeight: Typography.fontWeight.bold,
    fontFamily: Typography.fontFamily.bold,
    color: Colors.text.primary,
  },
  todaySection: {
    alignItems: "center",
    paddingVertical: Spacing.xl,
    paddingHorizontal: Spacing.md,
  },
  todayLabel: {
    fontSize: Typography.fontSize.md,
    fontWeight: Typography.fontWeight.semibold,
    fontFamily: Typography.fontFamily.semibold,
    color: Colors.text.secondary,
    marginBottom: Spacing.sm,
  },
  nepaliDate: {
    fontSize: Typography.fontSize.xxxl,
    fontWeight: Typography.fontWeight.bold,
    fontFamily: Typography.fontFamily.bold,
    color: Colors.primary,
    marginBottom: Spacing.xs,
  },
  englishDate: {
    fontSize: Typography.fontSize.sm,
    fontFamily: Typography.fontFamily.regular,
    color: Colors.text.tertiary,
  },
});
